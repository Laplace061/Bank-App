package com.guide.bank.app.service.impl;

import com.guide.bank.app.dto.AccountDto;
import com.guide.bank.app.mapper.AccountMapper;
import com.guide.bank.app.model.Account;
import com.guide.bank.app.repository.AccountRepository;
import com.guide.bank.app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(UUID accountId) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() ->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(UUID accountId, double amount) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() ->new RuntimeException("Account does not exist"));
       double total = account.getBalance() + amount;
       account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(UUID accountId, double amount) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() ->new RuntimeException("Account does not exist"));
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(UUID accountId) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() ->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(accountId);

    }

}

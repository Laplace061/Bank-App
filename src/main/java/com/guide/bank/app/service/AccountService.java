package com.guide.bank.app.service;

import com.guide.bank.app.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(UUID accountId);

    AccountDto deposit(UUID accountId, double amount);

    AccountDto withdraw(UUID accountId, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(UUID accountId);

}

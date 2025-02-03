package com.guide.bank.app.service;

import com.guide.bank.app.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(UUID accountId);
}

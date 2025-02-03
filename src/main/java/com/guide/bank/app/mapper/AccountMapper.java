package com.guide.bank.app.mapper;

import com.guide.bank.app.dto.AccountDto;
import com.guide.bank.app.model.Account;

public class AccountMapper {


    public  static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getAccountId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getCreatedOn(),
                accountDto.getUpdatedOn()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getAccountId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getCreatedOn(),
                account.getUpdatedOn()
        );
        return accountDto;
    }

    // map Account model to AccountDto
//    public static AccountDto mapToAccountDto(Account account){
//         return AccountDto.builder()
//                .accountId(account.getAccountId())
//                .accountHolderName(account.getAccountHolderName())
//                .balance(account.getBalance())
//                .createdOn(account.getCreatedOn())
//                .updatedOn(account.getUpdatedOn())
//                .build();
//    }

    // map AccountDto to Account model
//    public static Account mapToAccount(AccountDto accountDto){
//        return Account.builder()
//                .accountId(accountDto.getAccountId())
//                .accountHolderName(accountDto.getAccountHolderName())
//                .balance(accountDto.getBalance())
//                .createdOn(accountDto.getCreatedOn())
//                .updatedOn(accountDto.getUpdatedOn())
//                .build();
//    }



}

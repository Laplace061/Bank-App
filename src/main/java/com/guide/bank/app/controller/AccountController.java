package com.guide.bank.app.controller;

import com.guide.bank.app.dto.AccountDto;
import com.guide.bank.app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account REST API
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(UUID accountId) {
        AccountDto accountDto = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }
    // Deposit REST API
    @PutMapping("/{accountId}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable UUID accountId,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(accountId, amount);
        return ResponseEntity.ok(accountDto);
    }
    // Withdraw REST API
    @PutMapping("/{accountId}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable UUID accountId,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(accountId, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity <List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}

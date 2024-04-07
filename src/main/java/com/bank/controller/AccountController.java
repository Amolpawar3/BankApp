package com.bank.controller;

import com.bank.entity.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    // Create account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account account_save = accountService.createAccount(account);
        return  ResponseEntity.status(HttpStatus.CREATED).body(account_save);
    }

    // get  account details hy accountnuber
    @GetMapping("/{id}")
    public Optional<Account> getbyid(@PathVariable Long id){
        return accountService.getAccountDetailsByAccountNumber(id);
    }

    // get all account detalis
    @GetMapping
    public List<Account> getAllAcoountDetails(){
        return accountService.getAllAccountDetails();
    }

    // deposite amout
    @PutMapping("/d/{id}/{amount}")
    public Account depositeAmount(@PathVariable Long id,Double amount){
        return accountService.depositAmount(id,amount);
    }

    @PutMapping("/w/{id}/{amount}")
    public Account withdrwaAmount(@PathVariable Long id,Double amount){
        return accountService.withdrwaAmount(id,amount);
    }

    @DeleteMapping("{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        accountService.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("close account");
    }

}

package com.bank.service;

import com.bank.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account createAccount(Account account);
    public Optional<Account> getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber,Double amount);
    public Account withdrwaAmount(Long accountNumber,Double amount);
    public Account closeAccount(Long id);

}

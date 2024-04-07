package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountDetailsByAccountNumber(Long accountNumber) {
        return accountRepository.findById(accountNumber);
    }

    @Override
    public List<Account> getAllAccountDetails() {
        return accountRepository.findAll();
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("account is not present");
        }
        Account accountp = account.get();
        Double totaolB =accountp.getAccoutn_balance()+amount;
        accountp.setAccoutn_balance(totaolB);
        accountRepository.save(accountp);
        return accountp;
    }

    @Override
    public Account withdrwaAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("account is not present");
        }
        Account accountp = account.get();
        Double totaolB =accountp.getAccoutn_balance()-amount;
        accountp.setAccoutn_balance(totaolB);
        accountRepository.save(accountp);
        return accountp;
    }

    @Override
    public Account closeAccount(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("account is not present");
        }
        accountRepository.deleteById(accountNumber);
        return null;
    }
}

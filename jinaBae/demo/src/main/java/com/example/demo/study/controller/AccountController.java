package com.example.demo.study.controller;

import com.example.demo.study.controller.request.AccountRequest;
import com.example.demo.study.controller.request.FindAccountRequest;
import com.example.demo.study.entity.Account;
import com.example.demo.study.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account/test")
    public Account justAccountTest() {
        return new Account ("userId", "password");
    }

    @PostMapping("/account/create")
    public Account createAccount(@RequestBody AccountRequest request) {

        log.info("createAccount -> request: {}", request);
        Account accountRequest = request.toAccount();

        return accountRepository.save(accountRequest);
    }

    @PostMapping("/account/find")
    public Account findAccount(@RequestBody FindAccountRequest request) {
        log.info("findAccount -> request: {}", request);
        Long accountId = request.getAccountId();
        Optional<Account> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()){
            return null;
        }
        return maybeAccount.get();
    }

    @GetMapping("/account/read/{id}")
    public Account readAccount(@PathVariable Long id){
        log.info("readAccount -> id: {}", id);
        Optional<Account> maybeAccount = accountRepository.findById(id);

        if (maybeAccount.isEmpty()){
            return null;
        }
        return maybeAccount.get();
    }

    @GetMapping("/account/list")
    public List<Account> listAccount(){
        log.info("listAccount");
        return accountRepository.findAll();
    }

    @GetMapping("/account/delete")
    public void accountDelete(@PathVariable Long id){
        log.info("deleteAccount -> id: {}", id);
        accountRepository.deleteById(id);
    }
}

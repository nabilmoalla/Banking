package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.exceptions.AccountNotFoundException;

import java.util.Optional;

public class DepositAccountUseCase {

    private final AccountRepository accountRepository;

    public DepositAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(Long id, Money amount) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.getById(id);
        Account account = optionalAccount.orElseThrow(() -> new AccountNotFoundException("Account not found !"));
        account.deposit(amount);
        accountRepository.save(account);
    }

}

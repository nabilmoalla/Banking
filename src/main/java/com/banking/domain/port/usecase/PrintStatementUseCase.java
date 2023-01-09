package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.exceptions.AccountNotFoundException;

import java.util.Optional;

public class PrintStatementUseCase {

    private final AccountRepository accountRepository;

    public PrintStatementUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String print(Long id) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.getById(id);
        Account account = optionalAccount.orElseThrow(() -> new AccountNotFoundException("Account not found !"));
        return account.printStatement();
    }
}

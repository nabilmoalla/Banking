package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.port.secondary.AccountRepository;

public class PrintStatementUseCase {

    private final AccountRepository accountRepository;

    public PrintStatementUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String print(Long id) {
        Account account = accountRepository.getById(id);
        return account.printStatement();
    }
}

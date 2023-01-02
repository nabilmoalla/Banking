package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.port.secondary.AccountRepository;

public class DepositAccountUseCase {

    private final AccountRepository accountRepository;

    public DepositAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(Long id, Money amount) {
        Account account = accountRepository.getById(id);
        account.deposit(amount);
    }

}

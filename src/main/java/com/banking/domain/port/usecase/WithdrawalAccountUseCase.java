package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.exceptions.InsuffisantBalanceException;

public class WithdrawalAccountUseCase {

    private final AccountRepository accountRepository;

    public WithdrawalAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(Long id, Money amount) throws InsuffisantBalanceException {
        Account account = accountRepository.getById(id);
        account.withdraw(amount);
    }

}

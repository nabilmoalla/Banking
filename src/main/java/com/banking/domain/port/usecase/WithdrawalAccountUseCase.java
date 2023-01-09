package com.banking.domain.port.usecase;

import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.exceptions.AccountNotFoundException;
import com.banking.exceptions.InsuffisantBalanceException;

import java.util.Optional;

public class WithdrawalAccountUseCase {

    private final AccountRepository accountRepository;

    public WithdrawalAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(Long id, Money amount) throws InsuffisantBalanceException, AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.getById(id);
        Account account = optionalAccount.orElseThrow(() -> new AccountNotFoundException("Account not found !"));
        account.withdraw(amount);
        accountRepository.save(account);
    }

}

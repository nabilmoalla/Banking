package com.banking.domain.port.secondary;

import com.banking.domain.model.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> getById(Long id);

    void save(Account account);

}

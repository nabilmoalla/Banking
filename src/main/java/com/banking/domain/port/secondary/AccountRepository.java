package com.banking.domain.port.secondary;

import com.banking.domain.model.Account;

public interface AccountRepository {

    Account getById(Long id);

}

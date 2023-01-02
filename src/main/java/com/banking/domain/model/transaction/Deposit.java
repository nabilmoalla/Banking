package com.banking.domain.model.transaction;

import com.banking.domain.model.Money;
import com.banking.enumeration.OperationType;

import java.time.LocalDateTime;

public class Deposit extends Transaction {

    public Deposit(Money amount, LocalDateTime date, Money currentBalance) {
        super(amount, date, currentBalance);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.DEPOSIT;
    }
}

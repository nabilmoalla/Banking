package com.banking.domain.model.transaction;

import com.banking.domain.model.Money;

import java.time.LocalDateTime;

public class Withdrawal extends Transaction{


    public Withdrawal(Money amount, LocalDateTime date, Money currentBalance) {
        super(amount, date, currentBalance);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.WITHDRAWAL;
    }
}

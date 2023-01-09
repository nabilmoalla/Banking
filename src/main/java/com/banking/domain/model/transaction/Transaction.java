package com.banking.domain.model.transaction;

import com.banking.domain.model.Money;

import java.time.LocalDateTime;

public abstract class Transaction{

    protected Money amount;

    protected LocalDateTime date;

    protected Money currentBalance;

    public Transaction(Money amount, LocalDateTime date, Money currentBalance) {
        this.amount = amount;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Money getCurrentBalance() {
        return currentBalance;
    }

    public void print(StringBuilder builder, Transaction transaction) {
        builder.append(transaction.getOperationType()).append("\t|\t").append(transaction.getDate()).append("\t|\t")
                .append(transaction.getAmount().moneyRepresentation()).append("\t|\t").append(transaction.getCurrentBalance().moneyRepresentation());
    }

    public abstract OperationType getOperationType();

}

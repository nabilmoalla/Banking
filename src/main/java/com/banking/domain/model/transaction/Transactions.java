package com.banking.domain.model.transaction;

import com.banking.domain.model.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<Transaction> transactionList = new ArrayList<>();

    public void add(Transaction transaction) {
        transactionList.add(transaction);
    }

    public List<Transaction> getAll() {
        return transactionList;
    }

    public String printTransactions() {
        StringBuilder builder = new StringBuilder();
        builder.append("Operation\t|\t").append("Date\t|\t").append("Amount\t|\t").append("Balance").append("\n");
        transactionList.sort((t1, t2) -> t2.getDate().compareTo(t1.getDate()));
        transactionList.forEach(transaction -> {
            transaction.print(builder, transaction);
            if (transactionList.indexOf(transaction) < transactionList.size() - 1) {
                builder.append("\n");
            }
        });
        return builder.toString();
    }
}

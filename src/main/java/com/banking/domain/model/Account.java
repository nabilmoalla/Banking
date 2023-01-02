package com.banking.domain.model;

import com.banking.domain.model.transaction.Deposit;
import com.banking.domain.model.transaction.Transaction;
import com.banking.domain.model.transaction.Transactions;
import com.banking.domain.model.transaction.Withdrawal;
import com.banking.exceptions.InsuffisantBalanceException;

import java.time.LocalDateTime;

public class Account {

    private final Long id;

    private Money balance;

    private Transactions transactions;
    public Account(Long id, Money initialBalance, Transactions transactions){
        this.id = id;
        this.balance = initialBalance;
        this.transactions = transactions;
    }

    public Money getBalance() {
        return balance;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void deposit(Money amount){
        balance = balance.add(amount);
        Transaction deposit = new Deposit(amount, LocalDateTime.now(),balance);
        transactions.add(deposit);
    }

    public void withdraw(Money amount) throws InsuffisantBalanceException {
        if(amount.isGreaterThan(balance)){
            throw new InsuffisantBalanceException("Transaction Failed ! You do not have a sufficient balance");
        }
        balance = balance.subtract(amount);
        Transaction withdrawal = new Withdrawal(amount, LocalDateTime.now(),balance);
        transactions.add(withdrawal);
    }

    public String printStatement(){
        return transactions.printTransactions();
    }
}

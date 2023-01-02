package com.banking.exceptions;

public class InsuffisantBalanceException extends Exception{

    public InsuffisantBalanceException(String message){
        super(message);
    }
}

package com.banking.domain.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Money {


    private DecimalFormat decimalFormat = new DecimalFormat("#.00$");
    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public static Money of(BigDecimal value){
        return new Money(value);
    }


    public Money add(Money money) {
        return of(this.value.add(money.value));
    }

    public Money subtract(Money money) {
        return of(this.value.subtract(money.value));
    }

    public boolean isGreaterThan(Money money) {
        return this.value.compareTo(money.value) > 0;
    }

    public String moneyRepresentation() {
        return decimalFormat.format(value);
    }

    @Override
    public boolean equals(Object obj) {
        Money other = (Money) obj;
        if (value.equals(other.value))
            return true;
        return false;
    }
}

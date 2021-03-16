package com.customer.delivery.days;

public class DefaultCarrier implements Days {
    @Override
    public Integer getDays() {
        return 4;
    }
}

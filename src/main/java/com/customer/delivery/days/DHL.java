package com.customer.delivery.days;

public class DHL implements Days {
    @Override
    public Integer getDays() {
        return 2;
    }
}

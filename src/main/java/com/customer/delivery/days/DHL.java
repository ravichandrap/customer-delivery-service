package com.customer.delivery.days;

import org.springframework.stereotype.Component;

@Component
public class DHL implements Days {
    @Override
    public Integer getDays() {
        return 2;
    }
}

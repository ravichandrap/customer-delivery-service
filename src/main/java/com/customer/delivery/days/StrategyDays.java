package com.customer.delivery.days;

public class StrategyDays {
    Days days;

    StrategyDays(Days d) {
        this.days = d;
    }
    public Integer getDays() {
        return days.getDays();
    }
}


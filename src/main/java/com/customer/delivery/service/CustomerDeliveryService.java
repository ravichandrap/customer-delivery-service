package com.customer.delivery.service;

import com.customer.delivery.calculate.DeliveryCalculator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerDeliveryService {
    private final DeliveryCalculator calculator;

    CustomerDeliveryService(DeliveryCalculator calculator) {
        this.calculator = calculator;
    }

    public LocalDateTime getExpectedDate(LocalDateTime date, String carrier, String city) {
        return this.calculator.expectedDeliveryDate(date, carrier, city);
    }
}

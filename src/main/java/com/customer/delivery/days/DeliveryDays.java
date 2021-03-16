package com.customer.delivery.days;

import org.springframework.stereotype.Component;

@Component
public class DeliveryDays {

    public Days getCarrier(String carrier) {
        if (carrier.isEmpty()) {
            return new DefaultCarrier();
        }

        if (carrier.equals("DHL")) {
            return new DHL();
        }

        if (carrier.equals("Hermes")) {
            return new Hermes();
        }

        return new DefaultCarrier();
    }
}

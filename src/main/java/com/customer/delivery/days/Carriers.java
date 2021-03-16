package com.customer.delivery.days;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Carriers {

    @Autowired
    private ApplicationContextProvider provider;

    public Days getCarrier(String carrier) {
        return (Days) provider.getContext().getBean(carrier);
    }

}



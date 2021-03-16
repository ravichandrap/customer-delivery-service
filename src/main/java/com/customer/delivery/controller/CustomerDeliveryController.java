package com.customer.delivery.controller;

import com.customer.delivery.calculate.DeliveryCalculator;
import com.customer.delivery.request.DeliveryRequest;
import com.customer.delivery.service.CustomerDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/v1")
public class CustomerDeliveryController {
    public static final Logger logger = LoggerFactory.getLogger(CustomerDeliveryController.class);
    private final CustomerDeliveryService service;

    CustomerDeliveryController(CustomerDeliveryService service) {
        this.service = service;
    }

    @GetMapping("/expected")
    public LocalDateTime expected(@RequestBody DeliveryRequest request) {
        var date = ZonedDateTime.parse(request.getDate()).toLocalDateTime();
        logger.info("Input request: {}",request.toString());
        logger.info("LocalDateTime.parse: {}", date);
        return service.getExpectedDate(date,
                                        request.getCarrier(),
                                        request.getCity());
    }
}

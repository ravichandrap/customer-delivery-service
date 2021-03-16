package com.customer.delivery.calculate;

import com.customer.delivery.days.DeliveryDays;
import com.customer.delivery.holidays.HolidaysDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DeliveryCalculator {
    public static final Logger logger = LoggerFactory.getLogger(DeliveryCalculator.class);

    private final DeliveryDays deliveryDays;
    private final HolidaysDecorator holidaysDecorator;

    DeliveryCalculator(DeliveryDays deliveryDays,
                       HolidaysDecorator holidaysDecorator) {
        this.deliveryDays = deliveryDays;
        this.holidaysDecorator = holidaysDecorator;
    }

    public LocalDateTime expectedDeliveryDate(LocalDateTime bookedDate, String carrier, String city) {
        final var carrierDays = deliveryDays
                                .getCarrier(carrier)
                                .getDays();
        final var wareHouseDays = calculateWareHouseTime(bookedDate);
        final var days = bookedDate.plusDays(wareHouseDays).plusDays(carrierDays);

        return calculate(days, city);
    }

    private LocalDateTime calculate(LocalDateTime date, String city) {
        var localDate = date;
        final var cityHolidays = holidaysDecorator
                .getHolidaysByCiti(city)
                .getHolidays();

        while (cityHolidays.contains(localDate)) {
            localDate = localDate.plusDays(1);
        }
        return localDate;
    }

    private Integer calculateWareHouseTime(LocalDateTime date) {
        return date.getHour() >= 12 ? 1: 0;
    }

}

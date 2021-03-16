package com.customer.delivery.calculate;

import com.customer.delivery.days.Carriers;
import com.customer.delivery.holidays.HolidaysDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DeliveryCalculator {
    public static final Logger logger = LoggerFactory.getLogger(DeliveryCalculator.class);

    private final Carriers carriers;
    private final HolidaysDecorator holidaysDecorator;

    DeliveryCalculator(Carriers carriers,
                       HolidaysDecorator holidaysDecorator) {
        this.carriers = carriers;
        this.holidaysDecorator = holidaysDecorator;
    }

    public LocalDate expectedDeliveryDate(LocalDateTime bookedDate, String carrier, String city) {
        final var carrierDays = carriers
                                .getCarrier(carrier)
                                .getDays();
        final var wareHouseDays = calculateWareHouseTime(bookedDate);
        final var currentDate = bookedDate.plusDays(wareHouseDays).plusDays(carrierDays);

        return calculate(currentDate, city);
    }

    private LocalDate calculate(LocalDateTime currentDate, String city) {
        var localDate = currentDate.toLocalDate();
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

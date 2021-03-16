package com.customer.delivery.holidays;

import org.springframework.stereotype.Component;

@Component
public class HolidaysDecorator {

    public Holidays getHolidaysByCiti(String city) {
        var holidays = new WeekEndHolidays(new PublicHolidays());

        if(city == null || city.isEmpty()) {
            return holidays;
        }

        if(city.equalsIgnoreCase("Berlin")) {
            return new BerlinHolidays(holidays);
        }

        if(city.equalsIgnoreCase("munich")) {
            return new MunichHolidays(holidays);
        }

        return holidays;
    }
}

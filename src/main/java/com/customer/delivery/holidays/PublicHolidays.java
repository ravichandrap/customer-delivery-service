package com.customer.delivery.holidays;

import com.customer.delivery.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.LongStream;

public class PublicHolidays implements Holidays {

    @Override
    public Set<LocalDate> getHolidays() {
        var berlinHolidays = new TreeSet<LocalDate>();
        LongStream.range(10,20).forEach(value -> berlinHolidays.add(
                LocalDate.now().plusDays(value+10)
        ));

        return berlinHolidays;
    }

}

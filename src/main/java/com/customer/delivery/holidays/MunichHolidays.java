package com.customer.delivery.holidays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;


public class MunichHolidays implements Holidays{

    protected Holidays holidays;

    MunichHolidays(Holidays holidays) {
        this.holidays = holidays;
    }

    @Override
    public Set<LocalDate> getHolidays() {

        var berlinHolidays = new TreeSet<LocalDate>();
        LongStream.range(1,20).forEach(value -> berlinHolidays.add(
                LocalDate.now().plusDays(value+10)
        ));

        berlinHolidays.addAll(this.holidays.getHolidays());

        return berlinHolidays;
    }
}

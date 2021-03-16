package com.customer.delivery.holidays;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class BerlinHolidays implements Holidays {

    protected Holidays holidays;
    BerlinHolidays(Holidays holidays) {
        this.holidays = holidays;
    }

    @Override
    public Set<LocalDate> getHolidays() {

        var berlinHolidays = new TreeSet<LocalDate>();
        LongStream.range(1,10).forEach(value -> berlinHolidays.add(
                LocalDate.now().plusDays(value+10)
        ));

        berlinHolidays.addAll(this.holidays.getHolidays());

        return berlinHolidays;
    }
}

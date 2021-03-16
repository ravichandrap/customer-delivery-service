package com.customer.delivery.holidays;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class BerlinHolidays implements Holidays {

    protected Holidays holidays;
    BerlinHolidays(Holidays holidays) {
        this.holidays = holidays;
    }
    @Override
    public Set<LocalDateTime> getHolidays() {

        var berlinHolidays = new TreeSet<LocalDateTime>();
        LongStream.range(1,10).forEach(value -> berlinHolidays.add(
                LocalDateTime.now().plusDays(value+10)
        ));

        berlinHolidays.addAll(this.holidays.getHolidays());

        return berlinHolidays;
    }
}

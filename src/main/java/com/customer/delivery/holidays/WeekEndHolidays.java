package com.customer.delivery.holidays;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class WeekEndHolidays implements Holidays {

    protected Holidays holidays;
    WeekEndHolidays( Holidays holidays) {
        this.holidays = holidays;
    }

    @Override
    public Set<LocalDate> getHolidays() {
        var weekEnds = new TreeSet<LocalDate>();
        IntStream.range(1, 2*52)
                .forEach(value -> weekEnds
                        .add(LocalDate.now().plusWeeks(value)));
        weekEnds.addAll(this.holidays.getHolidays());
        return weekEnds;
    }
}

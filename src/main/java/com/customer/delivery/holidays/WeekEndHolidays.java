package com.customer.delivery.holidays;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class WeekEndHolidays implements Holidays {

    protected Holidays holidays;
    WeekEndHolidays(Holidays holidays) {
        this.holidays = holidays;
    }

    @Override
    public Set<LocalDateTime> getHolidays() {
        var weekEnds = new TreeSet<LocalDateTime>();
        IntStream.range(1, 2*52)
                .forEach(value -> weekEnds
                        .add(LocalDateTime.now().plusWeeks(value)));
        weekEnds.addAll(this.holidays.getHolidays());
        return weekEnds;
    }
}

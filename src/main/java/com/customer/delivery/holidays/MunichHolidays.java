package com.customer.delivery.holidays;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class MunichHolidays implements Holidays{


    protected Holidays holidays;
    MunichHolidays(Holidays holidays) {
        this.holidays = holidays;
    }
    @Override
    public Set<LocalDateTime> getHolidays() {

        var berlinHolidays = new TreeSet<LocalDateTime>();
        LongStream.range(1,20).forEach(value -> berlinHolidays.add(
                LocalDateTime.now().plusDays(value+10)
        ));

        berlinHolidays.addAll(this.holidays.getHolidays());

        return berlinHolidays;
    }
}

package com.customer.delivery.holidays;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

@Component
public class PublicHolidays implements Holidays {

    @Override
    public Set<LocalDateTime> getHolidays() {
        var publicHolidays = new TreeSet<LocalDateTime>();
        IntStream.range(1, 26)
                .forEach(value -> publicHolidays
                        .add(LocalDateTime.now().plusMonths(value)));
        return publicHolidays;
    }
}

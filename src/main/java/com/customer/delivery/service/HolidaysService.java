package com.customer.delivery.service;

import com.customer.delivery.request.Holiday;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class HolidaysService {

    private final String  API_ENDPOINT = "https://date.nager.at/api/v2/publicholidays";
    private final String API_COUNTRY_CODE = "DE";

    public Set<LocalDate> getPublicHolidays() throws Exception {
        var HTTP_CLIENT = (HttpURLConnection) URI.create(
                API_ENDPOINT + "/2021/" + API_COUNTRY_CODE).toURL().openConnection();
        HTTP_CLIENT.setRequestMethod("GET");
        var HTTP_RESPONSE = HTTP_CLIENT.getInputStream();

        var scanner = new Scanner(HTTP_RESPONSE);
        var jsonResponse = new StringBuilder();
        while (scanner.hasNext()) {
            jsonResponse.append(scanner.next());
        }

        var objectMapper = new ObjectMapper();
        var holidays = objectMapper.readValue(jsonResponse.toString(), Holiday[].class);

        return Stream.of(holidays).map(Holiday::getDate).map(LocalDate::parse).collect(Collectors.toSet());
    }

    public static void main(String[] args) throws Exception {
        //create a consumer
        new HolidaysService().getPublicHolidays();

    }
}

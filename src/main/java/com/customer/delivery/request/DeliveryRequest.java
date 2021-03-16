package com.customer.delivery.request;

public class DeliveryRequest {
    private String date;
    private String carrier;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DeliveryRequest(String date, String carrier, String city) {
        this.date = date;
        this.carrier = carrier;
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "DeliveryRequest{" +
                "date='" + date + '\'' +
                ", carrier='" + carrier + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

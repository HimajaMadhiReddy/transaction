package com.ucm.transaction.model.Dto;

import java.util.UUID;

public class Transaction {

    private UUID resourceId;
    private String carResourceId;
    private  String personResourceId;
    private String numberOfDays;
    private String pricePerDay;
    private String reservationResourceId;

    public String getReservationResourceId() {
        return reservationResourceId;
    }

    public void setReservationResourceId(String reservationResourceId) {
        this.reservationResourceId = reservationResourceId;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public String getCarResourceId() {
        return carResourceId;
    }

    public void setCarResourceId(String carResourceId) {
        this.carResourceId = carResourceId;
    }

    public String getPersonResourceId() {
        return personResourceId;
    }

    public void setPersonResourceId(String personResourceId) {
        this.personResourceId = personResourceId;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

}

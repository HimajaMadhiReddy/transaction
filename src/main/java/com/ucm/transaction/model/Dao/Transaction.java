package com.ucm.transaction.model.Dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.UUID;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private UUID resourceId;
    private String carResourceId;
    private  String personResourceId;
    private String netAmount;
    private String numberOfDays;
    private  String tax;
    private  String totalAmount;
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

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}

package com.rlapins.patterns.model;

import com.rlapins.patterns.model.enumerations.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Ticket {

    private String departureStation;
    private String arrivalStation;
    private String price;
    private String status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer seatNumber;
    private List<Service> serviceList;

    public List<Service> getServiceList() {
        if (serviceList == null) {
            serviceList = new ArrayList<>();
        }
        return serviceList;
    }

    public Ticket(String departureStation, String arrivalStation, String price, String status,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, Integer seatNumber,
                  List<Service> serviceList) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.price = price;
        this.status = status;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatNumber = seatNumber;
        this.serviceList = serviceList;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "departureStation='" + departureStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", price='" + price + '\'' +
                ", ticketOwner='" + status + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", seatNumber=" + seatNumber +
                ", serviceList=" + serviceList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(departureStation, ticket.departureStation) &&
                Objects.equals(arrivalStation, ticket.arrivalStation) &&
                Objects.equals(price, ticket.price) &&
                Objects.equals(status, ticket.status) &&
                Objects.equals(departureTime, ticket.departureTime) &&
                Objects.equals(arrivalTime, ticket.arrivalTime) &&
                Objects.equals(seatNumber, ticket.seatNumber) &&
                Objects.equals(serviceList, ticket.serviceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureStation, arrivalStation, price, status, departureTime, arrivalTime, seatNumber, serviceList);
    }
}

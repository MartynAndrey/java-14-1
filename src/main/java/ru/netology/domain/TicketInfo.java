package ru.netology.domain;

public class TicketInfo implements Comparable<TicketInfo>{
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int flightTime;

    public TicketInfo() {
    }

    public TicketInfo(int id, int price, String fromAirport, String toAirport, int flightTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.flightTime = flightTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFromAirport() {
        return this.fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return this.toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public int getFlightTime() {
        return this.flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(TicketInfo ticketInfo) {
        return this.price - ticketInfo.price;
    }
}

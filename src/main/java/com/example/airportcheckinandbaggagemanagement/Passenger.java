package com.example.airportcheckinandbaggagemanagement;

public class Passenger {
    int ticketNumber;
    String name;
    double baggageWeight;

    public Passenger(int ticketNumber, String name, double baggageWeight) {
        this.ticketNumber = ticketNumber;
        this.name = name;
        this.baggageWeight = baggageWeight;
    }

    @Override
    public String toString() {
        return "Ticket: " + ticketNumber +
                " | Name: " + name +
                " | Baggage: " + baggageWeight + "kg";
    }
}

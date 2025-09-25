package com.example.fragments_5a;

public class Passenger {
    String name;
    String contact_number;
    int payment;
    String preference;
    int seat_number;

    public Passenger() {
    }

    public Passenger(String name, String contact_number, int payment, String preference, int seat_number) {
        this.name = name;
        this.contact_number = contact_number;
        this.payment = payment;
        this.preference = preference;
        this.seat_number = seat_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }
}

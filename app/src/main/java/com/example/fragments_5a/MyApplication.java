package com.example.fragments_5a;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Passenger> passengers;

    @Override
    public void onCreate() {
        super.onCreate();
        passengers = new ArrayList<>();
        // String name, String contact_number, int payment, String preference, int seat_number
        passengers.add(new Passenger("Waqas", "12313", 90000, "Train", 5));
        passengers.add(new Passenger("Ali", "666666", 9000, "Plane", 2));
        passengers.add(new Passenger("Saadiq bhai", "13891938", 1800, "Buss", 4));
    }
}

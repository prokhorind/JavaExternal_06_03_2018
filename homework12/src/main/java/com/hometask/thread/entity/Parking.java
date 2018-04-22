package com.hometask.thread.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by kleba on 22.04.2018.
 */
public class Parking {

    private List<ParkingPlace> parking;
    private Semaphore semaphore;
    private String street;

    public Parking() {
    }

    public Parking(int number, String street) {
        this.parking = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            ParkingPlace p = new ParkingPlace(i, false);
            parking.add(p);
        }
        this.semaphore = new Semaphore(number, true);
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setParking(List<ParkingPlace> parking) {
        this.parking = parking;
    }

    public List<ParkingPlace> getParking() {
        return parking;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}

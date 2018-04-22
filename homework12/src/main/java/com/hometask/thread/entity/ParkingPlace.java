package com.hometask.thread.entity;

/**
 * Created by kleba on 22.04.2018.
 */
public class ParkingPlace {
    private int id;
    private boolean status;

    public ParkingPlace(int id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

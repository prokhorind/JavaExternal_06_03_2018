package com.gadgets.home.entity;

import java.io.Serializable;

/**
 * Created by kleba on 23.03.2018.
 */
public abstract class Gadget implements Transportable,Serializable{

    protected String name;
    protected  int id;
    protected double power;
    protected boolean plugged;
    protected String type;

    public Gadget(String name, int id, double power, boolean plugged, String type) {
        this.name = name;
        this.power = power;
        this.plugged = plugged;
        this.type=type;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isPlugged() {
        return plugged;
    }

    public void setPlugged(boolean plugged) {
        this.plugged = plugged;
    }

}

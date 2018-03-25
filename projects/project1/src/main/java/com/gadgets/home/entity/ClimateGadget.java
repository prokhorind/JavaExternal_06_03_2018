package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public abstract class ClimateGadget extends Gadget {

    double serviceArea;

    public ClimateGadget(String name, int id, double power, boolean plugged, double serviceArea) {
        super(name, id, power, plugged, "ClimateGadget");
        this.serviceArea=serviceArea;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
    }

}

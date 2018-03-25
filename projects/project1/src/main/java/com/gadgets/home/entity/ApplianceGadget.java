package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public abstract class ApplianceGadget extends Gadget {

    public ApplianceGadget(String name,int id, double power, boolean plugged) {
        super(name, id, power, plugged,"ApplianceGadget");
    }
}

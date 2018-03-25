package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public class WashingMachine extends ApplianceGadget {

    private int spinSpeed;

    public WashingMachine(String name, int id, double power, boolean plugged,int spinSpeed) {
        super(name, id, power,plugged);
        this.spinSpeed=spinSpeed;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(int spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    public boolean isTransportable() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id=");
        sb.append(id);
        sb.append(";");
        sb.append("Name=");
        sb.append(name);
        sb.append(";");
        sb.append("Type=");
        sb.append(type);
        sb.append(";");
        sb.append("Power=");
        sb.append(power);
        sb.append(";");
        sb.append("Plugged=");
        sb.append(plugged);
        sb.append(";");
        sb.append("Spin Speed=");
        sb.append(spinSpeed);
        sb.append(";");
        sb.append("Transportable=");
        sb.append(isTransportable());
        sb.append(";");
        sb.append("\n");
        return sb.toString();
    }
}

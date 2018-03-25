package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public class Heater extends ClimateGadget {

    private boolean temperatureControl;

    public Heater(String name, int id, double power, boolean plugged, double serviceArea,boolean temperatureControl) {
        super(name, id, power, plugged, serviceArea);
        this.temperatureControl=temperatureControl;
    }

    public void setTemperatureControl(boolean temperatureControl) {
        this.temperatureControl = temperatureControl;
    }

    public boolean isTemperatureControl() {
        return temperatureControl;
    }

    public boolean isTransportable() {
        return true;
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
        sb.append("Temperature Control=");
        sb.append(temperatureControl);
        sb.append(";");
        sb.append("Transportable=");
        sb.append(isTransportable());
        sb.append(";");
        sb.append("\n");
        return sb.toString();
    }
}

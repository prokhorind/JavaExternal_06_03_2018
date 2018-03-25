package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public class Humidifier extends ClimateGadget {

    private int humidificationLevel;

    public Humidifier(String name, int id, double power, boolean plugged, double serviceArea,int humidificationLevel) {
        super(name, id, power, plugged, serviceArea);
        this.humidificationLevel=humidificationLevel;
    }

    public int getHumidificationLevel() {
        return humidificationLevel;
    }

    public void setHumidificationLevel(int humidificationLevel) {
        this.humidificationLevel = humidificationLevel;
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
        sb.append("Humidification level=");
        sb.append(humidificationLevel);
        sb.append(";");
        sb.append("Transportable=");
        sb.append(isTransportable());
        sb.append(";");
        sb.append("\n");
        return sb.toString();
    }
}

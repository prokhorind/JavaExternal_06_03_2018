package com.gadgets.home.entity;

/**
 * Created by kleba on 23.03.2018.
 */
public class FlatIron extends ApplianceGadget {

    public int steamStroke;

    public FlatIron(String name, int id, double power, boolean plugged,int steamStroke) {
        super(name, id, power, plugged);
        this.steamStroke=steamStroke;
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
        sb.append("Steam Stroke=");
        sb.append(steamStroke);
        sb.append(";");
        sb.append("Transportable=");
        sb.append(isTransportable());
        sb.append(";");
        sb.append("\n");
        return sb.toString();
    }
}

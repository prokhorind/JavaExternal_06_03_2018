package vehicles.interf.interfimpl.transport;

import vehicles.interf.Swim;

/**
 * Created by kleba on 15.03.2018.
 */
public class Ship extends  Vehicle implements Swim{

    private int numberOfPassangers;
    private String port;

    public Ship(int x1, int y1, int x2, int y2, double price, int year, double speed, int numberOfPassangers,String port
            ,String brand,String engineType) {
        super(x1, y1, x2, y2, price, year, speed,brand,engineType);
        this.numberOfPassangers=numberOfPassangers;
        this.port=port;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(int numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("name=");
        sb.append(this.getClass().getName());
        sb.append("\n");
        sb.append("x1=");
        sb.append(x1);
        sb.append(";");
        sb.append("y1=");
        sb.append(y1);
        sb.append(";");
        sb.append("x2=");
        sb.append(x2);
        sb.append(";");
        sb.append("y2=");
        sb.append(y2);
        sb.append(";");
        sb.append("price=");
        sb.append(price);
        sb.append(";");
        sb.append("year=");
        sb.append(year);
        sb.append(";");
        sb.append("speed=");
        sb.append(speed);
        sb.append(";");
        sb.append("number of passangers=");
        sb.append(numberOfPassangers);
        sb.append(";");
        sb.append("Port=");
        sb.append(port);
        sb.append(";");
        sb.append("\n");

        return sb.toString();
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public double swim() {return speed; }
}

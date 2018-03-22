package vehicles.interf.interfimpl.transport;

import vehicles.interf.Move;

/**
 * Created by kleba on 15.03.2018.
 */
public class Car extends  Vehicle implements Move {


    public Car(int x1, int y1, int x2, int y2, double price, int year, double speed,String brand,String engineType) {
        super(x1, y1, x2, y2, price, year, speed,brand,engineType);
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
        sb.append("\n");

        return sb.toString();
    }

    public double move() {return speed; }
}

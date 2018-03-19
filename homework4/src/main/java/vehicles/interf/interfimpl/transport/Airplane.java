package vehicles.interf.interfimpl.transport;

import vehicles.interf.Fly;

/**
 * Created by kleba on 15.03.2018.
 */
public class Airplane extends Vehicle implements Fly {

    private double height;
    private int numberOfPassangers;

    public Airplane(int x1, int y1, int x2, int y2, double price, int year, double speed, double height, int numberOfPassangers) {
        super(x1, y1, x2, y2, price, year, speed);
        this.height=height;
        this.numberOfPassangers=numberOfPassangers;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(int numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

   public String toString(){
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
       sb.append("height=");
       sb.append(height);
       sb.append(";");
       sb.append("number of passangers=");
       sb.append(numberOfPassangers);
       sb.append(";");
       sb.append("\n");

       return sb.toString();
   }



    public double fly() {return speed; }
}

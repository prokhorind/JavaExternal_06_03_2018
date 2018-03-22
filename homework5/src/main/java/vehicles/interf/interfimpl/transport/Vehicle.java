package vehicles.interf.interfimpl.transport;

/**
 * Created by kleba on 15.03.2018.
 */
public abstract class Vehicle implements Comparable {

    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected double price;
    protected final int year;
    protected double speed;
    protected Engine engine;

    public Vehicle(int x1, int y1, int x2, int y2, double price, int year, double speed,String brand,String engineType) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.price = price;
        this.year = year;
        this.speed = speed;
        this.engine = new Engine(brand,engineType);

    }

    public class Engine {
        String brand;
        String engineType;

        public Engine(String brand, String engineType) {
            this.brand = brand;
            this.engineType = engineType;
        }

        public void checkEngine() {
            if(Vehicle.this.getClass().getSimpleName().equals(engineType)){
            System.out.println(Vehicle.this.getClass().getSimpleName());
            System.out.println("We have here engine brand="+brand+" for="+engineType +" with speed=" +Vehicle.this.speed);
            }else{
                System.out.println("Warning u inserted wrong engine in "+Vehicle.this.toString());
                System.out.println("I'll set brand and engyne type to null");
                engine.engineType=null;
                engine.brand=null;
            }
        }
    }

    public static class Interior{

        private int numbertOfEmployers;

        public Interior(int numbertOfEmployers) {
            this.numbertOfEmployers = numbertOfEmployers;
        }

        public int returnNubmerOfEmployers(){
            return  numbertOfEmployers;
        }
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public abstract String toString();

    public int compareTo(Object o) {
        double speedCompare = this.speed - ((Vehicle)o).speed;
        return (int)speedCompare;
    }
}

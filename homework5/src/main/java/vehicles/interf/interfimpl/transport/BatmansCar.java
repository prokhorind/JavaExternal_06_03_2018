package vehicles.interf.interfimpl.transport;

import vehicles.interf.Fly;
import vehicles.interf.Move;
import vehicles.interf.Swim;
import vehicles.interf.interfimpl.transport.Car;

/**
 * Created by kleba on 16.03.2018.
 */
public class BatmansCar extends Car implements Fly,Move,Swim {

    public BatmansCar(int x1, int y1, int x2, int y2, double price, int year, double speed,String brand,String engineType) {
        super(x1, y1, x2, y2, price, year, speed,brand,engineType);
    }

    public double fly() {
        return speed*0.5;
    }

    public double swim() {
        return speed/1.5;
    }

    @Override
    public double move() {
        return super.move();
    }

    @Override
    public double countSpeed() {
        return super.countSpeed();
    }
}

package vehicles.interf.interfimpl.transport;

import vehicles.interf.Move;
import vehicles.interf.Swim;
import vehicles.interf.interfimpl.transport.Car;

/**
 * Created by kleba on 16.03.2018.
 */
public class Amphibian extends Car implements Swim,Move {

    public Amphibian(int x1, int y1, int x2, int y2, double price, int year, double speed) {
        super(x1, y1, x2, y2, price, year, speed);
    }


    public double swim() {

        return speed/2;
    }

    @Override
    public double countSpeed() {
        return super.countSpeed();
    }
}

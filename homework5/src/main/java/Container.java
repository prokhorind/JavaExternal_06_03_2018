import vehicles.interf.Fly;
import vehicles.interf.Move;
import vehicles.interf.Swim;
import vehicles.interf.Travel;
import vehicles.interf.interfimpl.transport.Car;
import vehicles.interf.interfimpl.transport.Ship;
import vehicles.interf.interfimpl.transport.Vehicle;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by kleba on 15.03.2018.
 */
public class Container {

    public static void print(Object[] objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    public static Car[] findCars(Object[] objects) {
        Car[] carArray;
        DynamicArray dynamicArray = new DynamicArray();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (Object o : objects) {
            if ("vehicles.interf.interfimpl.transport.Car".equals(o.getClass().getName())) {
                Car car = (Car) o;
                if ((year - 5 <= car.getYear())) {
                    dynamicArray.addValue(car);
                }
            }
        }
        carArray = new Car[dynamicArray.countValues()];
        for (int i = 0; i < carArray.length; i++) {
            carArray[i] = (Car) dynamicArray.getObject()[i];
        }
        return carArray;
    }

    public static Vehicle getVehicleWithMaxPrice(Object[] objects) {
        Vehicle vehicle = null;
        double price = 0;
        for (Object o : objects) {
            Vehicle v = (Vehicle) o;
            if (v.getPrice() > price) {
                price = v.getPrice();
                vehicle = v;
            }
        }
        return vehicle;
    }

    public static Vehicle findBySpeedYearPrice(Object[] objects) {
        Vehicle vehicle = null;
        for (Vehicle v : (Vehicle[]) objects) {

            if (v.getYear() < 2005 && v.getYear() > 2000 && v.getSpeed() > 150) {

                if (vehicle == null || v.getPrice() < vehicle.getPrice()) {
                    vehicle = v;
                }
            }
        }
        return vehicle;
    }

    public static Ship[] sortedShipsByPrice(Object[] objects) {
        DynamicArray dm = new DynamicArray();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (Vehicle v : (Vehicle[]) objects) {
            if ("vehicles.interf.interfimpl.transport.Ship".equals(v.getClass().getName())) {
                if (v.getYear() > (year - 5)) {
                    dm.addValue(v);
                }
            }
        }

        Ship[] shipArray = new Ship[dm.countValues()];
        for (int i = 0; i < shipArray.length; i++) {
            shipArray[i] = (Ship) dm.getObject()[i];
        }
        Ship ship;
        for (int i = 0; i < shipArray.length; i++) {
            for (int j = 0; i < shipArray.length; i++) {
                if (shipArray[i].getPrice() > shipArray[j].getPrice()) {
                    ship = shipArray[i];
                    shipArray[i] = shipArray[j];
                    shipArray[j] = ship;
                }
            }
        }
        return shipArray;
    }

    public static Swim[] findAllShips(Vehicle[] vehicle) {
        Swim[] swimArray;
        Class<?>[] interfaces;
        DynamicArray dm = new DynamicArray();
        for (Vehicle v : vehicle) {
            interfaces = v.getClass().getInterfaces();
            for (Class c : interfaces) {
                if ("vehicles.interf.Swim".equals(c.getName())) {
                    dm.addValue(v);
                    break;
                }
            }
        }
        dm = sortBySpeed(dm);

        swimArray = new Swim[dm.countValues()];
        for (int i = 0; i < swimArray.length; i++) {
            if (dm.getObject()[i] != null)
                swimArray[i] = (Swim) dm.getObject()[i];
        }
        return swimArray;
    }

    public static Move[] findAllCars(Vehicle[] vehicle) {
        Move[] moveArray;
        Class<?>[] interfaces;
        DynamicArray dm = new DynamicArray();
        for (Vehicle v : vehicle) {
            interfaces = v.getClass().getInterfaces();
            for (Class c : interfaces) {
                if ("vehicles.interf.Move".equals(c.getName())) {
                    dm.addValue(v);
                    break;
                }
            }
        }
        dm = sortBySpeed(dm);

        moveArray = new Move[dm.countValues()];
        for (int i = 0; i < moveArray.length; i++) {
            if (dm.getObject()[i] != null)
                moveArray[i] = (Move) dm.getObject()[i];
        }
        return moveArray;
    }

    public static Fly[] findAllAirplanes(Vehicle[] vehicle) {
        Fly[] flyArray;
        Class<?>[] interfaces;
        DynamicArray dm = new DynamicArray();
        for (Vehicle v : vehicle) {
            interfaces = v.getClass().getInterfaces();
            for (Class c : interfaces) {
                if ("vehicles.interf.Fly".equals(c.getName())) {
                    dm.addValue(v);
                    break;
                }
            }
        }
        dm = sortBySpeed(dm);
        flyArray = new Fly[dm.countValues()];
        for (int i = 0; i < flyArray.length; i++) {
            if (dm.getObject()[i] != null)
                flyArray[i] = (Fly) dm.getObject()[i];
        }
        return flyArray;
    }

    private static DynamicArray sortBySpeed(DynamicArray dm) {
        for (int i = 0; i < dm.getObject().length; i++) {
            Vehicle v = dm.getObject()[i];
            for (int j = i + 1; j < dm.getObject().length; j++) {
                Vehicle v1 = dm.getObject()[j];
                if (v != null && v1 != null) {
                    v.compareTo(v1);
                }
            }
        }
        return dm;
    }

    public static Vehicle findMinFlyElement(Travel[] travele, String type) {
        Travel previousT = null;
        Fly f;
        Swim s;
        Move m;

        for (Travel t : travele) {
            if (t instanceof Fly && type.equals("Fly")) {
                f = (Fly) t;
                if (f != null) {
                    if (previousT == null) {
                        previousT = f;
                    } else if (f.fly() < previousT.countSpeed()) {
                        previousT = f;
                    }
                }
            }
            if (t instanceof Swim && type.equals("Swim")) {
                s = (Swim) t;
                if (s != null) {
                    if (previousT == null) {
                        previousT = s;
                    } else if (s.swim() < previousT.countSpeed()) {
                        previousT =  s;
                    }
                }
            }
            if (t instanceof Move && type.equals("Move")) {
                m = (Move) t;
                if (m != null) {
                    if (previousT == null) {
                        previousT = m;
                    } else if (m.move() < previousT.countSpeed()) {
                        previousT =  m;
                    }
                }
            }
        }
        Vehicle v = (Vehicle) previousT;
        return v;
    }

    public static Vehicle findMaxFlyElement(Travel[] travele, String type) {
        Travel previousT = null;
        Fly f;
        Swim s;
        Move m;
        for (Travel t : travele) {
            if (t instanceof Fly && type.equals("Fly")) {
                f = (Fly) t;
                if (f != null) {
                    if (previousT == null) {
                        previousT = f;
                    } else if (f.fly() > previousT.countSpeed()) {
                        previousT =  f;
                    }
                }
            }
            if (t instanceof Swim && type.equals("Swim")) {
                s = (Swim) t;
                if (s != null) {
                    if (previousT == null) {
                        previousT = s;
                    } else if (s.swim() > previousT.countSpeed()) {
                        previousT =  s;
                    }
                }
            }
            if (t instanceof Move && type.equals("Move")) {
                m = (Move) t;
                if (m != null) {
                    if (previousT == null) {
                        previousT = m;
                    } else if (m.move() > previousT.countSpeed()) {
                        previousT =  m;
                    }
                }
            }
        }
        Vehicle v = (Vehicle) previousT;
        return v;
    }
}

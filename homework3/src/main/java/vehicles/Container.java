package vehicles;

import vehicles.transport.Car;
import vehicles.transport.Ship;
import vehicles.transport.Vehicle;

import java.util.Calendar;

/**
 * Created by kleba on 15.03.2018.
 */
public class Container {


    public static void print(Object[] objects){
        for(Object o:objects){
            System.out.println(o);
        }
    }

    public static Car[] findCars(Object[] objects){

        Car[] carArray;
        DynamicArray dynamicArray = new DynamicArray();
        int year=Calendar.getInstance().get(Calendar.YEAR);
        for(Object o:objects){

            if("vehicles.transport.Car".equals(o.getClass().getName())){

                Car car= (Car) o;
                if((year-5<=car.getYear())) {
                    dynamicArray.addValue(car);
                }
            }


        }

        carArray= new Car[dynamicArray.countValues()];
        for(int i=0;i<carArray.length;i++){
            carArray[i]= (Car) dynamicArray.getObject()[i];

        }
        return carArray;
    }

    public  static Vehicle getVehicleWithMaxPrice(Object[] objects){

        Vehicle vehicle=null;
        double price=0;
        for(Object o:objects){
            Vehicle v =(Vehicle) o;
            if(v.getPrice()>price){
                price=v.getPrice();
                vehicle=v;
            }

        }
        return vehicle;
    }

    public  static  Vehicle findBySpeedYearPrice(Object[] objects){
        DynamicArray da = new DynamicArray();
        double price=0;
        Vehicle vehicle=null;
        for(Vehicle v:(Vehicle[]) objects){

            if (v.getYear()<2005&&v.getYear()>2000&&v.getSpeed()>150){

                if (vehicle == null||v.getPrice()<vehicle.getPrice()) {
                    vehicle=v;
                }



            }
        }
        return  vehicle;
    }


    public static Ship[] sortedShipsByPrice(Object[] objects){
        DynamicArray dm = new DynamicArray();
        int year=Calendar.getInstance().get(Calendar.YEAR);
        for(Vehicle  v:(Vehicle[])objects) {
            if( "vehicles.transport.Ship".equals(v.getClass().getName())) {
                if (v.getYear() > (year - 5)) {
                    dm.addValue(v);
                }
            }

        }

        Ship[] shipArray= new Ship[dm.countValues()];
        for(int i=0;i<shipArray.length;i++) {

            shipArray[i] = (Ship) dm.getObject()[i];
        }

        Ship ship = null;
        for(int i=0;i<shipArray.length;i++){
            for(int j=0;i<shipArray.length;i++){

                if(shipArray[i].getPrice()>shipArray[j].getPrice()){
                    ship=shipArray[i];
                    shipArray[i]=shipArray[j];
                    shipArray[j]=ship;
                }
            }

        }
        return  shipArray;
    }
}

package vehicle.factory;

import vehicles.interf.interfimpl.transport.*;

import java.util.Scanner;

/**
 * Created by kleba on 16.03.2018.
 */
public class VehicleFactoryImpl implements AbstractVehicleFactory{

    private int numberOfVehicles;

    private VehicleFactoryImpl(){};

    public Vehicle getVehicle(int n) {
        switch (n) {
            case 0: return new Airplane(30,30,50,50,20000,2004,400,200,100,"Airplane","Airplane");
            case 1: return new Amphibian(10,10,20,20,3000,2001,180,"Amphibian","Amphibian");
            case 2: return new BatmansCar(10,10,20,20,3000,2001,220,"Batman","BatmansCar");
            case 3: return new Car(10,10,20,20,3000,2001,160,"Honda","Car");
            case 4: return new Ship(10,10,20,20,20000,2014,40,205,"Port Royal","Ship","Ship");
            default:{
                System.out.println("Enter number of vehicle");
                Scanner sc= new Scanner(System.in);
                n=sc.nextInt();
                return getVehicle(n);
            }
        }
    }

    public VehicleFactoryImpl(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public Vehicle randVehicle() {
        return getVehicle((int)(Math.random()*numberOfVehicles));
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }
}

import vehicles.interf.Swim;
import vehicles.interf.interfimpl.transport.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Vehicle v1 = new Car(10,10,20,20,3000,2001,160,"Honda","Car");
        Vehicle.Interior int1 = new Vehicle.Interior(1);
        Vehicle v2 = new Ship(10,10,20,20,15000,1999,40,200,"Tortuga","ShipEngine","Ship");
        Vehicle.Interior int2 = new Vehicle.Interior(4);
        Vehicle v3 = new Airplane(30,30,50,50,20000,2004,600,200,600,"AirEngine","Airplane");
        Vehicle.Interior int3 = new Vehicle.Interior(2);
        Vehicle v4 = new Car(10,10,20,20,2000,2015,170,"CarEngine","Car");
        Vehicle.Interior int4 = new Vehicle.Interior(1);
        Vehicle v5= new Ship(10,10,20,20,17000,2016,60,210,"Port Royal","CarEngine","Car");
        Vehicle.Interior int5 = new Vehicle.Interior(4);
        Vehicle v6 = new Airplane(30,30,50,50,20000,2006,100,200,100,"ShipEngine","Ship");
        Vehicle.Interior int6 = new Vehicle.Interior(2);
        Vehicle v7 = new Ship(10,10,20,20,20000,2014,80,205,"Port Royal","AirEngine","Airplane");
        Vehicle.Interior int7 = new Vehicle.Interior(4);
        Vehicle v8 = new BatmansCar(10,10,20,20,3000,2001,160,"UniqueEngine","BatmansCar");
        Vehicle.Interior int8 = new Vehicle.Interior(1);
        Vehicle v9 = new Amphibian(10,10,20,20,3000,2001,160,"AmphibianEngine","Ampibian");
        Vehicle.Interior int9 = new Vehicle.Interior(1);
        Vehicle[]vehicles = {v1,v2,v3,v4,v5,v6,v7,v8,v9};
        Vehicle.Interior[]vehicleInterior = {int1,int2,int3,int4,int5,int6,int7,int8,int9};
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1.Vehicle с наибольшей ценой");
            System.out.println("2.Механизм год выпуска 2000-2005 с  скоростью выше 150 км/ч, и наименьшей ценой");
            System.out.println("3.Из Масива Vehicle получить масив Car не старше 5 лет");
            System.out.println("4.Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
            System.out.println("5.Последовательность swim ");
            System.out.println("6.Последовательность move ");
            System.out.println("7.Последовательность fly");
            System.out.println("8.Check engine");
            System.out.println("9.Check number of employeers");
            System.out.println("10.Выход");
            switch (choice = sc.nextInt()) {
               case 1:
                   System.out.println( Container.getVehicleWithMaxPrice(vehicles));
                   break;
               case 2:
                   System.out.println(Container.findBySpeedYearPrice (vehicles));
                   break;
               case 3:
                   for (Car c: Container.findCars(vehicles)){
                       System.out.println(c);
                   }
                    break;
               case 4:
                   for(Ship s: Container.sortedShipsByPrice(vehicles)){
                       System.out.println(s);
                   }
                   break;
               case 5:
                  for(Swim s: Container.findAllShips(vehicles)){
                      System.out.println(s);
                  }
                   System.out.println("min="+Container.findMinFlyElement(Container.findAllShips(vehicles),"Swim"));
                   System.out.println("max="+Container.findMaxFlyElement(Container.findAllShips(vehicles),"Swim"));
                   break;
               case 6:
                   System.out.println(Arrays.toString(Container.findAllCars(vehicles)));
                   System.out.println("min="+Container.findMinFlyElement(Container.findAllCars(vehicles),"Move"));
                   System.out.println("max="+Container.findMaxFlyElement(Container.findAllCars(vehicles),"Move"));
                   break;
               case 7:
                   System.out.println(Arrays.toString(Container.findAllAirplanes(vehicles)));
                   System.out.println("min="+Container.findMinFlyElement(Container.findAllAirplanes(vehicles),"Fly"));
                   System.out.println("max="+Container.findMaxFlyElement(Container.findAllAirplanes(vehicles),"Fly"));
                   break;
                case 8:
                  for(Vehicle vehicle:vehicles){
                      System.out.println("__________________________");
                      vehicle.getEngine().checkEngine();
                      System.out.println("__________________________");
                      System.out.println();
                  }
                    break;
                case 9:
                    for(int i = 0;i < vehicleInterior.length;i++){
                        System.out.println(vehicles[i]);
                        System.out.println("nubmer of employers="+vehicleInterior[i].returnNubmerOfEmployers());
                    }
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
           }
        }while(choice != 10);
    }
}

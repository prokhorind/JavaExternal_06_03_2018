import vehicles.interf.Swim;
import vehicles.interf.interfimpl.transport.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kleba on 15.03.2018.
 */
public class Main {

    public static void main(String[] args){
        Vehicle v1= new Car(10,10,20,20,3000,2001,160);
        Vehicle v2= new Ship(10,10,20,20,15000,1999,40,200,"Tortuga");
        Vehicle v3=new Airplane(30,30,50,50,20000,2004,600,200,600);
        Vehicle v4= new Car(10,10,20,20,2000,2015,170);
        Vehicle v5= new Ship(10,10,20,20,17000,2016,60,210,"Port Royal");
        Vehicle v6=new Airplane(30,30,50,50,20000,2006,400,200,100);
        Vehicle v7= new Ship(10,10,20,20,20000,2014,80,205,"Port Royal");
        Vehicle v8= new BatmansCar(10,10,20,20,3000,2001,160);
        Vehicle v9= new Amphibian(10,10,20,20,3000,2001,160);
        Vehicle[]vehicles={v1,v2,v3,v4,v5,v6,v7,v8,v9};

        Scanner sc = new Scanner(System.in);
        int choice=0;
       do {

            System.out.println("Menu");
            System.out.println("1.Vehicle с наибольшей ценой");
            System.out.println("2.Механизм год выпуска 2000-2005 с  скоростью выше 150 км/ч, и наименьшей ценой");
            System.out.println("3.Из Масива Vehicle получить масив Car не старше 5 лет");
            System.out.println("4.Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
            System.out.println("5.Последовательность swim ");
            System.out.println("6.Последовательность move ");
            System.out.println("7.Последовательность fly");
            System.out.println("8.Выход");
            choice=sc.nextInt();

           switch (choice){

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

               default:
                   System.out.println("Invalid number");
           }
        }while(choice!=8);
    }
}

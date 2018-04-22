package com.hometask.thread;

import com.hometask.thread.entity.Parking;
import com.hometask.thread.threads.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kleba on 21.04.2018.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Parking p = new Parking(2, "Первая улица");
        Parking p2 = new Parking(7, "Вторая улица");
        List<Parking> parkingList = new LinkedList() {{
            add(p);
            add(p2);
        }};
        for (int i = 1; i <= 12; i++) {
            new Thread(new Car(i, parkingList, 50)).start();
            Thread.sleep(100);
        }
    }
}


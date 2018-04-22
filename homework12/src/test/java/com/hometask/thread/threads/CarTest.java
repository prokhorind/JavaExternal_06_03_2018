package com.hometask.thread.threads;

import com.hometask.thread.entity.Parking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kleba on 22.04.2018.
 */
public class CarTest {

    private  List<Parking> parkingList;
    @Before
    public void setUp() throws Exception {
        Parking p = new Parking(2, "Первая улица");
        Parking p2 = new Parking(7, "Вторая улица");

        parkingList = new LinkedList() {{
            add(p);
            add(p2);
        }};
    }

    @After
    public void tearDown() throws Exception {
        parkingList=null;
    }

    @Test()
    public void run() throws Exception {
        int threadsCompleted=10;
        int actual=0;

        for (int i = 1; i <= 10; i++) {
           Thread th= new Thread(new Car(i, parkingList, 50));
            th.start();
            th.interrupt();
            Thread.sleep(100);
            actual=i;
        }
        assertEquals(threadsCompleted,actual);
    }

}
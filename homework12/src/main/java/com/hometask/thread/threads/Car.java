package com.hometask.thread.threads;

import com.hometask.thread.entity.Parking;
import com.hometask.thread.exception.ResourceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kleba on 22.04.2018.
 */
public class Car implements Runnable {
    private int carNumber;
    private int waiting;
    private List<Parking> parkings;
    final static Logger rootLogger = LogManager.getLogger(Car.class);
    public Car(int carNumber, List<Parking> parkings, int waiting) {
        this.carNumber = carNumber;
        this.waiting = waiting;
        this.parkings = parkings;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (Parking p : parkings) {
                System.out.printf("Автомобиль №%d подъехал к парковке %s.\n", carNumber, p.getStreet());
                rootLogger.info("Автомобиль №" + carNumber + "подъехал к парковке " + p.getStreet());
                try {
                    int parkingNumber = -1;
                    if (p.getSemaphore().tryAcquire(waiting, TimeUnit.MILLISECONDS)) {

                        for (int i = 0; i < p.getParking().size(); i++) {
                            if (!p.getParking().get(i).isStatus()) {
                                p.getParking().get(i).setStatus(true);
                                parkingNumber = i;
                                System.out.printf("Автомобиль №%d припарковался на улице %s.\n", carNumber, p.getStreet());
                                rootLogger.info("Автомобиль №" + carNumber + "припарковался на улице " + p.getStreet());
                                break;
                            }
                        }
                        if (parkingNumber >= 0) {
                            Thread.sleep(1000);
                            p.getParking().get(parkingNumber).setStatus(false);
                            p.getSemaphore().release();
                            System.out.printf("Автомобиль №%d покинул парковку на улице %s.\n", carNumber, p.getStreet());
                            rootLogger.info("Автомобиль №" + carNumber + "покинул парковку на улице " + p.getStreet());
                            break;
                        }
                    } else {
                        System.out.println("Парковка занята");
                        p.getSemaphore().release();
                        throw new ResourceException("парковка занята");
                    }
                } catch (ResourceException e) {
                    rootLogger.error(e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
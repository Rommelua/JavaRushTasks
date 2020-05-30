package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Thread coo1Thread = new Thread(cook1);
        coo1Thread.setDaemon(true);
        coo1Thread.start();

        Cook cook2 = new Cook("Vasya");
        cook2.setQueue(orderQueue);
        Thread coo2Thread = new Thread(cook2);
        coo2Thread.setDaemon(true);
        coo2Thread.start();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        Thread orders =  new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        orders.start();
        Thread.sleep(1000);
        orders.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}

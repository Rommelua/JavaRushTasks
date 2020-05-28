package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time "
                + order.getTotalCookingTime() + "min");
        CookedOrderEventDataRow event = new CookedOrderEventDataRow(o.toString(), name,
                order.getTotalCookingTime(), order.getDishes());
        StatisticManager.getInstance().register(event);
        setChanged();
        notifyObservers(arg);
    }
}

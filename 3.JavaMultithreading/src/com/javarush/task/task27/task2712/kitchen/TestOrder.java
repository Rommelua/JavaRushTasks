package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        random.ints(random.nextInt(1,5), 0, Dish.values().length)
                .forEach(i -> dishes.add(Dish.values()[i]));
    }
}

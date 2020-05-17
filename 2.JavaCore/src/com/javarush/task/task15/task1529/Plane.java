package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int capacity;

    @Override
    public void fly() {

    }

    public Plane(int capacity) {
        this.capacity = capacity;
    }
}

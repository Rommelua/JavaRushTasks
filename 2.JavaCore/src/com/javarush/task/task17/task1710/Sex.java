package com.javarush.task.task17.task1710;

public enum Sex {
    MALE ("м"),
    FEMALE ("ж");
    private String title;
    Sex(String s) {
        title = s;
    }

    @Override
    public String toString() {
        return title;
    }
}

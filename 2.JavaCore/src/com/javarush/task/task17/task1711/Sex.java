package com.javarush.task.task17.task1711;

public enum Sex {
    MALE ("м"),
    FEMALE ("ж");
    private String title;
    Sex(String s) {
        title = s;
    }

    public static Sex sexFor(String value) {
        if (value.equals("м")) {
            return MALE;
        }
        if (value.equals("ж")) {
            return FEMALE;
        }
        return null;
    }
    @Override
    public String toString() {
        return title;
    }
}

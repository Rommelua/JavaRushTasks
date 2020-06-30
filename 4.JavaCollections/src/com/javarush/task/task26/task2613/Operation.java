package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == 0) throw new IllegalArgumentException();
        try {
            return values()[i];
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

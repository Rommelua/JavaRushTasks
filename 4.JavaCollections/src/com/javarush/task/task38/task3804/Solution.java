package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {

    }

    public static class ExceptionFactory {
        public static Throwable getException(Enum e) {
            if (e != null) {
                String massage = e.toString().substring(0, 1)
                        + e.toString().substring(1).replaceAll("_", " ").toLowerCase();
                if (e instanceof ApplicationExceptionMessage) return new Exception(massage);
                if (e instanceof DatabaseExceptionMessage) return new RuntimeException(massage);
                if (e instanceof UserExceptionMessage) return new Error(massage);
            }
            return new IllegalArgumentException();
        }
    }
}
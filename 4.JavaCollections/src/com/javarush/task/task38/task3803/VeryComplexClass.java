package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        VeryComplexClass v = (VeryComplexClass) new Object();
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.contains("l");
    }

    public static void main(String[] args) {

    }
}

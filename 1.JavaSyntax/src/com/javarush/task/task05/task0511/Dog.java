package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    String name;
    int height;
    String color;
    public void initialize(String name) {//3
        this.name = name;
    }
    public void initialize(String name, int height) {//3
        this.name = name;
        this.height = height;
    }
    public void initialize(String name, int height, String color) {//3
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}

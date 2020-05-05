package com.javarush.task.task06.task0614;

/* 
Статические коты
*/

import java.util.ArrayList;

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat();
            cats.add(cat);
        }
        printCats();
    }

    public static void printCats() {
        cats.stream().forEach(System.out::println);
    }
}

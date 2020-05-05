package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    String name;
    int age;
    char sex;

    public void initialize(String name) {
        Friend friend = new Friend();
        this.name = name;

    }

    public void initialize(String name, int age) {
        Friend friend = new Friend();
        this.name = name;
        this.age = age;

    }

    public void initialize(String name, int age, char sex) {
        Friend friend = new Friend();
        this.name = name;
        this.age = age;
        this.sex = sex;

    }

    public static void main(String[] args) {

    }
}

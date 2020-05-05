package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
Создать класс Cat (кот) с пятью инициализаторами:


Задача инициализатора - сделать объект валидным.
Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касается возраста и цвета.
А вот имени может и не быть (null).
То же касается адреса: null.
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес (чужой домашний кот)
*/


public class Cat {
    public void initialize(String name) { //1
        this.name = name;
        this.age = 4;
        this.weight = 4;
        this.strength = 5;
        this.color = "color";
    }
    public void initialize(String name, int weight, int age) {//2
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = 5;
        this.color = "color";
    }
    public void initialize(String name, int age) {//3
        this.name = name;
        this.age = age;
        this.weight = 4;
        this.strength = 5;
        this.color = "color";

    }
    public void initialize(int weight, String color) {//4
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.strength = strength;
    }

    public void initialize(int weight, String color, String adress) {//5
        this.weight = weight;
        this.color = color;
        this.address = adress;
        this.age = age;
        this.strength = strength;
    }
    String name;
    int age = 4;
    int weight = 5;
    String address;
    String color = "color";


    int strength = 6;



    public static void main(String[] args) {

    }
}

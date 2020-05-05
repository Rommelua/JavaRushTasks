package com.javarush.task.task05.task0526;

/* 
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name (String), age (int), address (String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате: name + " " + age + " " + address


*/

public class Solution {
    public static void main(String[] args) {
        Man man = new Man("jj", 2, "ll");
        Man man1 = new Man("jj", 1, "ll");
        Woman w = new Woman("jf", 9, "jhdf");
        Woman w1 = new Woman("jf", 2, "jhdf");
        System.out.println(man);
        System.out.println(man1);
        System.out.println(w);
        System.out.println(w1);
    }

    public static class Man {
        String name;
        int age;
        String address;

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;
        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}

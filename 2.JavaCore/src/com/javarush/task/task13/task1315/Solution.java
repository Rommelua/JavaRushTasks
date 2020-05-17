package com.javarush.task.task13.task1315;

/* 
Создай классы Dog, Cat и Mouse.

*/

public class Solution {
    public static void main(String[] args) {

    }
    static class Dog implements Movable, Eat {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
    static class Cat implements Movable, Eat, Edible{
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void eat() {

        }
    }
    static class Mouse implements Movable, Edible{
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Edible {
        void beEaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
}
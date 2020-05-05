package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
       private byte a;
        private short b;
        private char c;
        private int d;
        private long e;
        private  boolean f;

        public Human(byte a, short b, char c, int d, long e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public Human(byte a, short b, char c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Human(byte a, short b) {
            this.a = a;
            this.b = b;
        }

        public Human(boolean f) {
            this.f = f;
        }

        public Human(long e) {
            this.e = e;
        }

        public Human(int d) {
            this.d = d;
        }

        public Human(char c) {
            this.c = c;
        }

        public Human(short b) {
            this.b = b;
        }

        public Human(byte a) {
            this.a = a;
        }

        public Human() {
        }
    }
}

package com.javarush.task.task03.task0315;

/* 
Каждый охотник желает знать…
Red
Orange
Yellow
Green
Blue
Indigo
Violet

*/

public class Solution {
    public static void main(String[] args) {
        Red f = new Red();//напишите тут ваш код
        Orange k = new Orange();
                Yellow m = new Yellow();
        Green kk = new Green();
                Blue b = new Blue();
        Indigo indigo = new Indigo();
                Violet ngg = new Violet();
    }

    public static class Red {
        public Red() {
            System.out.println("Red");
        }
    }

    public static class Orange {
        public Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow {
        public Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green {
        public Green() {
            System.out.println("Green");
        }
    }

    public static class Blue {
        public Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo {
        public Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet {
        public Violet() {
            System.out.println("Violet");
        }
    }
}

package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
        Human gf = new Human("k", true, 22);
        Human gm = new Human("k", false, 22);
        Human gf2 = new Human("k", true, 22);
        Human gm2 = new Human("k", false, 22);
        Human f = new Human("k", true, 22);
        Human m = new Human("k", false, 22);
        Human c1 = new Human("k", true, 22);
        Human c2 = new Human("k", true, 22);
        Human c3 = new Human("k", true, 22);
        Collections.addAll(gf.children, f);
        Collections.addAll(gm.children, f);
        Collections.addAll(gf2.children, m);
        Collections.addAll(gm2.children, m);
        Collections.addAll(f.children, c1, c2, c3);
        Collections.addAll(m.children, c1, c2, c3);
        System.out.println(gf);
        System.out.println(gm);
        System.out.println(gf2);
        System.out.println(gm2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

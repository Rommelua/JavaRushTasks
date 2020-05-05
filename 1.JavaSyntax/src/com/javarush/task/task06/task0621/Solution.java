package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Новая задача: У каждой кошки есть имя, кот-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.
*/

public class Solution {
    public static class Cat {
        private String name;
        private Cat mather;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mather, Cat father) {
            this.name = name;
            this.mather = mather;
            this.father = father;
        }

        @Override
        public String toString() {
            if (mather == null && father == null)
                return "The cat's name is " + name + ", no mother, no father";
            else if (father == null && mather != null)
                return "The cat's name is " + name + ", mother is " + mather.name + ", no father";
            else if (mather == null)
                return "The cat's name is " + name + ", no mother, father is " + father.name;
                return "The cat's name is " + name + ", mother is " + mather.name + ", father is " + father.name;
        }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
//                Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.


        String gfName = reader.readLine();
        Cat gf = new Cat(gfName);

        String gmName = reader.readLine();
        Cat gm = new Cat(gmName);

        String fName = reader.readLine();
        Cat f = new Cat(fName, null, gf);

        String mName = reader.readLine();
        Cat m = new Cat(mName, gm, null);

        String sName = reader.readLine();
        Cat s = new Cat(sName, m, f);

        String dName = reader.readLine();
        Cat d = new Cat(dName, m, f);

        System.out.println(gf);
        System.out.println(gm);
        System.out.println(f);
        System.out.println(m);
        System.out.println(s);
        System.out.println(d);
    }

    }

}

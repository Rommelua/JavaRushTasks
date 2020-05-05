package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
Создать 5 зергов, 3 протосса и 4 террана.
Дать им всем уникальные имена.
*/

public class Solution {
    public static void main(String[] args) {
        Zerg z1 = new Zerg();
        z1.name = "l";
        Zerg z2 = new Zerg();
        z2.name = "d";
        Zerg z3 = new Zerg();
        z3.name = "a";
        Zerg z4= new Zerg();
        z4.name = "ff";
        Zerg z5 = new Zerg();
        z5.name = ";;";
        Protoss p1 = new Protoss();
        p1.name = "ll";
        Protoss v = new Protoss();
        v.name = "ii";
        Protoss pb = new Protoss();
        pb.name = "lde";
        Terran terran = new Terran();
        terran.name = "wded";
        Terran terfran = new Terran();
        terfran.name = "kw";
        Terran tergran = new Terran();
        tergran.name = "jfhjf";
        Terran terrhan = new Terran();
        terrhan.name = "jhjhd";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}

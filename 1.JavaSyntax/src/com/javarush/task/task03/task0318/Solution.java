package com.javarush.task.task03.task0318;

/* 
План по захвату мира
"имя" захватит мир через "число" лет. Му-ха-ха!


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //напишите тут ваш код
        int year = Integer.parseInt(reader.readLine());
        String name = reader.readLine();

        System.out.println(name + " захватит мир через "+year +" лет. Му-ха-ха!");
    }
}

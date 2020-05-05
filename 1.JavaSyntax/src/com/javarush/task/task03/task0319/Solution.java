package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
Ввести с клавиатуры отдельно Имя, число1, число2.
Вывести надпись:
"Имя" получает "число1" через "число2" лет.


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //напишите тут ваш код
        String name = reader.readLine();
        int money = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());
        System.out.println(name + " получает "+money+" через "+year+" лет.");//напишите тут ваш код

    }
}

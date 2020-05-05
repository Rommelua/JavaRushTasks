package com.javarush.task.task04.task0414;

/* 
Количество дней в году
Ввести с клавиатуры год, определить количество дней в году. Результат вывести на экран в следующем виде:
количество дней в году: x

1) если год делится без остатка на 400 это високосный год;
2) в оставшихся годах после этого, если год делится без остатка на 100, то это обычный год;
3) в оставшихся годах после этого, если год делится без остатка на 4, то это високосный год;
4) все оставшиеся года невисокосные.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n%400 == 0)
            System.out.println("количество дней в году: 366");
        else if (n%100 == 0)
            System.out.println("количество дней в году: 365");
        else if (n%4 == 0)
            System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
    }
}
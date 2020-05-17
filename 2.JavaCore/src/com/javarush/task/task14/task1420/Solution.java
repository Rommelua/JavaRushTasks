package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }
        int nod = IntStream.iterate(a, x -> x - 1).filter(x-> a % x == 0 && b % x == 0).findFirst().getAsInt();
        System.out.println(nod);
    }
}

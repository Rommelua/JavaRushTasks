package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
/* 
Положительные и отрицательные числа
отрицательных чисел в исходном наборе, в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б",

*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        System.out.println("количество положительных чисел: " + IntStream.of(a,b,c).filter(i -> i>0).count());
        System.out.println("количество отрицательных чисел: " + IntStream.of(a,b,c).filter(i -> i<0).count());
    }
}

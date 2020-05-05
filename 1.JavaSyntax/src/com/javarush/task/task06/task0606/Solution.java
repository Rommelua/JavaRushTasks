package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        while (n > 0) {
//            if (n % 2 == 0)
//                even++;
//            else odd++;
//            n = n/10;
//        }
        String s = reader.readLine();
        even = (int) Stream.of(s.split("")).mapToInt(Integer::parseInt).filter(i -> i % 2 == 0).count();
        odd = s.length() - even;
        System.out.printf("Even: %d Odd: %d", even, odd);

    }
}

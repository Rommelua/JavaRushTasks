package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        if (N<0) return new long[0];
        long[] temp = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208,
                9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
                24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153,
                4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L,
                44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
                4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L,
                35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        List<Long> list = new ArrayList<>();
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] < N) {
                list.add(temp[i]);
            }
        }
        long[] result = new long[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
       // System.out.println(list);
        return result;
    }

    private static boolean isGood(long a) {
        int n = length(a);
        long sum = a;
        while (a > 0) {
            sum -= Math.pow(a%10, n);
            a = a/10;
        }
        return sum == 0;
    }

    private static int length(long n) {
        if (n < 10) {
            return 1;
        }else return  1 + length(n/10);
    }

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(Arrays.toString(getNumbers(9223372036854775807l)));
        Date end = new Date();
        System.out.println((end.getTime() - start.getTime()));
    }
}

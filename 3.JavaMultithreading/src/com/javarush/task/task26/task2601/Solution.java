package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
       // Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
//        Integer[] arr = new Integer[]{1, 2, 4, 17};
//        System.out.println(Arrays.toString(sort(arr)));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int median = array.length % 2 != 0 ?
                array[array.length / 2] :
                (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        Arrays.sort(array, Comparator.comparingInt(a -> Math.abs(median - (int) a))
                .thenComparingInt(a -> (int) a));
        return array;
    }
}

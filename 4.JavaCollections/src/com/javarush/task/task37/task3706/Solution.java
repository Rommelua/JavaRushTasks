package com.javarush.task.task37.task3706;

import java.util.*;

/* 
Давно забытый Array
*/
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.<Number>asList(1, 2, 3);
        addDataToList(numbers, getData());
        System.out.println(numbers);
        Map<Integer, String> map = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));
        map.put(null, "k");
        System.out.println(map);
        Number[] strings = numbers.toArray(new Number[0]);
    }

    public static Number[] getData() {
        return new Number[0];
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data) {
            list.add(number);
        }
    }
}

package com.javarush.task.task08.task0814;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(integer -> integer > 10);
        return set;
        //return set.stream().filter(s-> s <= 10).collect(Collectors.toSet());

    }

    public static void main(String[] args) {
//        Set<Integer> s = createSet();
//        s.add(222);
//        System.out.println(Arrays.toString(s.toArray()));
//        s = removeAllNumbersGreaterThan10(s);
//        System.out.println(Arrays.toString(s.toArray()));
    }
}

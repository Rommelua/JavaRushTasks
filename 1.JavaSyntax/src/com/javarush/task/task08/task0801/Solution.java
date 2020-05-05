package com.javarush.task.task08.task0801;

/* 
арбуз
банан
вишня
груша
дыня
ежевика
женьшень
земляника
ирис
картофель

*/

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        set.stream().forEach(System.out::println);

    }
}

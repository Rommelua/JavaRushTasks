package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Solution {
    public static void main(String[] args) {
//        testStrategy(new HashMapStorageStrategy(), 1000);
//        testStrategy(new OurHashMapStorageStrategy(), 1000);
//        testStrategy(new FileStorageStrategy(), 10);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream().mapToLong(shortener::getId)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream().map(shortener::getString).collect(Collectors.toSet());
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = LongStream.range(0, elementsNumber)
                .mapToObj(e -> Helper.generateRandomString()).collect(Collectors.toSet());
        Shortener shortener = new Shortener(strategy);
        Date startTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finTime = new Date();
        Helper.printMessage("время необходимое для отработки метода getIds: " + (finTime.getTime() - startTime.getTime()) + " мс");
        startTime = new Date();
        Set<String> stringsFromIds = getStrings(shortener, ids);
        finTime = new Date();
        Helper.printMessage("время необходимое для отработки метода getStrings: " + (finTime.getTime() - startTime.getTime()) + " мс");
        if (strings.size() == stringsFromIds.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}

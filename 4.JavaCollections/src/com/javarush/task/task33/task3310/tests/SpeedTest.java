package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startTime = new Date();
        strings.forEach(s -> ids.add(shortener.getId(s)));
        Date finTime = new Date();
        return finTime.getTime() - startTime.getTime();
    }
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTime = new Date();
        ids.forEach(id -> strings.add(shortener.getString(id)));
        Date finTime = new Date();
        return finTime.getTime() - startTime.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = LongStream.range(0, 10_000)
                .mapToObj(e -> Helper.generateRandomString()).collect(Collectors.toSet());

        Set<Long> ids1 = new HashSet<>();
        long time1 = getTimeToGetIds(shortener1, origStrings, ids1);
        Set<Long> ids2 = new HashSet<>();
        long time2 = getTimeToGetIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);

        Set<String> strings1 = new HashSet<>();
        time1 = getTimeToGetStrings(shortener1, ids1, strings1);
        Set<String> strings2 = new HashSet<>();
        time2 = getTimeToGetStrings(shortener2, ids2, strings2);
        Assert.assertEquals(time1, time2, 30f);
    }
}

package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticManager {
    private static volatile StatisticManager mInstance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (mInstance == null) {
            synchronized (StatisticManager.class) {
                if (mInstance == null) {
                    mInstance = new StatisticManager();
                }
            }
        }
        return mInstance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    /**
     * Profit from shoving advertisement per days
     * @return Map<Date, Long>
     */
    public Map<Date, Long> getAdvProfitPerDays() {
        Map<Date, Long> result = new HashMap<>();
        statisticStorage.storage.get(EventType.SELECTED_VIDEOS).stream()
                .map(e -> (VideoSelectedEventDataRow)e) //получаем стрим событий и приводим к классу VideoSelectedEventDataRow
                .peek(VideoSelectedEventDataRow::removeTimeFromCurrentDate) //убираем время суток, оставляем голую дату
                .forEach(e -> result.compute(e.getDate(), // заполняем мапу. если ключа нет - вставляем, если есть - прибавляем
                        (k, v) -> v == null ? e.getAmount() : v + e.getAmount()));
        return result;
    }

    /**
     * Work Loading per dates
     * @return Map<Date, Map<String, Integer>> where key - Cook name, value - work loading in seconds
     */
//    public Map<Date, Map<String, Integer>> getCookWorkloading() {
//        Map<Date, Map<String, Integer>> result = statisticStorage.storage.get(EventType.COOKED_ORDER).stream()
//                .map(e -> (CookedOrderEventDataRow)e)//получаем стрим событий и приводим к классу CookedOrderEventDataRow
//                .peek(CookedOrderEventDataRow::removeTimeFromCurrentDate)//убираем время суток, оставляем голую дату
//                .collect(Collectors.toMap( //Собираем мапу
//                        CookedOrderEventDataRow::getDate, //ключ - дата, значение (если нет ключа) - новая мапа
//                        e -> new TreeMap<String, Integer>(){{put(e.getCookName(), Math.toIntExact(Math.round(e.getTime() / 60.0)));}},
//                        (a, b) -> {a.compute(b.keySet().iterator().next(), //есди ключ (дата) уже был - вызываем compute и проверяем,
//                                (k, v) -> k == null ? b.get(k) : a.get(k) + b.get(k));//есть ли ключ во вложенной мапе
//                                return a;}));// для повара либо создан новый элемент, либо значение прибавлено к существующему
//        return result;
//    }

    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        List<EventDataRow> eventDataRows = statisticStorage.storage.get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> result = new HashMap<>();
        for (EventDataRow event : eventDataRows) {
            CookedOrderEventDataRow cookedEv = (CookedOrderEventDataRow) event;
            cookedEv.removeTimeFromCurrentDate();
            Date date = cookedEv.getDate();
            int workMinutes = Math.toIntExact(Math.round(cookedEv.getTime() / 60.0));
            if (result.containsKey(date)) {
                result.get(date).compute(cookedEv.getCookName(),
                        (k, v) -> v == null ? workMinutes : v + workMinutes);
            } else {
                Map<String, Integer> cook = new TreeMap<>();
                cook.put(cookedEv.getCookName(), workMinutes);
                result.put(date, cook);
            }
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
                storage.get(data.getType()).add(data);
        }
    }
}

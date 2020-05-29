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
    private Set<Cook> cooks = new HashSet<>();

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

    public void register(Cook cook) {
        cooks.add(cook);
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
    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        Map<Date, Map<String, Integer>> result = statisticStorage.storage.get(EventType.COOKED_ORDER).stream()
                .map(e -> (CookedOrderEventDataRow)e)//получаем стрим событий и приводим к классу CookedOrderEventDataRow
                .peek(CookedOrderEventDataRow::removeTimeFromCurrentDate)//убираем время суток, оставляем голую дату
                .collect(Collectors.toMap( //Собираем мапу
                        CookedOrderEventDataRow::getDate, //ключ - дата, значение (если нет ключа) - новая мапа
                        e -> new LinkedHashMap<String, Integer>(){{put(e.getCookName(), e.getTime());}},
                        (a, b) -> {a.compute(b.keySet().iterator().next(), //есди ключ (дата) уже был - вызываем compute и проверяем,
                                (k, v) -> k == null ? b.get(k) : a.get(k) + b.get(k));//есть ли ключ во вложенной мапе
                                return a;}));// для повара либо создан новый элемент, либо значение прибавлено к существующему
//        result.put(new Date(120, 4, 30), new LinkedHashMap<>(){{put("AmigoTest", 65); put("Amigo", 50);}});
//        result.put(new Date(120, 4, 31), new LinkedHashMap<>(){{put("AmigoTest", 65); put("Amigo", 50);}});
//        result.put(new Date(120, 4, 25), new LinkedHashMap<>(){{put("AmigoTest", 65); put("Amigo", 50);}});
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
            switch (data.getType()) {
                case COOKED_ORDER:
                    storage.get(EventType.COOKED_ORDER).add(data);
                    break;
                case SELECTED_VIDEOS:
                    storage.get(EventType.SELECTED_VIDEOS).add(data);
                    break;
                case NO_AVAILABLE_VIDEO:
                    storage.get(EventType.NO_AVAILABLE_VIDEO).add(data);
            }
        }
    }
}

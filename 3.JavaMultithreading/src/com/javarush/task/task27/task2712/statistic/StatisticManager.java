package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
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
                .peek(e -> e.getDate().setSeconds(0))
                .peek(e -> e.getDate().setMinutes(0))
                .peek(e -> e.getDate().setHours(0))
                .peek(e -> e.getDate().setTime(e.getDate().getTime() / 1000 * 1000))
                .forEach(e -> result.compute(e.getDate(),
                        (k, v) -> v == null ? ((VideoSelectedEventDataRow)e).getAmount()
                                : v + ((VideoSelectedEventDataRow)e).getAmount()));
        result.put(new Date(120, 4, 14), 250L);
        result.put(new Date(120, 4, 13), 102L);
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

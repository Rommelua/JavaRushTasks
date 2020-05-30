package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    private static volatile StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (instance == null) {
                    instance = new StatisticAdvertisementManager();
                }
            }
        }
        return instance;
    }

    public List<Advertisement> getActiveVideos() {
        return storage.list().stream().filter(video -> video.getHits() > 0).collect(Collectors.toList());
    }

    public List<Advertisement> getArchivedVideos() {
        return storage.list().stream().filter(video -> video.getHits() == 0).collect(Collectors.toList());
    }
}

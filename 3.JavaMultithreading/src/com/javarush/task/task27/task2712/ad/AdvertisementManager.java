package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<List<Advertisement>> variants = new ArrayList<>();
        List<Advertisement> videoSet = new ArrayList<>(storage.list());
        videoSet = videoSet.stream().filter(v -> v.getHits()>0)
                .sorted(Comparator.comparing(Advertisement::getAmountPerOneDisplaying, reverseOrder())
                    .thenComparing(Advertisement::getDuration, reverseOrder()))
                .collect(Collectors.toList()); // 1st
        variants.add(addVideos(videoSet));
        videoSet.sort(Comparator.comparing(Advertisement::getAmountPerSecond, reverseOrder())
                .thenComparing(Advertisement::getDuration)); //2nd
        variants.add(addVideos(videoSet));
        videoSet.sort(Comparator.comparingInt(Advertisement::getDuration)); //3rd
        variants.add(addVideos(videoSet));
        variants.sort(Comparator.comparing(AdvertisementManager::getTotalAmount, reverseOrder())
                .thenComparing(AdvertisementManager::getTotalDuration, reverseOrder())
                .thenComparingInt(List::size));
        List<Advertisement> resultVideoSet = variants.get(0);
        VideoSelectedEventDataRow event = new VideoSelectedEventDataRow(resultVideoSet, // Registering event
                getTotalAmount(resultVideoSet), getTotalDuration(resultVideoSet));
        StatisticManager.getInstance().register(event);
        resultVideoSet.stream().peek(Advertisement::revalidate)
                .sorted(Comparator.comparing(Advertisement::getAmountPerOneDisplaying, reverseOrder())
                    .thenComparingLong(Advertisement::getAmountPerSecond))
                .forEach(adv -> ConsoleHelper.writeMessage(adv.toString()));
    }

    private List<Advertisement> addVideos(List<Advertisement> videoSet) {
        List<Advertisement> result = new ArrayList<>();
        for (int i = 0; i < videoSet.size(); i++) {
            if (getTotalDuration(result) + videoSet.get(i).getDuration() <= timeSeconds) {
                result.add(videoSet.get(i));
            }
        }
        return result;
    }

    private static int getTotalDuration(List<Advertisement> result) {
        return result.stream().mapToInt(Advertisement::getDuration).sum();
    }
    private static long getTotalAmount(List<Advertisement> result){
        return result.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
    }
}

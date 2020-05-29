package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public long getAmount() {
        return amount;
    }
    public void removeTimeFromCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        try {
            currentDate = dateFormat.parse(dateFormat.format(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }
}

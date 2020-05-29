package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках.
    private int hits; //количество оплаченных показов
    private int duration; //продолжительность в секундах
    private long amountPerOneDisplaying; //стоимость одного показа
    private long amountPerSecond; //стоимость секунды показа

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getAmountPerSecond() {
        return amountPerSecond;
    }

    public int getHits() {
        return hits;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
        amountPerSecond = amountPerOneDisplaying * 1000 / duration;
    }
    public void revalidate(){
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }
    @Override
    public String toString() {
        return name + " is displaying... " +
                amountPerOneDisplaying + ", " + amountPerSecond;
    }
}

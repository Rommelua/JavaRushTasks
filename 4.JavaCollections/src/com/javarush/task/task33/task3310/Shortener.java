package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    /**
     * последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище
     */
    private Long lastId = 0L;
    /**
     * стратегия хранения данных
     */
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    /**
     * Возвращает Id для переданной строки.
     * Добавляет строку если ее нет в хранилище.
     * @param string
     * @return
     */
    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)) return storageStrategy.getKey(string);
        storageStrategy.put(++lastId, string);
        return lastId;
    }
    
    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }
}

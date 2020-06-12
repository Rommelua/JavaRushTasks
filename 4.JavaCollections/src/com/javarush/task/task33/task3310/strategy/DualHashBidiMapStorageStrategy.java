package com.javarush.task.task33.task3310.strategy;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class DualHashBidiMapStorageStrategy implements StorageStrategy {
    private DualHashBidiMap<Long, String> data = new DualHashBidiMap<>();

    /**
     * должен вернуть true, если хранилище
     * содержит переданный ключ.
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    /**
     * должен вернуть true, если хранилище
     * содержит переданное значение.
     *
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    /**
     * добавить в хранилище новую пару ключ -
     * значение.
     *
     * @param key
     * @param value
     */
    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    /**
     * вернуть ключ для переданного значения
     *
     * @param value
     * @return
     */
    @Override
    public Long getKey(String value) {
        return data.getKey(value);
    }

    /**
     * вернуть значение для переданного ключа
     *
     * @param key
     * @return
     */
    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}

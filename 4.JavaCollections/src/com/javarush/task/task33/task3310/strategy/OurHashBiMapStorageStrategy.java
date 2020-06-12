package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();

    /**
     * должен вернуть true, если хранилище
     * содержит переданный ключ.
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
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
        return v2k.containsKey(value);
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
        k2v.put(key, value);
        v2k.put(value, key);
    }

    /**
     * вернуть ключ для переданного значения
     *
     * @param value
     * @return
     */
    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    /**
     * вернуть значение для переданного ключа
     *
     * @param key
     * @return
     */
    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}

package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 2;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000L;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    /**
     * Вычисляет позицию в массиве table для ключа key
     *
     * @param key
     * @return
     */
    int indexFor(long key) {
        return (int) (key % table.length);
    }

    /**
     * Создает и добавляет Entry с заданными параметрами.
     * Если для нужной позиции в table отсутствует FileBucket, то создается новый.
     * Если FileBucket есть, его первая Entry становиться "next" для новой Entry.
     * В случае превышения лимита размера файла FileBucket вызывается метод resize().
     *
     * @param key
     * @param value
     */
    void addEntry(Long key, String value) {
        Entry newEntry = new Entry(0, key, value, null);
        FileBucket fb = table[indexFor(key)];
        if (fb == null) {
            fb = new FileBucket();
            fb.putEntry(newEntry);
            table[indexFor(key)] = fb;
        } else {
            newEntry.next = fb.getEntry();
            fb.putEntry(newEntry);
            if (fb.getFileSize() > bucketSizeLimit) {
                resize(table.length << 1);
            }
        }
    }

    /**
     * Перемещает все Entry на новые позиции в соответствии с новым размером Table.
     * @param newCapacity
     */
    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (FileBucket fb : table) {
            if (fb != null) {
                Entry e = fb.getEntry();
                while (e != null) {
                    addEntry(e.key, e.value);
                    e = e.next;
                }
                fb.remove();
            }
        }
        table = newTable;
    }

    /**
     * должен вернуть true, если хранилище
     * содержит переданный ключ.
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Long key) {
        return getValue(key) != null;
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
        return !getKey(value).equals(0L);
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
        for (FileBucket fb : table) {
            if (fb != null) {
                Entry firstEntry = fb.getEntry();
                Entry e = firstEntry;
                while (e != null) {
                    if (e.key.equals(key)) {
                        e.value = value;
                        fb.remove();
                        fb.putEntry(firstEntry);
                        return;
                    }
                    e = e.next;
                }
            }
        }
        addEntry(key, value);
    }

    /**
     * вернуть ключ для переданного значения
     *
     * @param value
     * @return
     */
    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            if (fb != null) {
                Entry e = fb.getEntry();
                while (e != null) {
                    if (e.value != null && e.value.equals(value)) return e.key;
                    e = e.next;
                }
            }
        }
        return 0L;
    }

    /**
     * вернуть значение для переданного ключа
     *
     * @param key
     * @return
     */
    @Override
    public String getValue(Long key) {
        for (FileBucket fb : table) {
            if (fb != null) {
                Entry e = fb.getEntry();
                while (e != null) {
                    if (e.key != null && e.key.equals(key)) return e.value;
                    e = e.next;
                }
            }
        }
        return null;
    }
}

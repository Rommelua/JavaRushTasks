package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(Thread.MIN_PRIORITY);
    {
        setStartPriority();
    }
    private void setStartPriority() {
        setPriority(priority.getAndIncrement());
        if (priority.get() > Thread.MAX_PRIORITY) {
            priority.set(Thread.MIN_PRIORITY);
        }
        if (getThreadGroup().getMaxPriority() < getPriority()) {
            setPriority(getThreadGroup().getMaxPriority());
        }
    }

    public MyThread() {
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

}

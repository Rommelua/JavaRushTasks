package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String separ = System.lineSeparator();
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            return;
        }
        while (!Thread.currentThread().isInterrupted()){
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s%s", item.toString(), separ);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        if (e.getCause() != null) {
            uncaughtException(t, e.getCause());
            System.out.println(e);
        } else System.out.println(e);

    }

    public static void main(String[] args) throws Exception {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    throw new RuntimeException("111", new RuntimeException("DEF", new IllegalAccessException("GHI")));
//                }
//            }
//        });
//        thread.setUncaughtExceptionHandler(new Solution());
//        thread.start();
    }
}

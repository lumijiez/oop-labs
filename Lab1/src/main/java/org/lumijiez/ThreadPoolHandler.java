package org.lumijiez;

import java.util.ArrayList;

public class ThreadPoolHandler {
    private final ArrayList<Thread> threadPool = new ArrayList<>();

    public static void safeSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addThread(Thread thread) {
        threadPool.add(thread);
    }

    public void addThreadWhileRunning(Thread thread) {
        threadPool.add(thread);
        thread.start();
    }

    public void startAll() {
        for (Thread thread : threadPool) {
            thread.start();
        }
    }

    public void interruptAll() {
        for (Thread thread : threadPool) {
            thread.interrupt();
        }
    }

    public void deleteAll() {
        this.interruptAll();
        threadPool.clear();
    }
}

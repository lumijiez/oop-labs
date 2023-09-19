package org.lumijiez;

public class Main {
    public static void main(String[] args) {

        // Printer class initialization, with an PrintHandler dependency injection
        Printer out = new Printer(new PrintHandler());

        // Pool handler, stores all threads and manipulates them
        ThreadPoolHandler TH = new ThreadPoolHandler();

        // Fills the threadpool with runnables
        TH.addThread(new Thread(new OutputRunnable(out, "Hello world!", 1000)));
        TH.addThread(new Thread(new OutputRunnable(out, "I love OOP!", 2000)));

        // Starts the async printing threads
        TH.startAll();

        // Keep printing for 5 seconds
        ThreadPoolHandler.safeSleep(5000);

        // Add a thread while the others are running
        TH.addThreadWhileRunning(new Thread(new OutputRunnable(out, "Added while running!", 500)));

        // Keep printing for 5 seconds
        ThreadPoolHandler.safeSleep(5000);

        // Stop all running threads
        TH.deleteAll();

        out.print("Bye-bye!");
    }
}
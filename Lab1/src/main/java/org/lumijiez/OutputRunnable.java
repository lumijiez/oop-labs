package org.lumijiez;

public class OutputRunnable implements Runnable {

    // Printer dependency
    private final Printer printer;

    private final String text;
    private final int sleepInterval;

    public OutputRunnable(Printer printer, String text, int sleepInterval) {
        this.printer = printer;
        this.text = text;
        this.sleepInterval = sleepInterval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                printer.print(text);
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                // Thread was interrupted, exit the loop
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

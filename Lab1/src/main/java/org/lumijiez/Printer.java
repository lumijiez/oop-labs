package org.lumijiez;

import org.lumijiez.interfaces.PrinterImpl;

public class Printer implements PrinterImpl {

    // Dependency Injection
    private final PrintHandler handler;

    // Constructor
    public Printer(PrintHandler handler) {
        this.handler = handler;
    }

    // Dependency Consumer
    @Override
    public void print(String text) {
        this.handler.output(text);
    }
}

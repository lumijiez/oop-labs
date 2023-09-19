package org.lumijiez;

import org.lumijiez.interfaces.PrintHandlerImpl;

// Handler, to be injected as a dependency
public class PrintHandler implements PrintHandlerImpl {

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}

package org.lumijiez.managers;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {

    private transient BufferedWriter writer;

    private void init() {
        BufferedWriter writerTemp;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String fileHandle = "log-" + currentDateTime.format(formatter) + ".txt";
        try {
            FileWriter fwriter = new FileWriter(fileHandle);
            writerTemp = new BufferedWriter(fwriter);
        } catch (IOException e) {
            System.err.println("Error!");
            writerTemp = null;
        }
        this.writer = writerTemp;
    }

    public void logOperation(String msg) {
        if (writer == null) init();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss |");
        try {
            writer.write(currentDateTime.format(formatter) + msg);
            writer.flush();
            System.out.println(msg);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error!");
        }
    }

    public void close() {
        try {
            this.writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

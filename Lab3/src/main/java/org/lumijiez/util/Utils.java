package org.lumijiez.util;

import org.lumijiez.base.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static int countWords(Document doc)  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            reader.close();
            return wordCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int countLines(Document doc) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            int lineCount = 0;
            while (reader.readLine() != null) lineCount++;
            reader.close();
            return lineCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long countChars(Document doc) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            long characterCount = 0;
            while (reader.read() != -1) characterCount++;
            reader.close();
            return characterCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

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

    public static int countClasses(Document doc) {
        int classCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.matches(".*class\\s+\\w+.*") || line.matches(".*def\\s+\\w+.*")) {
                    classCount++;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classCount;
    }

    public static int countMethods(Document doc) {
        int methodCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.matches(".*def\\s+\\w+.*") || line.matches(".*\\b(public|private|protected)?\\s+(static\\s+)?\\w+\\s+\\w+\\(.*\\)\\s*\\{.*")) {
                    methodCount++;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return methodCount;
    }
}

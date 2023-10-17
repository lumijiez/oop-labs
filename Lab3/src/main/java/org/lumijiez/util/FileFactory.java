package org.lumijiez.util;

import org.lumijiez.base.*;

import java.nio.file.Path;

public class FileFactory {
    public static Document getDocument(Path path) {
        Document doc = new Document(path);
        switch (doc.getFileType()) {
            case PLAINTEXT -> {
                return new TextFile(path);
            }
            case IMAGE -> {
                return new ImageFile(path);
            }
            case FILE -> {
                return new ArbitraryFile(path);
            }
            case CODE -> {
                return new CodeFile(path);
            }
        }
        return doc;
    }
}

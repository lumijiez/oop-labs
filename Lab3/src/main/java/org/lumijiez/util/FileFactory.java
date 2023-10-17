package org.lumijiez.util;

import org.lumijiez.base.*;
import org.lumijiez.enums.FileType;

import java.nio.file.Path;

public class FileFactory {
    public static Document getDocument(Path path) {
        Document doc = new Document(path);
        if (doc.getFileType() == FileType.PLAINTEXT) return new TextFile(path);
        if (doc.getFileType() == FileType.IMAGE) return new ImageFile(path);
        if (doc.getFileType() == FileType.FILE) return new ArbitraryFile(path);
        if (doc.getFileType() == FileType.CODE) return new CodeFile(path);
        return doc;
    }
}

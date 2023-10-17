package org.lumijiez.enums;

import java.util.ArrayList;
import java.util.List;

public enum FileType {
    IMAGE, PLAINTEXT, FILE, CODE;
    public List<String> typeExtensions;

    static {
        IMAGE.typeExtensions = new ArrayList<>(List.of("jpg", "png"));
        PLAINTEXT.typeExtensions = new ArrayList<>(List.of("txt", "csv"));
        FILE.typeExtensions = new ArrayList<>(List.of("doc", "pdf", "zip"));
        CODE.typeExtensions = new ArrayList<>(List.of("java", "cpp", "py"));
    }
}

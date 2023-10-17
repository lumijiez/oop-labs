package org.lumijiez.enums;

import java.util.ArrayList;
import java.util.List;

public enum FileType {
    IMAGE("Image"), PLAINTEXT("Plaintext"), FILE("File"), CODE("Code"), NONE("None");
    public List<String> typeExtensions;
    public final String typeName;

    FileType(String typeName) {
        this.typeName = typeName;
    }

    public static FileType getFileType(String extension) {
        for (FileType fileType : values()) {
            if (fileType.typeExtensions.contains(extension.toLowerCase())) {
                return fileType;
            }
        }
        return NONE;
    }

    static {
        IMAGE.typeExtensions = new ArrayList<>(List.of("jpg", "png"));
        PLAINTEXT.typeExtensions = new ArrayList<>(List.of("txt", "csv"));
        FILE.typeExtensions = new ArrayList<>(List.of("doc", "pdf", "zip"));
        CODE.typeExtensions = new ArrayList<>(List.of("java", "cpp", "py"));
    }
}

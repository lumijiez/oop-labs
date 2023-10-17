package org.lumijiez.enums;

import java.util.ArrayList;
import java.util.List;

public enum FileType {
    IMAGE("Image", new ArrayList<>(List.of("jpg", "png"))),
    PLAINTEXT("Plaintext", new ArrayList<>(List.of("txt", "csv"))),
    FILE("File", new ArrayList<>(List.of("doc", "pdf", "zip"))),
    CODE("Code", new ArrayList<>(List.of("java", "cpp", "py"))),
    NONE("None", new ArrayList<>());

    private final List<String> typeExtensions;
    private final String typeName;

    FileType(String typeName, ArrayList<String> list) {
        this.typeName = typeName;
        this.typeExtensions = list;
    }

    public static FileType getFileType(String extension) {
        for (FileType fileType : values()) {
            if (fileType.typeExtensions.contains(extension.toLowerCase())) {
                return fileType;
            }
        }
        return NONE;
    }

    public String getTypeName() {
        return typeName;
    }


}

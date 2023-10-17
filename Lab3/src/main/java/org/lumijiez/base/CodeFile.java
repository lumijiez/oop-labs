package org.lumijiez.base;

import org.lumijiez.util.Utils;

import java.nio.file.Path;

public class CodeFile extends Document{
    public CodeFile(Path path) {
        super(path);
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Type: ").append(getFileType().getTypeName()).append("<br>");
        info.append("Extension: ").append(getExtension().toUpperCase()).append("<br>");
        info.append("File size: ").append(getFilesizeKB()).append(" KB").append("<br>");
        info.append("Lines: ").append(Utils.countLines(this)).append("<br>");
        info.append("Created at: ").append(getCreatedTime()).append("<br>");
        info.append("Modified at: ").append(getModificationTime()).append("<br>");
        return info.toString();
    }
}

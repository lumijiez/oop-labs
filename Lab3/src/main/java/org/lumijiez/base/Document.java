package org.lumijiez.base;

import org.lumijiez.enums.FileType;
import org.lumijiez.interfaces.IDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class Document extends File implements IDocument {
    private String extension;
    private FileType fileType;

    public Document(Path path) {
        super(path.toString());
        init();
    }

    private void init() {
        int lastDotIndex = getName().lastIndexOf('.');
        extension = (lastDotIndex > 0) ? getName().substring(lastDotIndex + 1) : "";
        fileType = FileType.getFileType(extension);
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public Date getCreatedTime() {
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Path.of(this.getPath()), BasicFileAttributes.class);
            return new Date(fileAttributes.creationTime().toMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Date getModificationTime() {
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Path.of(this.getPath()), BasicFileAttributes.class);
            return new Date(fileAttributes.lastAccessTime().toMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileType getFileType() {
        return fileType;
    }
}

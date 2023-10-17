package org.lumijiez.base;

import org.lumijiez.enums.FileType;
import org.lumijiez.interfaces.IDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
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
    public String getCreatedTime() {
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Path.of(this.getPath()), BasicFileAttributes.class);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            Date date = new Date(fileAttributes.creationTime().toMillis());

            String formattedDate = dateFormat.format(date);
            String formattedTime = timeFormat.format(date);

            return formattedTime + " " + formattedDate;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getModificationTime() {
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Path.of(this.getPath()), BasicFileAttributes.class);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            Date date = new Date(fileAttributes.lastModifiedTime().toMillis());

            String formattedDate = dateFormat.format(date);
            String formattedTime = timeFormat.format(date);

            return formattedTime + " " + formattedDate;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileType getFileType() {
        return fileType;
    }

    @Override
    public long getFilesizeKB() {
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Path.of(this.getPath()), BasicFileAttributes.class);
            return fileAttributes.size() / 1024;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + " Size: " + getFilesizeKB() + "Type: " + getFileType().getTypeName();
    }
}

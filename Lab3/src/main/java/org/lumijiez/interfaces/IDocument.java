package org.lumijiez.interfaces;

import org.lumijiez.enums.FileType;

import java.util.Date;

public interface IDocument {
    String getExtension();
    Date getCreatedTime();
    Date getModificationTime();
    FileType getFileType();
    long getFilesizeKB();
    String getInfo();
}

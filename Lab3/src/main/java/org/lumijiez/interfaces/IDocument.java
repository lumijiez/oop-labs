package org.lumijiez.interfaces;

import org.lumijiez.enums.FileType;

public interface IDocument {
    String getExtension();
    String getCreatedTime();
    String getModificationTime();
    FileType getFileType();
    long getFilesizeKB();
    String getInfo();
}

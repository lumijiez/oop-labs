package org.lumijiez.interfaces;

import org.lumijiez.enums.FileType;

import java.util.Date;

public interface IDocument {
    public String getExtension();
    public Date getCreatedTime();
    public Date getModificationTime();
    public FileType getFileType();
}

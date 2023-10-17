package org.lumijiez.base;

import org.lumijiez.enums.FileType;
import org.lumijiez.interfaces.IDocument;

import java.util.Date;

public class Document implements IDocument {
    private String fullFilename = "";
    private FileType fileType;
    private Date createdAt;
    private Date modifiedAt;

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getExtension() {
        return null;
    }

    @Override
    public Date getCreatedTime() {
        return null;
    }

    @Override
    public Date getModificationTime() {
        return null;
    }
}

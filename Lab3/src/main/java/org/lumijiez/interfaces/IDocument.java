package org.lumijiez.interfaces;

import java.util.Date;

public interface IDocument {
    public String getFilename();
    public String getExtension();
    public Date getCreatedTime();
    public Date getModificationTime();
}

package org.lumijiez.base;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class ImageFile extends Document {
    public ImageFile(Path path) {
        super(path);
    }
    @Override
    public String getInfo() {
        try {
            StringBuilder info = new StringBuilder();
            info.append("Type: ").append(getFileType().getTypeName()).append("<br>");
            info.append("Extension: ").append(getExtension().toUpperCase()).append("<br>");
            BufferedImage image = ImageIO.read(this);
            info.append("Dimensions: ").append(image.getWidth()).append("x").append(image.getHeight()).append("<br>");
            info.append("File size: ").append(getFilesizeKB()).append(" KB").append("<br>");
            info.append("Created at: ").append(getCreatedTime()).append("<br>");
            info.append("Modified at: ").append(getModificationTime()).append("<br>");
            return info.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

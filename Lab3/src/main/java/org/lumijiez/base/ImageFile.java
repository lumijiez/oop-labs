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
            BufferedImage image = ImageIO.read(this);
            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();
                return "IMAGE " + width + "x" + height;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

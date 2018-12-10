package image.impl;

import image.Image;
import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage extends Image {

    RasterImage(Color color, int width, int height) {
        super(width, height);

        createRepresentation();
        setPixelsColor(color);
    }

    RasterImage(Color[][] colors) {
        Matrices.requiresNonNull(colors);
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonZeroDimensions(colors);

        setWidth(colors.length);
        setHeight(colors[0].length);

        createRepresentation();
        setPixelsColor(colors);
    }

    public abstract void createRepresentation();

    void setPixelsColor(Color[][] pixels) {
        for(int x = 0; x < getWidth(); ++x) {
            for(int y = 0; y < getHeight(); ++y) {
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    void setPixelsColor(Color color) {
        for(int x = 0; x < getWidth(); ++x) {
            for(int y = 0; y < getHeight(); ++y) {
                setPixelColor(color, x, y);
            }
        }
    }

    public abstract void setPixelColor(Color color, int x, int y);
}

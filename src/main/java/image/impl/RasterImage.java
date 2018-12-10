package image.impl;

import image.Image;
import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {
    private int width;
    private int height;

    RasterImage(Color color, int width, int height) {
        setWidth(width);
        setHeight(height);

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
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    void setPixelsColor(Color color) {
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                setPixelColor(color, x, y);
            }
        }
    }

    public abstract void setPixelColor(Color color, int x, int y);

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}

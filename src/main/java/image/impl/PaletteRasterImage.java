package image.impl;

import image.Image;
import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private List<Color> palette;
    private int[][] pixels;

    public PaletteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;

        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] colors) {
        Matrices.requiresNonNull(colors);
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonZeroDimensions(colors);

        width = colors.length;
        height = colors[0].length;

        createRepresentation();
        setPixelsColor(colors);
    }

    public void createRepresentation() {
        palette = new ArrayList<>();
        pixels = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y) {
        if(!palette.contains(color))
            palette.add(color);

        pixels[x][y] = palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(pixels[x][y]);
    }

    private void setPixelsColor(Color[][] pixels) {
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    private void setPixelsColor(Color color) {
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                setPixelColor(color, x, y);
            }
        }
    }

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

package image.impl;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {

    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] colors) {
        super(colors);
    }

    public void createRepresentation() {
        pixels = new Color[getWidth()][getHeight()];
    }

    public void setPixelColor(Color color, int x, int y) {
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }
}

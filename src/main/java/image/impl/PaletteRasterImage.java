package image.impl;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    private List<Color> palette;
    private int[][] pixels;

    public PaletteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] colors) {
        super(colors);
    }

    public void createRepresentation() {
        palette = new ArrayList<>();
        pixels = new int[getWidth()][getHeight()];
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
}

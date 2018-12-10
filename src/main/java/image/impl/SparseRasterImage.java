package image.impl;

import image.Point;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {

    private Map<Point, Color> pixels;

    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] colors) {
        super(colors);
    }

    public void createRepresentation() {
        pixels = new HashMap<>();
    }

    public void setPixelColor(Color color, int x, int y) {
        if(Color.WHITE.equals(color)) {
            pixels.remove(new Point(x, y));
        } else {
            pixels.put(new Point(x, y), color);
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels.getOrDefault(new Point(x, y), Color.WHITE);
    }
}

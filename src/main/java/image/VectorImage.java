package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image {

    private int width, height;
    private List<Shape> shapes;

    VectorImage(List<Shape> shapes, int width, int height) {
        setWidth(width);
        setHeight(height);

        this.shapes = shapes;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Point p = new Point(x, y);

        return shapes.stream()
                .filter(shape -> shape.contains(p))
                .map(Shape::getColor)
                .findFirst()
                .orElse(Color.WHITE);
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

package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage extends Image {

    private List<Shape> shapes;

    VectorImage(List<Shape> shapes, int width, int height) {
        super(width, height);

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
}

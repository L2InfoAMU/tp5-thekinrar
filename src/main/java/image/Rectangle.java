package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    private int x1, y1, x2, y2;
    private Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
        x1 = x;
        y1 = y;

        x2 = x + width;
        y2 = y + height;

        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return point.x >= x1 && point.x <= x2 && point.y >= y1 && point.y <= y2;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

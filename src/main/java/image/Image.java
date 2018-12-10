package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public abstract class Image {
    private int width;
    private int height;

    public Image() {}

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract Color getPixelColor(int x, int y);

    public int getWidth() {
        return width;
    }

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

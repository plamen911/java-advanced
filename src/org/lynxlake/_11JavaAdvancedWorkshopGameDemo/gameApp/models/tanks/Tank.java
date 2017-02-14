package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tank {

    private int x;
    private int y;
    private ImageView currentImage;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = new ImageView(currentImage);
    }
}

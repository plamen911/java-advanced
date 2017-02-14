package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class PlayerTank extends Tank {

    private static final Image UP_IMAGE = new Image("/tanks/silver_tank/silver_tank_up.png");
    private static final Image DOWN_IMAGE = new Image("/tanks/silver_tank/silver_tank_down.png");
    private static final Image LEFT_IMAGE = new Image("/tanks/silver_tank/silver_tank_left.png");
    private static final Image RIGHT_IMAGE = new Image("/tanks/silver_tank/silver_tank_right.png");

    public PlayerTank(int x, int y) {
        super(x, y);
        super.setCurrentImage(UP_IMAGE);
    }

    public void draw(GraphicsContext graphicsContext) {

        Scene scene = graphicsContext.getCanvas().getScene();
        double maxWidth = graphicsContext.getCanvas().getWidth();
        double maxHeight = graphicsContext.getCanvas().getHeight();
        scene.setOnKeyPressed(event -> {
            this.move(event.getCode());
            this.inRange(maxWidth,maxHeight);
            event.consume();
            graphicsContext.fillRect(0, 0, scene.getWidth(), scene.getHeight());
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.drawImage(this.getCurrentImage().getImage(), this.getX(), this.getY());
        });
    }

    private void move(KeyCode keyCode) {
        switch (keyCode) {
            case RIGHT:
                this.setX(this.getX() + 20);
                this.setCurrentImage(RIGHT_IMAGE);
                break;
            case LEFT:
                this.setX(this.getX() - 20);
                this.setCurrentImage(LEFT_IMAGE);
                break;
            case UP:
                this.setY(this.getY() - 20);
                this.setCurrentImage(UP_IMAGE);
                break;
            case DOWN:
                this.setY(this.getY() + 20);
                this.setCurrentImage(DOWN_IMAGE);
                break;
        }
    }

    private void inRange(double x, double y) {
        if (this.getX() > x) {
            this.setX((int)(x - this.getCurrentImage().getImage().getWidth()));
        } else if (this.getX() <=0) {
            this.setX(0);
        }

        if (this.getY() > y) {
            this.setY((int) (y - this.getCurrentImage().getImage().getHeight()));
        } else if (this.getY() <= 0) {
            this.setY(0);
        }
    }
}

package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class EnemyTank extends Tank {

    private static final Image UP_IMAGE = new Image("/tanks/green_tank/green_tank_up.png");
    private static final Image DOWN_IMAGE = new Image("/tanks/green_tank/green_tank_down.png");
    private static final Image LEFT_IMAGE = new Image("/tanks/green_tank/green_tank_left.png");
    private static final Image RIGHT_IMAGE = new Image("/tanks/green_tank/green_tank_right.png");
    private static final int UP_DIRECTION = 0;
    private static final int DOWN_DIRECTION = 1;
    private static final int LEFT_DIRECTION = 2;
    private static final int RIGHT_DIRECTION = 3;
    private int dir;


    public void setDirection(int direction) {
        this.direction = direction;
    }

    private int direction;
    private Random random;

    public EnemyTank(int x, int y) {
        super(x, y);
        this.random = new Random();
        super.setCurrentImage(DOWN_IMAGE);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(this.getCurrentImage().getImage(), this.getX(), this.getY());
        graphicsContext.setFill(Color.TRANSPARENT);
        this.move(this.direction);
    }

    private void move(int direction) {

        switch (direction) {
            case 3:
                this.setX(this.getX() + 1);
                this.setCurrentImage(RIGHT_IMAGE);
                break;
            case 2:
                this.setX(this.getX() - 1);
                this.setCurrentImage(LEFT_IMAGE);
                break;
            case 0:
                this.setY(this.getY() - 1);
                this.setCurrentImage(UP_IMAGE);
                break;
            case 1:
                this.setY(this.getY() + 1);
                this.setCurrentImage(DOWN_IMAGE);
                break;
        }

        if (this.getX() <= random.nextInt(600) / 4 && getY() <= random.nextInt(400) / 4) {
            this.setDirection(getDir());
        }
    }

    private int getDir() {
        int rnd = random.nextInt(4);
        return rnd;
    }

}

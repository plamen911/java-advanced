package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.core;

import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks.EnemyTank;
import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks.PlayerTank;
import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.models.tanks.Tank;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class GameEngine {

    private Canvas canvas;

    public GameEngine(Canvas canvas) {
        this.canvas = canvas;
    }

    public void run() {
        Tank pl = new PlayerTank(0,0);
        canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().drawImage(pl.getCurrentImage().getImage(),pl.getX(),pl.getY());


        Tank tn = new EnemyTank(300,300);
        Tank tn1 = new EnemyTank(200,200);
        Tank tn2 = new EnemyTank(100,300);
        Tank tn3 = new EnemyTank(90,400);

        new AnimationTimer(){
            @Override
            public void handle(long now) {
                pl.draw(canvas.getGraphicsContext2D());
                tn.draw(canvas.getGraphicsContext2D());
                tn1.draw(canvas.getGraphicsContext2D());
                tn2.draw(canvas.getGraphicsContext2D());
                tn3.draw(canvas.getGraphicsContext2D());
            }
        }.start();
    }
}

package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.controllers;

import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.core.GameEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PlayfieldController {

    @FXML
    private AnchorPane playfieldPane;
    @FXML
    private Button start;


    public void startGame(ActionEvent actionEvent) throws InterruptedException {
        this.start.setVisible(false);
        final Canvas canvas = new Canvas(this.playfieldPane.getWidth(),this.playfieldPane.getHeight());
        this.playfieldPane.getChildren().add(canvas);
        GameEngine engine = new GameEngine(canvas);
        engine.run();

    }
}

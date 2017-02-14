package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.controllers;

import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.utils.stageUtils.StageManager;
import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.utils.stageUtils.StageManagerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EntryController {

    @FXML
    private Button goButton;

    public void startGame(ActionEvent actionEvent) {
        Stage currentStage = (Stage)this.goButton.getScene().getWindow();
        StageManager manager = new StageManagerImpl();
        FXMLLoader loader = manager.loadSceneToStage(currentStage,"views/playfield.fxml",null);

    }
}

package org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp;

import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.utils.stageUtils.StageManager;
import org.lynxlake._11JavaAdvancedWorkshopGameDemo.gameApp.utils.stageUtils.StageManagerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageManager manager = new StageManagerImpl();
        manager.loadSceneToStage(primaryStage,"views/gameEntry.fxml",null);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

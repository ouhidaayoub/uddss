package dz.ouhidaayoub.uddss.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public final class UddssApplication extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("UDDSS starting...");

        Scene scene = new Scene(label, 800, 600);

        stage.setTitle("UDDSS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
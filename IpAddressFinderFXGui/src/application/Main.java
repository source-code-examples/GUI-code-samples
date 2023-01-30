package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

/*
 * The program finds the IP address of the URL entered by the user.
 * Using JavaFX, FXML, CSS.
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
			Scene scene = new Scene(root, 600, 200);
			//primaryStage.setTitle("IP Address Finder");
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setX(700.0);
			primaryStage.setY(400.0);
			primaryStage.setScene(scene);
			primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

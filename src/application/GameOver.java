package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameOver extends Application{

	@Override
	public void start(Stage gameover) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("GameOver1.fxml"));
		
		Scene scene = new Scene(root,600,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		gameover.setScene(scene);
		gameover.setResizable(false);
		gameover.show();
	}

}

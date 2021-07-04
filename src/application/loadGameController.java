package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loadGameController {
	
	@FXML
	
     ListView<String> GameList;
	public void back(ActionEvent event)throws Exception {
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	    
		window.setScene(scene);
		window.show();
		
	}
	
	public void Load(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
		//SavedGame1.SelectedGame(GameList);
	}
	
	

}

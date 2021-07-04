package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameOver2Controller{
	
	public void MainMenu(ActionEvent event)throws Exception {
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	    
		window.setScene(scene);
		window.show();
		
	}
	
	public void Restart(ActionEvent event)throws Exception {
		
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Game.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
		//window.initModality(Modality.APPLICATION_MODAL);
	    Game.setReference();
	    Game game=Game.getReference();
	    game.Start(newGame,scene);
	    
		window.setScene(scene);
		window.show();
		
		
	}
	
	public void Resume(ActionEvent event)throws Exception {
		//System.out.println("Anubhav");
		Game game=Game.getReference();

		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Game.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
		game.Resume(newGame,scene);
	  
		window.setScene(scene);
		window.show();
	}
	

}
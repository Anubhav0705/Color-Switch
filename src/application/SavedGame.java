package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SavedGame implements Serializable{
     // private ArrayList<String> savedGames;
     @FXML
      transient TextField GameName;
     @FXML
     static ListView GameList;
      transient private String nameSelected;
	 SavedGame(){
		 //GameList.getItems().add("name");
	 }
	 
	 public  void serialize(ActionEvent event) throws FileNotFoundException, IOException
	 {   String name=GameName.getText();
		 Game game=Game.getReference();
		 ObjectOutputStream out=null;
		 try {
			 out=new ObjectOutputStream(new FileOutputStream(name));
			 out.writeObject(game);
		 }
		 finally {
			 //savedGames.add(name);
			 GameList.getItems().add(name);
			 out.close();
		 }
	 }
	 
	 public  void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		 ObjectInputStream in =null;
		 try {
			 in=new ObjectInputStream(new FileInputStream(nameSelected));
			 Game game=(Game)in.readObject();
		 }
		 finally {
			 in.close();
		 }
	 }
	 
//	 public  void ListOfGame() {
//		 for(int i=0;i<savedGames.size();i++) {
//			 GameList.getItems().add(savedGames.get(i));
//		 }
//	 }
	 
	 public  void SelectedGame(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
		 nameSelected=(String)GameList.getSelectionModel().getSelectedItem();
		 if(nameSelected==null) {
			 
		 }
		 else
			 deserialize();
	 }
	 
//		@FXML
//		public void back(ActionEvent event)throws Exception {
//			AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Pause.fxml"));
//			Scene scene = new Scene(newGame,600,700);
//			Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//		    
//			window.setScene(scene);
//			window.show();
//			
//		}
		
}

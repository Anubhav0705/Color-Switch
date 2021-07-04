package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SavedGame1 implements Serializable {
	public static ArrayList<String> names;
	 @FXML
     transient TextField GameName;
    @FXML
    transient static ListView<String> GameList;
     transient static  private String nameSelected;
	 
     //ObservableList list=FXCollections.observableArrayList();
     public void SavedGame1() {
    	 names=new ArrayList<String>();
     }
	
	@FXML
	public void back(ActionEvent event)throws Exception {
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Pause.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	    
		window.setScene(scene);
		window.show();
		
	}
	
	 public  void serialize(ActionEvent event) throws FileNotFoundException, IOException
	 {   String name=GameName.getText();
	 System.out.println(name);
		 Game game=Game.getReference();
		 ObjectOutputStream out=null;
		 try {
			 out=new ObjectOutputStream(new FileOutputStream(name));
			 out.writeObject(game);
		 }
		 finally {
			 names.add(name);
			 //savedGames.add(name);
//			 list.add(name);
//			 GameList.getItems().addAll(list);
			 out.close();
		 }
	 }
	 
	 public static  void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		 ObjectInputStream in =null;
		 try {
			 in=new ObjectInputStream(new FileInputStream(nameSelected));
			 Game game=(Game)in.readObject();
		 }
		 finally {
			 in.close();
		 }
	 }
	 
	 public  static void SelectedGame(ListView gameList) throws FileNotFoundException, ClassNotFoundException, IOException {
		 GameList=gameList;
		 nameSelected=(String)GameList.getSelectionModel().getSelectedItem();
		 if(nameSelected==null) {
			 
		 }
		 else
			 deserialize();
	 }
	 
	 public static void Load() {
		 for(int i=0;i<names.size();i++) {
			 GameList.getItems().add(names.get(i));
		 }
	 }
	 
	 

}

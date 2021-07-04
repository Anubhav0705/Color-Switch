package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMain implements Initializable{
	private Game game;
	@FXML
	Arc arc1,arc2,arc3,arc4,arc5,arc6,arc7,arc8;
	@FXML
	Group group1,group2;
	
	
	@FXML
	public void NewGame(ActionEvent event)throws Exception {
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Game.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
		
	    Game.setReference();
	    game=Game.getReference();
	    game.Start(newGame,scene);
	  
		window.setScene(scene);
		window.show();
		
	}
	
	@FXML
	public void LoadGame(ActionEvent event)throws Exception {
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("loadGame.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	    
	    //DataBase.deserialize();
		window.setScene(scene);
		window.show();
		
	}
	
	@FXML
	public void ExitGame(ActionEvent event) throws Exception{
		//DataBase.serialize();
		System.exit(0);
		//System.out.println("Clicked");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//setRotate(group1,false,360,10);
		//setRotate(group2,false,-360,10);
		Timeline arc1Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc1.startAngleProperty(),arc1.getStartAngle(),Interpolator.LINEAR)),
				               new KeyFrame(Duration.seconds(10),new KeyValue(arc1.startAngleProperty(),arc1.getStartAngle()-360,Interpolator.LINEAR)));
		Timeline arc2Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc2.startAngleProperty(),arc2.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc2.startAngleProperty(),arc2.getStartAngle()-360,Interpolator.LINEAR)));
		Timeline arc3Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc3.startAngleProperty(),arc3.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc3.startAngleProperty(),arc3.getStartAngle()-360,Interpolator.LINEAR)));
		Timeline arc4Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc4.startAngleProperty(),arc4.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc4.startAngleProperty(),arc4.getStartAngle()-360,Interpolator.LINEAR)));
		Timeline arc5Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc5.startAngleProperty(),arc5.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc5.startAngleProperty(),arc5.getStartAngle()+360,Interpolator.LINEAR)));
		Timeline arc6Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc6.startAngleProperty(),arc6.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc6.startAngleProperty(),arc6.getStartAngle()+360,Interpolator.LINEAR)));
		Timeline arc7Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc7.startAngleProperty(),arc7.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc7.startAngleProperty(),arc7.getStartAngle()+360,Interpolator.LINEAR)));
		Timeline arc8Animation=new Timeline(new KeyFrame(Duration.ZERO,new KeyValue(arc8.startAngleProperty(),arc8.getStartAngle(),Interpolator.LINEAR)),
	               new KeyFrame(Duration.seconds(10),new KeyValue(arc8.startAngleProperty(),arc8.getStartAngle()+360,Interpolator.LINEAR)));
		arc1Animation.setCycleCount(Animation.INDEFINITE);
		arc2Animation.setCycleCount(Animation.INDEFINITE);
		arc3Animation.setCycleCount(Animation.INDEFINITE);
		arc4Animation.setCycleCount(Animation.INDEFINITE);
		arc5Animation.setCycleCount(Animation.INDEFINITE);
		arc6Animation.setCycleCount(Animation.INDEFINITE);
		arc7Animation.setCycleCount(Animation.INDEFINITE);
		arc8Animation.setCycleCount(Animation.INDEFINITE);
		arc1Animation.play();
		arc2Animation.play();
		arc3Animation.play();
		arc4Animation.play();
		arc5Animation.play();
		arc6Animation.play();
		arc7Animation.play();
		arc8Animation.play();
	}
	

	
	

}



package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Game extends AnimationTimer implements Serializable{
	private Ball ball;
	
	private ArrayList<Obstacle> obstacles;
	private int count,count2;
	private static int count1;
	
	transient private AnchorPane newGame;
	transient private Scene scene;
	transient private Text score;
    private double duration;
    private double x,y;
    @FXML
    transient private Label label;
    private static Game game=null;
	public Game() {
		ball=new Ball(300,650,0);
		x=ball.getCircle().getCenterX();
		y=ball.getCircle().getCenterY();
		
		obstacles=new ArrayList<Obstacle>();
		count=1;
		count1=1;
		duration=10;
		
		count2=0;
	}
	
	public void Resume(AnchorPane Game,Scene Gamescene) throws FileNotFoundException {
	     
	  
	    count1=1;
		ball.getCircle().setCenterX(x);
		ball.getCircle().setCenterY(y);
		ball.setCollision(false);
		this.newGame=Game;
		this.scene=Gamescene;

		
		for(int i=0;i<obstacles.size();i++) {
			obstacles.get(i).createUI(newGame);
			
		}

		newGame.getChildren().add(score);
		ball.createUI(newGame);
		handle();
		start();
		
	}
	public void Start(AnchorPane Game,Scene Gamescene)throws FileNotFoundException{
		this.newGame=Game;
		this.scene=Gamescene;

		CircleObstacle.c=0;
		obstacles.add(new CircleObstacle(300,120,1,120,duration));
		
		obstacles.get(0).draw();
		obstacles.get(0).update();
		obstacles.get(0).createUI(newGame);
		

		
		ball=new Ball(300,650,0);
		ball.draw();
		
		ball.setColor();
		ball.createUI(newGame);
		
		score=new Text(Integer.toString(ball.getStarCollected()));
		
		score.setFill(Color.WHITE);
		score.setX(40);
		score.setY(60);
		score.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,40));
		newGame.getChildren().add(score);
		
		handle();
		start();
		
	
	}
	
	public void handle() {
		
		
		Random rand=new Random();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				
				
					
		        
				if(event.getCode()==KeyCode.UP )
				{
				
				ball.update();
				
				
				ball.timeline.play();
				
				if(ball.getY()<=450) {
					
					for(int i=0;i<obstacles.size();i++) {
						obstacles.get(i).down();
						
					}
					//System.out.println("Size="+obstacles.size());
				}
				
				if(obstacles.get(obstacles.size()-1).getY()>=200.0 && count==1) {
					int random=rand.nextInt(5);
					if(random==0)
						obstacles.add(new CircleObstacle(300,-120,1,120,duration));
					if(random==1)
						obstacles.add(new  SquareObstacle(200,-240,1,200,duration));
					if(random==2)
					    obstacles.add(new CrossObstacle(110,-120,1,100,duration));
                    if(random==3)
                    	obstacles.add(new VerticalObstacle(0,-120,1,120,duration));
                    if(random==4)
                    	obstacles.add(new HorizontalObstacle(0,-120,1,150,duration));

					obstacles.get(obstacles.size()-1).draw();
					obstacles.get(obstacles.size()-1).update();
					try {
						obstacles.get(obstacles.size()-1).createUI(newGame);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count=2;
				}
				if(obstacles.get(obstacles.size()-1).getY()>=400.0) {
					
      				duration=duration-0.1;
					if(duration<=6) {
						duration=8;
					}
					
					int random=rand.nextInt(5);
					if(random==0)
						obstacles.add(new CircleObstacle(300,-120,1,120,duration));
					if(random==1)
						obstacles.add(new  SquareObstacle(200,-240,1,200,duration));
					if(random==2)
					    obstacles.add(new CrossObstacle(110,-120,1,100,duration));
                    if(random==3)
                    	obstacles.add(new VerticalObstacle(0,-120,1,120,duration));
                    if(random==4)
                    	obstacles.add(new HorizontalObstacle(0,-120,1,150,duration));

					obstacles.get(obstacles.size()-1).draw();
					obstacles.get(obstacles.size()-1).update();
					try {
						obstacles.get(obstacles.size()-1).createUI(newGame);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				for(int i=0;i<obstacles.size();i++) {
					if(obstacles.get(i).getY()>1500)
						obstacles.remove(i);
				}

                 
				
				}
				

				
			
			}
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				ball.gravity();
				ball.timeline1.play();
				   
			}
			
		});
		
		
	}
	
	@FXML
	public void Pause(MouseEvent event) throws IOException {
		
		
		x=ball.getCircle().getCenterX();
		y=ball.getCircle().getCenterY();
		
		ball.timeline.pause();
		ball.timeline1.pause();
		count1=5;
		AnchorPane newGame = (AnchorPane)FXMLLoader.load(getClass().getResource("Pause.fxml"));
		Scene scene = new Scene(newGame,600,700);
		Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
		
	
		window.setScene(scene);
		window.show();

		}

	@Override
	public void handle(long arg0) {
		
		if (count1==5) {
		       
		       ball.timeline1.pause();
		       x=ball.getCircle().getCenterX();
				y=ball.getCircle().getCenterY();
				
		       stop();
				}
		
		for(int i=0;i<obstacles.size();i++) {
			if(obstacles.get(i).ColorSwitchCollision==false) 
			     obstacles.get(i).isCollisionColorSwitch(ball);
			obstacles.get(i).isCollisionObstacle(ball);
			//System.out.print("Obstacle "+i+" ");
			obstacles.get(i).getStar().print();
			if(obstacles.get(i).StarCollision==false) 
			       obstacles.get(i).collision(ball);
		}
		
		newGame.getChildren().remove(score);
        score=new Text(Integer.toString(ball.getStarCollected()));
		
		score.setFill(Color.WHITE);
		score.setX(40);
		score.setY(60);
		score.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,40));
		newGame.getChildren().add(score);
		
		
		
		if((ball.isCollision()==true || ball.getCircle().getCenterY()==715)&& ball.getStarCollected()>=2 && count2==0) {
			ball.setCollision(false);
			count2=2;
			x=ball.getCircle().getCenterX();
			y=ball.getCircle().getCenterY();
			
			Stage gameover=new Stage();
			AnchorPane root=new AnchorPane();
			try {
				root = (AnchorPane)FXMLLoader.load(getClass().getResource("GameOver2.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Text score1=new Text(Integer.toString(ball.getStarCollected()));
			
			score1.setFill(Color.WHITE);
			score1.setX(280);
			score1.setY(280);
			score1.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,60));
			root.getChildren().add(score1);
			Scene scene = new Scene(root,600,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameover.setScene(scene);
			gameover.setResizable(false);
			gameover.initModality(Modality.APPLICATION_MODAL);
			gameover.initStyle(StageStyle.UNDECORATED);
			gameover.show();
			
		    
			stop();
		}
		
		else if(ball.isCollision()==true || ball.getCircle().getCenterY()==715) {
			
			Stage gameover=new Stage();
			AnchorPane root=new AnchorPane();
			try {
				root = (AnchorPane)FXMLLoader.load(getClass().getResource("GameOver1.fxml"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			Text score1=new Text(Integer.toString(ball.getStarCollected()));
			
			score1.setFill(Color.WHITE);
			score1.setX(280);
			score1.setY(280);
			score1.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,60));
			root.getChildren().add(score1);
			Scene scene = new Scene(root,600,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameover.setScene(scene);
			gameover.setResizable(false);
			gameover.initModality(Modality.APPLICATION_MODAL);
			gameover.initStyle(StageStyle.UNDECORATED);
			gameover.show();
			
		    
			stop();

		}

	}
	
	public static Game getReference() {
		
		
		return game;
	}
	
	public static void setReference() {
		game=new Game();
	}
	

	

}
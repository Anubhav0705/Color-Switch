package application;

import java.io.Serializable;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends GameElement {
	private int starCollected;
	private double radius;
	private boolean collision;
	transient Circle circle;
	private transient Color color;
	
	transient Timeline timeline,timeline1;
	public Ball(double x,double y,int score){
		super(x, y);
		radius=12;
		circle=new Circle();
		starCollected=score;
		timeline=new Timeline();
		timeline1=new Timeline();
	}
	
	public void draw() {
		
		circle.setCenterX(positionX);
		circle.setCenterY(positionY);
		circle.setRadius(radius);
	}
	
	public void update() {
		timeline=new Timeline();
		timeline.setCycleCount(1);
		KeyValue kv=new KeyValue(circle.centerYProperty(),circle.getCenterY()-200);
		positionY=circle.getCenterY();
		positionX=circle.getCenterX();
		KeyFrame kf=new KeyFrame(Duration.millis(500),kv);
		timeline.getKeyFrames().add(kf);
		//timeline.play();
		

	}
	public void gravity() {
		
		timeline1=new Timeline();
		timeline1.setCycleCount(1);
		KeyValue kv=new KeyValue(circle.centerYProperty(),715);
		positionY=circle.getCenterY();
		//System.out.println(positionY);
		positionX=circle.getCenterX();
//		System.out.println(positionY);
//		System.out.println(positionX);
		KeyFrame kf=new KeyFrame(Duration.millis(1200-circle.getCenterY()),kv);
		timeline1.getKeyFrames().add(kf);
		//timeline1.play();
	}
	public int getStarCollected() {
	
		return starCollected;
	}
	
	public void setStarCollected() {
	    starCollected++;
	}
	
	public void setColor() {
		Random rand=new Random();
		int colorID=rand.nextInt(4);
		if(colorID==0) {
			if(circle.getFill().equals(Color.RED)) {
				setColor();
			}
			else
			    circle.setFill(Color.RED);
		}
		if(colorID==1) {
			if(circle.getFill().equals(Color.BLUE)) {
				setColor();
			}
			else
			    circle.setFill(Color.BLUE);
		}
		if(colorID==2) {
			if(circle.getFill().equals(Color.GREEN)) {
				setColor();
			}
			else
			    circle.setFill(Color.GREEN);
		}
		if(colorID==3) {
			if(circle.getFill().equals(Color.YELLOW)) {
				setColor();
			}
			else
			    circle.setFill(Color.YELLOW);
		}
	}
	
	public Paint getColor() {
		return circle.getFill();
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public boolean isCollision() {
		return collision;
	}
	
	public void setCollision(Boolean collide) {
		collision=collide;
	}
	
	public void createUI(AnchorPane parent)
	{
		Group group=new Group(circle);
		parent.getChildren().add(group);
		
	}
	
	
}

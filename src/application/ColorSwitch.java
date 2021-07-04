package application;

import java.io.Serializable;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class ColorSwitch extends GameElement {
	transient private Arc arc1,arc2,arc3,arc4;
	transient Group group;
	public ColorSwitch(double x,double y) {
		super(x,y);
		
	}
	
	public void draw() {
		arc1=new Arc(positionX,positionY,15,15,0,90);
		arc2=new Arc(positionX,positionY,15,15,90,90);
		arc3=new Arc(positionX,positionY,15,15,180,90);
		arc4=new Arc(positionX,positionY,15,15,270,90);
		
		arc1.setType(ArcType.ROUND);
		arc2.setType(ArcType.ROUND);
		arc3.setType(ArcType.ROUND);
		arc4.setType(ArcType.ROUND);
		
		arc1.setFill(Color.YELLOW);
		arc2.setFill(Color.RED);
		arc3.setFill(Color.BLUE);
		arc4.setFill(Color.GREEN);
		group=new Group(arc1,arc2,arc3,arc4);
	}
	
	public void down() {
		Timeline timeline5=new Timeline();
		timeline5.setCycleCount(1);
		KeyValue kv5=new KeyValue(group.layoutYProperty(),group.getLayoutY()+20);
		
		KeyFrame kf5=new KeyFrame(Duration.millis(100),kv5);
		timeline5.getKeyFrames().add(kf5);
		timeline5.play();
		
		positionY=group.getLayoutY();
		//System.out.println(getY());
	}
	
    public boolean isCollisionColorSwitch(Ball ball) {
		Shape collision1=Shape.intersect(ball.getCircle(), arc1);
		Shape collision2=Shape.intersect(ball.getCircle(), arc2);
		Shape collision3=Shape.intersect(ball.getCircle(), arc3);
		Shape collision4=Shape.intersect(ball.getCircle(), arc4);
		if(collision1.getBoundsInLocal().getWidth()!=-1 || collision2.getBoundsInLocal().getWidth()!=-1 || collision3.getBoundsInLocal().getWidth()!=-1  || collision4.getBoundsInLocal().getWidth()!=-1) {
			ball.setColor();
			arc1.setCenterX(1000);
			arc1.setCenterY(1000);
			arc2.setCenterX(1000);
			arc2.setCenterY(1000);
			arc3.setCenterX(1000);
			arc3.setCenterY(1000);
			arc4.setCenterX(1000);
			arc4.setCenterY(1000);
			
			return true;
		}
		else
		    return false;
	}
	
	public void createUI(AnchorPane parent)
	{
		
		parent.getChildren().add(group);
		
	}

}

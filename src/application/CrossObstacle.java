package application;

import java.io.FileNotFoundException;

import application.Obstacle;
import application.Star;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CrossObstacle extends Obstacle{
	   
	transient Rectangle rect1,rect2,rect3,rect4;
	transient Group group;
	transient Timeline timeline,timeline5;
//    ColorSwitch ch;
    public CrossObstacle(double x,double y,int id,double size,double duration) {
		super(x,y,id,size,duration);
		
	}                                                                             
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Rotate rotate=new Rotate();
		rotate.setPivotX(positionX+size+10);
		rotate.setPivotY(positionY+10);
		rotate.setAngle(0);
		group.getTransforms().add(rotate);

		Timeline timeline=new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(duration),new KeyValue(rotate.angleProperty(),360)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	@Override
	public void draw() {
		
		rect1=new Rectangle(positionX,positionY,size,20);
		rect2=new Rectangle(positionX+100,positionY+20,20,size);
		rect3=new Rectangle(positionX+120,positionY,size,20);
		rect4=new Rectangle(positionX+100,positionY-100,20,size);
		group=new Group(rect1,rect2,rect3,rect4);
		rect1.setFill(Color.YELLOW);
		rect2.setFill(Color.RED);
		rect3.setFill(Color.BLUE);
		rect4.setFill(Color.GREEN);
		
		
	}

	@Override
	public void createUI(AnchorPane parent) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if(StarCollision==false) {
		    star=new Star(positionX+130,group.getLayoutY()-150);
		    star.draw();
		    star.createUI(parent);}
		parent.getChildren().add(group);
		if(ColorSwitchCollision==false) {
		    ch=new ColorSwitch(positionX+180,group.getLayoutY()-300);
	        ch.draw();
	        ch.createUI(parent);}
		
		
	}
	@Override
    public void down() {

		
		timeline5=new Timeline();
		timeline5.setCycleCount(1);
		KeyValue kv5=new KeyValue(group.layoutYProperty(),group.getLayoutY()+20);
		
		KeyFrame kf5=new KeyFrame(Duration.millis(100),kv5);
		timeline5.getKeyFrames().add(kf5);
		timeline5.play();
		star.down();
		positionY=group.getLayoutY();
		//System.out.println(getY());
		ch.down();
	}
	

	@Override
	public void isCollisionObstacle(Ball ball) {
		// TODO Auto-generated method stub
		Shape collision1=Shape.intersect(ball.getCircle(), rect1);
		Shape collision2=Shape.intersect(ball.getCircle(), rect2);
		Shape collision3=Shape.intersect(ball.getCircle(), rect3);
		Shape collision4=Shape.intersect(ball.getCircle(), rect4);
		if(collision1.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.YELLOW))){

				ball.setCollision(true);
				group.setLayoutX(1000);
			}
			
		}
		if(collision2.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.RED))){

				ball.setCollision(true);
				group.setLayoutX(1000);
			}
			
		}
		if(collision3.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.BLUE))){

				ball.setCollision(true);
				group.setLayoutX(1000);
			}
			
		}
		if(collision4.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.GREEN))){

				ball.setCollision(true);
				group.setLayoutX(1000);
			}
			
		}
		
	}
	@Override
	public Star getStar() {
		// TODO Auto-generated method stub
		return star;
	}
	

}

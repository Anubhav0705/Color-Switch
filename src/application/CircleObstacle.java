package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleObstacle extends Obstacle{
	
	
	transient Shape a1,a2,a3,a4;
	transient private Circle circle;
	private double startAngle;
	
	transient private Timeline timeline,timeline5;
	
	transient Group group;
	static int c; 
	public CircleObstacle(double x,double y,int id,double size,double duration) {
		super(x,y,id,size,duration);
		startAngle=0;
		c++;
		System.out.println(c);
	}
	
	@Override
	public void draw() {
		Arc arc1,arc2,arc3,arc4;
		arc1=new Arc(positionX,positionY,size,size,startAngle,90);
		arc2=new Arc(positionX,positionY,size,size,startAngle+90,90);
		arc3=new Arc(positionX,positionY,size,size,startAngle+180,90);
		arc4=new Arc(positionX,positionY,size,size,startAngle+270,90);
		circle=new Circle(positionX,positionY,size-20);

		arc1.setType(ArcType.ROUND);
		arc2.setType(ArcType.ROUND);
		arc3.setType(ArcType.ROUND);
		arc4.setType(ArcType.ROUND);
		a1=Shape.subtract(arc1, circle);
		a2=Shape.subtract(arc2, circle);
		a3=Shape.subtract(arc3, circle);
		a4=Shape.subtract(arc4, circle);
		a1.setFill(Color.YELLOW);
		a2.setFill(Color.RED);
		a3.setFill(Color.BLUE);
		a4.setFill(Color.GREEN);
		group=new Group(a1,a2,a3,a4);
		
	}
	@Override
	public void update() {
		
		Rotate rotate=new Rotate();
		rotate.setPivotX(positionX);
		rotate.setPivotY(positionY);
		rotate.setAngle(0);
		group.getTransforms().add(rotate);

		timeline=new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(duration),new KeyValue(rotate.angleProperty(),360)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
	}
	
	public void down() {

		
		timeline5=new Timeline();
		timeline5.setCycleCount(1);
		KeyValue kv5=new KeyValue(group.layoutYProperty(),group.getLayoutY()+20);
		
		KeyFrame kf5=new KeyFrame(Duration.millis(100),kv5);
		timeline5.getKeyFrames().add(kf5);
		timeline5.play();
		positionY=group.getLayoutY();
		star.down();
		
		
		
		ch.down();
	}
	@Override
	public void createUI(AnchorPane parent) throws FileNotFoundException
	{
		
		parent.getChildren().add(group);
		
		if(StarCollision==false) {
			if(c==1)
		     star=new Star(positionX-50,group.getLayoutY()+70);
			else
				star=new Star(positionX-50,group.getLayoutY()-180);
		     star.draw();
		     star.createUI(parent);
		}
		if( ColorSwitchCollision==false) {
			if(c==1)
		       ch=new ColorSwitch(positionX,group.getLayoutY()-100);
			else
				ch=new ColorSwitch(positionX,group.getLayoutY()-320);
	         ch.draw();
	         ch.createUI(parent);}
	}
    


	@Override
	public void isCollisionObstacle(Ball ball) {
		
		Shape collision1=Shape.intersect(ball.getCircle(), a1);
		Shape collision2=Shape.intersect(ball.getCircle(), a2);
		Shape collision3=Shape.intersect(ball.getCircle(), a3);
		Shape collision4=Shape.intersect(ball.getCircle(), a4);
		if(collision1.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.YELLOW))){
				
			
				ball.setCollision(true);
				group.setLayoutX(1000);
			}
			
		}
		if(collision2.getBoundsInLocal().getWidth()!=-1 ) {
			if(!(ball.getColor().equals(Color.RED))){
//				System.out.println("ANUBJDHJHJJHDJHKHHSGKD");
				//isCollisionBall=true;
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
		return star;
		
	}


	

}

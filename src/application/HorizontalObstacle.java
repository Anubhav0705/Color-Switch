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
import javafx.util.Duration;

public class HorizontalObstacle extends Obstacle{
	   
	transient Rectangle rect1,rect2,rect3,rect4,rect5,rect6,rect7,rect8;
	transient Group group,group2;
	transient Timeline timeline,timeline2,timeline5,timeline6;
    //ColorSwitch ch;
    public HorizontalObstacle(double x,double y,int id,double size,double duration) {
		super(x,y,id,size,duration);
		
	}                                                                             
	@Override
	public void update() {
		timeline=new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		KeyValue kv=new KeyValue(group.layoutXProperty(),group.getLayoutX()+600);
		
		KeyFrame kf=new KeyFrame(Duration.seconds(duration),kv);
		timeline.getKeyFrames().add(kf);
		timeline.setAutoReverse(true);
		timeline.play();
		
		
		timeline2=new Timeline();
		timeline2.setCycleCount(Animation.INDEFINITE);
		KeyValue kv2=new KeyValue(group2.layoutXProperty(),group2.getLayoutX()+600);
		
		KeyFrame kf2=new KeyFrame(Duration.seconds(duration),kv2);
		timeline2.getKeyFrames().add(kf2);
		timeline2.setAutoReverse(true);
		timeline2.play();
		
	}

	@Override
	public void draw() {
		rect1=new Rectangle(positionX-600,positionY,size,20);
		rect2=new Rectangle(positionX-450,positionY,size,20);
		rect3=new Rectangle(positionX-300,positionY,size,20);
		rect4=new Rectangle(positionX-150,positionY,size,20);
		rect5=new Rectangle(positionX,positionY,size,20);
		rect6=new Rectangle(positionX+150,positionY,size,20);
		rect7=new Rectangle(positionX+300,positionY,size,20);
		rect8=new Rectangle(positionX+450,positionY,size,20);
		rect1.setFill(Color.YELLOW);
		rect2.setFill(Color.RED);
		rect3.setFill(Color.BLUE);
		rect4.setFill(Color.GREEN);
		rect5.setFill(Color.YELLOW);
		rect6.setFill(Color.RED);
		rect7.setFill(Color.BLUE);
		rect8.setFill(Color.GREEN);
		group=new Group(rect1,rect2,rect3,rect4);
		group2=new Group(rect5,rect6,rect7,rect8);
	}

	@Override
	public void createUI(AnchorPane parent) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if( StarCollision==false) {
            star=new Star(positionX+250,group.getLayoutY()-120);
		
		    star.draw();
		    star.createUI(parent);
		}
		parent.getChildren().add(group);
		parent.getChildren().add(group2);
		if(ColorSwitchCollision==false) {
		    ch=new ColorSwitch(positionX+300,group.getLayoutY()-220);
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
		
		timeline6=new Timeline();
		timeline6.setCycleCount(1);
		KeyValue kv2=new KeyValue(group2.layoutYProperty(),group2.getLayoutY()+20);
		
		KeyFrame kf2=new KeyFrame(Duration.millis(100),kv2);
		timeline6.getKeyFrames().add(kf2);
		timeline6.play();
		star.down();
		positionY=group.getLayoutY();
		//System.out.println(getY());
		ch.down();
	}
//	public void isCollisionColorSwitch(Ball ball) {
//		ColorSwitchCollision=ch.isCollisionColorSwitch(ball);
//	}
	@Override
	public void isCollisionObstacle(Ball ball) {
		// TODO Auto-generated method stub
		Shape collision1=Shape.intersect(ball.getCircle(), rect1);
		Shape collision2=Shape.intersect(ball.getCircle(), rect2);
		Shape collision3=Shape.intersect(ball.getCircle(), rect3);
		Shape collision4=Shape.intersect(ball.getCircle(), rect4);
		Shape collision5=Shape.intersect(ball.getCircle(), rect5);
		Shape collision6=Shape.intersect(ball.getCircle(), rect6);
		Shape collision7=Shape.intersect(ball.getCircle(), rect7);
		Shape collision8=Shape.intersect(ball.getCircle(), rect8);
		if(collision1.getBoundsInLocal().getWidth()!=-1 || collision5.getBoundsInLocal().getWidth()!=-1) {
			if(!(ball.getColor().equals(Color.YELLOW)  ) ){

				ball.setCollision(true);
				group.setLayoutY(3000);
				group2.setLayoutY(3000);
			}
			
		}
		if(collision2.getBoundsInLocal().getWidth()!=-1 || collision6.getBoundsInLocal().getWidth()!=-1) {
			if(!(ball.getColor().equals(Color.RED))){
//				System.out.println("ANUBJDHJHJJHDJHKHHSGKD");
				ball.setCollision(true);
				group.setLayoutY(13000);
				group2.setLayoutY(3000);
			}
			
		}
		if(collision3.getBoundsInLocal().getWidth()!=-1 || collision7.getBoundsInLocal().getWidth()!=-1) {
			if(!(ball.getColor().equals(Color.BLUE))){
//				System.out.println("ANUBJDHJHJJHDJHKHHSGKD");
				ball.setCollision(true);
				group.setLayoutY(3000);
				group2.setLayoutY(3000);
			}
			
		}
		if(collision4.getBoundsInLocal().getWidth()!=-1 || collision8.getBoundsInLocal().getWidth()!=-1) {
			if(!(ball.getColor().equals(Color.GREEN))){
//				System.out.println("ANUBJDHJHJJHDJHKHHSGKD");
				ball.setCollision(true);
				group.setLayoutY(3000);
				group2.setLayoutY(3000);
			}
			
		}
		
	}
	@Override
	public Star getStar() {
		// TODO Auto-generated method stub
		return star;
	}
	
	
}

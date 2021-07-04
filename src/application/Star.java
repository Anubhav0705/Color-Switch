package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Star extends GameElement{
	
	transient private Image starImage;
	transient private ImageView imageView;
	transient private Circle circle;
	public Star(double x,double y) {
		super(x,y);
	}
	
	public void draw() throws FileNotFoundException {
		starImage=new Image(new FileInputStream("@..\\..\\assets\\star.png"));
		imageView=new ImageView(starImage);
		circle=new Circle(positionX+50,positionY+55,20);
		circle.setFill(Color.RED);
		imageView.setX(positionX);
		imageView.setY(positionY);
		imageView.setFitHeight(100);
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
		
	}
	
	public void down() {
		Timeline timeline5=new Timeline();
		timeline5.setCycleCount(1);
		KeyValue kv5=new KeyValue(imageView.layoutYProperty(),imageView.getLayoutY()+20);
		
		KeyFrame kf5=new KeyFrame(Duration.millis(100),kv5);
		timeline5.getKeyFrames().add(kf5);
		timeline5.play();
		
		Timeline timeline2=new Timeline();
		timeline5.setCycleCount(1);
		KeyValue kv2=new KeyValue(circle.layoutYProperty(),circle.getLayoutY()+20);
		
		KeyFrame kf2=new KeyFrame(Duration.millis(100),kv2);
		timeline2.getKeyFrames().add(kf2); 
		timeline2.play();
	}
	
	public void createUI(AnchorPane parent)
	{
		Group group=new Group(circle,imageView);
		parent.getChildren().add(group);
	}
	
	public void print() {
		//System.out.println(imageView.getY());
		
	} 
	
	public boolean collision(Ball ball) {
		Shape collision1=Shape.intersect(ball.getCircle(), circle);
		
		if(collision1.getBoundsInLocal().getWidth()!=-1 ) {
			circle.setCenterX(1000);
			imageView.setX(1000);
			ball.setStarCollected();
			
			return true;
		}
		else
		return false;
	}
	

}

package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ExplosionBall {
       private Circle circle1;
       private Circle circle2;
       private Circle circle3;
       private Circle circle4;
       private Circle circle5;
//       private Circle circle6;
//       private Circle circle7;
//       private Circle circle8;
//       private Circle circle9;
//       private Circle circle10;
       
       public ExplosionBall(double x,double y) {
    	   circle1=new Circle(x,y,10);
    	   circle2=new Circle(x,y,10);
    	   circle3=new Circle(x,y,10);
    	   circle4=new Circle(x,y,10);
    	   circle5=new Circle(x,y,10);
//    	   circle6=new Circle(x,y,10);
//    	   circle7=new Circle(x,y,10);
//    	   circle8=new Circle(x,y,10);
//    	   circle9=new Circle(x,y,10);
//    	   circle10=new Circle(x,y,10);
    	   circle1.setFill(Color.YELLOW);
    	   circle2.setFill(Color.RED);
    	   circle3.setFill(Color.GREEN);
    	   circle4.setFill(Color.BLUE);
    	   circle5.setFill(Color.RED);
//    	   circle1.setFill(Color.YELLOW);
//    	   circle1.setFill(Color.GREEN);
//    	   circle1.setFill(Color.BLUE);
//    	   circle1.setFill(Color.YELLOW);
    	   //circle10.setFill(Color.RED);
   	
       }
       
     
   		
    	  
       
       public void movement() {
    	Timeline timeline1=new Timeline();
   		timeline1.setCycleCount(1);
   		KeyValue kv1=new KeyValue(circle1.layoutYProperty(),circle1.getLayoutY()+100);
   		KeyFrame kf1=new KeyFrame(Duration.millis(100),kv1);
   		KeyValue kv11=new KeyValue(circle1.layoutXProperty(),650);
   		KeyFrame kf11=new KeyFrame(Duration.millis(100),kv11);
   		timeline1.getKeyFrames().add(kf1);
   		timeline1.getKeyFrames().add(kf11);
   		timeline1.play();
   		
       }
       
       public void createUI(AnchorPane parent)
   	{
   		
   		parent.getChildren().add(circle1);
   		
   	}
}

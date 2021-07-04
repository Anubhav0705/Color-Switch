package application;

import java.io.FileNotFoundException;
import java.io.Serializable;

import javafx.scene.layout.AnchorPane;

public abstract class Obstacle extends GameElement {
	
	protected int id;
	protected double size;
	protected double duration;
	protected Star star;
	protected boolean StarCollision;
	protected boolean ColorSwitchCollision;
	protected boolean isCollisionBall;
	protected ColorSwitch ch;
	public Obstacle(double x,double y,int id,double size,double duration) {
		super(x,y);
		this.size=size;
		this.duration=duration;
		this.id=id;
		StarCollision=false;
		ColorSwitchCollision=false;
		isCollisionBall=false;
	}
	public abstract Star getStar();
	public abstract void update();
	public abstract void down();
	public abstract void draw();
	
	public abstract void isCollisionObstacle(Ball ball);
	public abstract void createUI(AnchorPane parent)throws FileNotFoundException;
//	public abstract void PauseObstacle();
//	public abstract void PlayObstacle();
	
	
	public int getId() {
		return id;
	}
	
	public int getSpeed() {
		return id;
	}
	
	public void setSpeed() {
		
	}
	
	public void collision(Ball ball) {
		StarCollision=star.collision(ball);
		
	}
	
	public void isCollisionColorSwitch(Ball ball) {
		ColorSwitchCollision=ch.isCollisionColorSwitch(ball);
//		if(ColorSwitchCollision==true) {
//			//System. exit(0);
//		}
		//System.out.println("ColorSwitch"+ColorSwitchCollision);
	}
}

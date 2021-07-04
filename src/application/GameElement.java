package application;

import java.io.Serializable;

public class GameElement implements Serializable{
	protected double positionX;
	protected double positionY;
	
	public GameElement() {}
	
	public GameElement(double x,double y) {
		this.positionX=x;
		this.positionY=y;
	}
	
	public double getX() {
		return positionX;
	}
	
	public double getY() {
		return positionY;
	}
	public void setX(double x) {
		positionX=x;
	}
	public void setY(double y) {
		positionY=y;
	}
}

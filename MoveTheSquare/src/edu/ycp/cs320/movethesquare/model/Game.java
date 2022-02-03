package edu.ycp.cs320.movethesquare.model;

public class Game {
	public static final double MOVE_DIST = 2.0; // x/y distance square moves each tick 
	private double width, height;
	private Circle circle;
	private double circleDx;
	private double circleDy;
	
	public Game() {
		
	}
	
	public void setSquare(Circle square) {
		this.circle = square;
	}
	
	public Circle getSquare() {
		return circle;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setCircleDx(double squareDx) {
		this.circleDx = squareDx;
	}
	
	public double getSquareDx() {
		return circleDx;
	}
	
	public void setCircleDy(double squareDy) {
		this.circleDy = squareDy;
	}
	
	public double getSquareDy() {
		return circleDy;
	}
}

package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Circle;

public class GameController {
	public void computeSquareMoveDirection(Game game, Circle cirlce, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (cirlce.getX() + cirlce.getWidth()/2);
			double dy = mouseY - (cirlce.getY() + cirlce.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setCircleDx(moveX);
			game.setCircleDy(moveY);
		}
	}
	//test
	//test 2

	public void moveSquare(Game model, Circle circle) {
		// Set square to move 1.5x faster
		if(validMove(model, circle) ) {
		circle.setX(circle.getX() + model.getCircleDx()*1.5);
		circle.setY(circle.getY() + model.getCircleDy()*1.5);
		}
	}
	public boolean validMove(Game model, Circle circle) {
		if(circle.getX() >= model.getWidth()-circle.getWidth() || circle.getY() >= model.getHeight()-circle.getHeight() || circle.getX() <= 0 || circle.getY() <= 0) {
			return false;
		}
		return true;
	}
}

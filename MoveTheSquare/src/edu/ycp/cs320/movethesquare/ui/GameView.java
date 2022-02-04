package edu.ycp.cs320.movethesquare.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.ycp.cs320.movethesquare.controllers.GameController;
import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Circle;

public class GameView extends JPanel {
	private static final Color Violet = new Color(112, 25, 112);
	
	private Game model;
	private GameController controller;
	private Timer timer;
	
	public GameView(Game model) {
		this.model = model;
		setPreferredSize(new Dimension((int) model.getWidth(), (int)model.getHeight()));
		setBackground(Violet);

		// djh2-KEC119-21: changed from 30 to 45
		// djh2-YCPlaptop: change from 45 to 100
		this.timer = new Timer(2, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerTick();
			}
		});
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void startAnimation() {
		timer.start();
	}

	protected void handleTimerTick() {
		if (controller == null) {
			return;
		}
		Circle circle = model.getCircle();
		Point mouseLoc = getMousePosition();
		if (mouseLoc != null) {
			controller.computeSquareMoveDirection(model, circle, mouseLoc.getX(), mouseLoc.getY());
		}
		controller.moveSquare(model, circle);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		
		// djh2-KEC110-21: changed from GREEN to RED
		// djh2-YCPlaptop: change from RED to YELLOW
		g.setColor(Color.GREEN);

		Circle circle = model.getCircle();
		
		g.fillOval((int) circle.getX(), (int) circle.getY(), (int) circle.getWidth(), (int) circle.getHeight());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game model = new Game();
				model.setWidth(640.0);
				model.setHeight(480.0);
				
				Circle circle = new Circle();
				circle.setX(300.0);
				circle.setY(220.0);
				circle.setWidth(60.0);
				circle.setHeight(60.0);
				model.setCircle(circle);
				
				GameController controller = new GameController();
				
				GameView view = new GameView(model);
				view.setController(controller);
				
				JFrame frame = new JFrame("Move the Square!");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(view);
				frame.pack();
				frame.setVisible(true);
				
				view.startAnimation();
			}
		});
	}
}

/*
 * Pong Re-Creation
 * @author Glen Joy
 * AP Computer Science Principles 
 * Performance Task
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.*;

public class Pong extends Applet implements Runnable, KeyListener{

	protected static final int WIDTH = 700;  //variable declaration for width and height for applet
	protected static final int HEIGHT = 500;

	
	Thread thread;
	Puck puck;
	
	
	public static Racket Player1;
	public static AIRacket Player2;
	
	Graphics gfx;
	Image img;
	
	public void init () {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		Player1 = new Racket (true); //left player
		puck = new Puck();
		Player2 = new AIRacket (false, puck); //right player
		img = createImage(WIDTH,HEIGHT);
		gfx = img.getGraphics();
	
		thread = new Thread (this);
		thread.start();
	}
	
	public void paint (Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.setColor(Color.red);
		gfx.drawString("Pong Recreation", WIDTH/2, HEIGHT-10);
		if (puck.getX() < -10 || puck.getX() > 710) {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", WIDTH/2, HEIGHT/2);
		} else {
			Player1.draw(gfx);
			Player2.draw(gfx);
			puck.draw(gfx);
			
		}
		
		g.drawImage(img,0,0,this);
	}
	
	
	public void update (Graphics g) {
		paint(g);
	}
	
	public void run() {
		while (true) {
			
			Player1.move();
			Player2.move();
			puck.move();
			puck.checkCollision(Player1, Player2);
			
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
	/*public static void updateAll () { //updates position for both
		//Player1.update();
		//Player2.update();
		puck.update();
	}*/
	

	

	
	/*@SuppressWarnings("deprecation")
	public static void draw (Graphics g) { //displays racket and puck
		 

		Player1.draw(g);
		Player2.draw(g);
		puck.show(g);
		
		
		
	}*/
	


	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			Player1.setUpMove(true);
			Player1.setDownMove(false);
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			
			Player1.setDownMove(true);
			Player1.setUpMove(false);
		} else {
			
			//Player1.setUpMove(false);
			//Player1.setDownMove(false);
		}
		
	}


	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			Player1.setUpMove(true);
			Player1.setDownMove(false);
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			Player1.setDownMove(true);
			Player1.setUpMove(false);
		} else {
			
			//Player1.setUpMove(false);
			//Player1.setDownMove(false);
		}
	}


	public void keyTyped(KeyEvent e) {

		
	}






}

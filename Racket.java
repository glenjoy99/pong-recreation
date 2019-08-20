import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.*;

public class Racket extends Pong {
		
		float x = WIDTH;
		float y = HEIGHT/2;
		float yspeed = 0;
		final double GRAVITY = 0.94;
		boolean upMove;
		boolean downMove;
		
		
		public Racket (boolean s) { //Constructor
					
			
			
			if (s == true) { // if true sets left player position
				x = 0 + 25/2;
				y = HEIGHT/2;
			} else if (s == false) { // if false sets right player position
				x = WIDTH - (25/2 + 20);
				y = HEIGHT/2;
			}
		}
		
		
		
		public void draw (Graphics g){
			
			g.setColor(Color.white);
			g.fillRect((int)x, (int)y, 25, 100);
			
		}
		
		public void move () { //was called update
			if (upMove) {
				yspeed -= 2;
			} else if (downMove) {
				yspeed += 2;
			} else if (!upMove && !downMove) {
				yspeed *= GRAVITY;
			}
			
			if (yspeed >= 3) {
				yspeed = 3;
			} else if (yspeed <= -3) {
				yspeed = -3;
			}
			
			y += yspeed;
			
			
			if (y > 400) {     // constrains bottom edige
				y = 400;
			} else if (y < 0) {  // constrains top edge
				y = 0;
			}
			
		}
		
		public void setUpMove (boolean input) {
			upMove = input;
		}
		
		public void setDownMove (boolean input) {
			downMove = input;
		}
		
		public int getY() {
			return (int)y;
		}
		
		
		
	}
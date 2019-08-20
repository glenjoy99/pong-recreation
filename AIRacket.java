import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.*;

public class AIRacket extends Pong {
		
		float x = WIDTH;
		float y = HEIGHT/2;
		float yspeed = 0;
		final double GRAVITY = 0.94;
		boolean upMove;
		boolean downMove;
		
		Puck puck;
		
		public AIRacket (boolean s, Puck p1) { //Constructor
					
			puck = p1;
			
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

			
			y = puck.getY()-40;
			
			
			if (y > 400) {     // constrains bottom edige
				y = 400;
			} else if (y < 0) {  // constrains top edge
				y = 0;
			}
			
		}

		
		public int getY() {
			return (int)y;
		}
		
		
		
	}
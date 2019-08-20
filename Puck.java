import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.*;


public class Puck extends Pong {
		
		float x ;
		float y ;
		float xspeed ;
		float yspeed ;
		
		
		
		public Puck () {
			x = WIDTH/2;
			y = HEIGHT/2;
			xspeed = 2;
			yspeed = 1;
	
		}
		
		public void draw (Graphics g){
			
			g.setColor(Color.white);
			g.fillOval((int)x-10, (int)y-10, 20, 20);
			
			
		}
		
		public void checkCollision (Racket Player1, AIRacket Player2) {
			if (x <= 50) {
				if (y >= Player1.getY() && y <= Player1.getY() + 50) {
					xspeed = -xspeed;
				}
			} else if (x >= 650) {
				if (y >= Player2.getY() && y <= Player2.getY() + 50) {
					xspeed = -xspeed;
				}
				
			}
		} 
		
		public void move() {
			x = x + xspeed;
			y = y + yspeed;
			
			if (y < 10) {
				yspeed = -yspeed;
			} else if (y > 490) {
				yspeed = -yspeed;
			}
		}
		
		
		public int getX () {
			return (int)x;
		}
		
		public int getY () {
			return (int)y;
		}

	}
	
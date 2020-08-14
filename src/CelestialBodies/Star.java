package CelestialBodies;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Star extends CelestialBody{
	
	public Star(double xLoc, double yLoc, double velX, double velY, int mass, int diameter, Color color, double speed, String name) {
		this.mass = mass;
		this.name = name;
		this.diameter = diameter;
		this.x = xLoc; 
		this.y = yLoc;
		this.distance = 0;
		this.counter = 0;
		this.color = color;
		try {
			this.imageShown = ImageIO.read(new File("resources/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawSunshine(Graphics g, double size, double panX, double panY) {
		g.setColor(new Color(219, 113, 20, 50));
		g.fillOval((int)(panX+650+(x-(diameter * 3)/2-650)*size), (int)(panY+500+(y-(diameter * 3)/2-500)*size),
				(int)((diameter * 3)*size), (int)((diameter * 3)*size));
	}
	
	
	

}

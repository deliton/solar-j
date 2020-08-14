package CelestialBodies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public abstract class CelestialBody {
	public int mass;
	public String name;
	public int diameter;
	public double x; 
	public double y;
	public boolean visible;
	public double distance;
	public int counter = 0;
	public Color color;
	public Image imageShown;

	public double getXPosition(){
		return x;
	}
	public double getYPosition(){
		return y;
	}
	public int getMass(){
		return mass;
	}
	public int getDiameter(){
		return diameter;
	}
	public boolean displayText() {
		return visible;
	}
	public void setDisplayText(boolean b) {
		visible = b;
	}

	public void draw(Graphics g, double size, double panX, double panY){
		g.setColor(color);
		g.fillOval((int)(panX+650+(x-diameter/2-650)*size), (int)(panY+500+(y-diameter/2-500)*size),
				(int)(diameter*size), (int)(diameter*size));

		g.drawImage(this.imageShown,(int)(panX+650+(x-diameter/2-650)*size), (int)(panY+500+(y-diameter/2-500)*size),
				(int)(diameter*size), (int)(diameter*size),null);
	}
	public void displayText(Graphics g, double scale, double panX, double panY){
		g.setColor(color);
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		g.setColor(color);

		g.drawString((name), 
				(int)(panX+650+(x-diameter/2-650)*scale), (int)(panY+500+(y-diameter/2-500)*scale));

	}
	public String getName() {
		return name;
	}
}

package CelestialBodies;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Planet extends CelestialBody{
	public double velX; 
	public double velY;
	public double speed;
	public double acceleration;
	public double xDirection;
	public double yDirection;
	public int orbitDots[][];

	public Planet(double xLoc, double yLoc, double velX, double velY, int mass, int diameter, Color color, double speed, String name) {
		this.mass = mass;
		this.name = name;
		this.diameter = diameter;
		this.x = xLoc; 
		this.y = yLoc;
		this.velX = velX; 
		this.velY = velY;
		this.speed = 0;
		this.acceleration = 0;
		this.xDirection = 0;
		this.yDirection = 0;
		this.distance = 0;
		this.orbitDots = new int[1000][2];
		this.counter = 0;
		this.color = color;
		try {
			this.imageShown = ImageIO.read(new File("resources/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void move()
	{
		x += velX;
		y += velY;
	}

	public void update(double StarX, double StarY, int StarMass)
	{
		if (visible){
			orbitDots[counter][0]=(int)(x+.5);
			orbitDots[counter][1]=(int)(y+.5);
			counter = (counter+1)%1000;
		}
		else{
			orbitDots = new int[1000][2];
			counter = 0;
		}
		distance = Math.sqrt((StarX - x)*(StarX - x) + (StarY - y)*(StarY - y));

		acceleration = StarMass/distance/distance;

		xDirection = (StarX-x)/distance;
		yDirection = (StarY-y)/distance;

		velX += xDirection * acceleration;
		velY += yDirection * acceleration;
		move();

	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}

}

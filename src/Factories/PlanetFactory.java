package Factories;

import java.awt.Color;

import CelestialBodies.Planet;

public class PlanetFactory implements AbstractFactory<Planet>{

	@Override
	public Planet create(String planetName) {
		switch(planetName) {
		case "Mercury":
			return new Planet(600, 450, -4.7, 0, 9, 8, Color.GRAY, 1000,planetName);
		case "Venus":
			return new Planet(752, 400, 0, 2.5, 900, 12, new Color(207,153,52), 1000,planetName);
		case "Earth":
			return new Planet(600, 150, 1.8, 0, 900, 11, Color.BLUE, 2000,planetName);
		case "Mars":
			return new Planet(650, -50, 1.2, 0, 900, 7, Color.RED, 2000,planetName);
		case "Jupiter":
			return new Planet(600, -100, 1.2, 0, 900, 20, new Color(255,140,0), 2000,planetName);
		case "Saturn":
			return new Planet(600, -150, 1.2, 0, 900, 15, new Color(112,128,144), 2000,planetName);
		case "Uranus":
			return new Planet(600, -175, 1.2, 0, 900, 15, new Color(196,233,238), 2000,planetName);
		case "Neptune":
			return new Planet(0, 400, 0, -1.2, 900, 13, new Color(66, 98, 243), 2000,planetName);
		default:
			return null;
				
		}
	}
	
}

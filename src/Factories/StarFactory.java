package Factories;

import java.awt.Color;

import CelestialBodies.Star;

public class StarFactory implements AbstractFactory<Star> {

	@Override
	public Star create(String starName) {
		switch(starName) {
		case "Sun":
			return new Star(600, 400, .1, 0, 1000, 30, Color.ORANGE, 0,starName);
		default:
			return null;
		}
	}

}

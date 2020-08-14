package Factories;

public class FactoryProvider {
	public static AbstractFactory<?> getFactory(String factoryType) {

		if (factoryType.contains("planet")) {
			return new PlanetFactory();

		} else if (factoryType.contains("star")) {
			return new StarFactory();
		}

		return null;
	}
}

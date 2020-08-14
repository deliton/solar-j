package Factories;

public interface AbstractFactory<T> {
    T create(String celestialBodyName) ;
}
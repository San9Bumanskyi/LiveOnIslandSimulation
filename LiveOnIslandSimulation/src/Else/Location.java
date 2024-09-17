package Else;

import animals.Animal;
import plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final int x;
    private final int y;
    private final List<Animal> animals;
    private final Island island;
    private final List<Plant> plants;

    public Location(int x, int y, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setCurrentLocation(this);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }


    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
    public Island getIsland() {
        return island;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "Локація (" + x + ", " + y + "): " +
                "Тварин = " + animals.size() + ", Рослин = " + plants.size();
    }
}

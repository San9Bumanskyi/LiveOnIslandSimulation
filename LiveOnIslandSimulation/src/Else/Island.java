package Else;

import Else.Location;
import animals.Animal;
import plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {
    private final int width;
    private final int height;
    private final Location[][] locations;
    private final Random random = new Random();

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        initializeLocations();
    }
    private void initializeLocations() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location(x, y, this);
            }
        }
    }
    public void addAnimal(Animal animal) {
        Location randomLocation = getRandomLocation();
        randomLocation.addAnimal(animal);
        System.out.println("Тварину " + animal.getName() + " додано на локацію (" + randomLocation.getX() + ", " + randomLocation.getY() + ").");
    }

    public void addPlant(Plant plant) {
        Location randomLocation = getRandomLocation();
        randomLocation.addPlant(plant);
        System.out.println(plant.getName() + " додана на локацію (" + randomLocation.getX() + ", " + randomLocation.getY() + ").");
    }

    private Location getRandomLocation() {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return locations[x][y];
    }

    public List<Animal> getAllAnimals() {
        List<Animal> allAnimals = new ArrayList<>();
        for (Location[] row : locations) {
            for (Location location : row) {
                allAnimals.addAll(location.getAnimals());
            }
        }
        return allAnimals;
    }

    public List<Plant> getAllPlants() {
        List<Plant> allPlants = new ArrayList<>();
        for (Location[] row : locations) {
            for (Location location : row) {
                allPlants.addAll(location.getPlants());
            }
        }
        return allPlants;
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return locations[x][y];
        }
        return null;
    }
}

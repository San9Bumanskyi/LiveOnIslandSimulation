package Else;

import animals.*;
import plants.Plant;
import simulation.AnimalLifeCycle;
import simulation.PlantGrowthTask;
import simulation.SimulationParameters;
import simulation.StatisticsTask;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(SimulationParameters.ISLAND_WIDTH, SimulationParameters.ISLAND_HEIGHT);
        initializePlantsAndAnimals(island);
        List<Animal> allAnimals = island.getAllAnimals();
        List<Plant> allPlants = island.getAllPlants();
        AnimalLifeCycle animalLifeCycle = new AnimalLifeCycle(allAnimals);
        PlantGrowthTask plantGrowthTask = new PlantGrowthTask(allPlants, SimulationParameters.PLANT_GROWTH_RATE);
        StatisticsTask statisticsTask = new StatisticsTask(allAnimals, allPlants);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        scheduler.scheduleAtFixedRate(animalLifeCycle, 0, 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(plantGrowthTask, 0, 5, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(statisticsTask, 0, 9, TimeUnit.SECONDS);
        try {
            while (!isSimulationComplete(allAnimals)) {
                Thread.sleep(SimulationParameters.SIMULATION_STEP_DURATION);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Завершення симуляції...");
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
            }
        }
    }
    private static boolean isSimulationComplete(List<Animal> allAnimals) {
        long aliveAnimalsCount = allAnimals.stream().filter(Animal::isAlive).count();
        System.out.println("Живих тварин: " + aliveAnimalsCount);
        return aliveAnimalsCount < SimulationParameters.MINIMUM_LIVING_ANIMALS_TO_CONTINUE;
    }

    private static void initializePlantsAndAnimals(Island island) {
        for (int i = 0; i < SimulationParameters.INITIAL_PLANT_COUNT; i++) {
            Plant plant = new Plant("Рослина", Math.random() * 2);
            island.addPlant(plant);
        }
        addAnimalsToIsland(island, "Buffalo", SimulationParameters.getAnimalParameter("Buffalo"));
        addAnimalsToIsland(island, "Wolf", SimulationParameters.getAnimalParameter("Wolf"));
        addAnimalsToIsland(island, "Rabbit", SimulationParameters.getAnimalParameter("Rabbit"));
        addAnimalsToIsland(island, "Fox", SimulationParameters.getAnimalParameter("Fox"));
        addAnimalsToIsland(island, "Bear", SimulationParameters.getAnimalParameter("Bear"));
        addAnimalsToIsland(island, "Eagle", SimulationParameters.getAnimalParameter("Eagle"));
        addAnimalsToIsland(island, "Boar", SimulationParameters.getAnimalParameter("Boar"));
        addAnimalsToIsland(island, "Boa", SimulationParameters.getAnimalParameter("Boa"));
        addAnimalsToIsland(island, "Mouse", SimulationParameters.getAnimalParameter("Mouse"));
        addAnimalsToIsland(island, "Caterpillar", SimulationParameters.getAnimalParameter("Caterpillar"));
        addAnimalsToIsland(island, "Deer", SimulationParameters.getAnimalParameter("Deer"));
        addAnimalsToIsland(island, "Duck", SimulationParameters.getAnimalParameter("Duck"));
        addAnimalsToIsland(island, "Goat", SimulationParameters.getAnimalParameter("Goat"));
        addAnimalsToIsland(island, "Horse", SimulationParameters.getAnimalParameter("Horse"));
        addAnimalsToIsland(island, "Sheep", SimulationParameters.getAnimalParameter("Sheep"));
    }

    private static void addAnimalsToIsland(Island island, String animalType, int count) {
        for (int i = 0; i < count; i++) {
            try {
                Animal animal = (Animal) Class.forName("animals." + animalType)
                        .getConstructor(int.class, int.class)
                        .newInstance(0, 0);
                island.addAnimal(animal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

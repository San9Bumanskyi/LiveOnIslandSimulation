package simulation;

import plants.Plant;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PlantGrowthTask implements Runnable {
    private final List<Plant> plants;
    private final ExecutorService growthThreadPool;
    private final double growthRate;

    public PlantGrowthTask(List<Plant> plants, double growthRate) {
        this.plants = plants;
        this.growthRate = growthRate;
        this.growthThreadPool = Executors.newFixedThreadPool(5);
    }

    @Override
    public void run() {
        for (Plant plant : plants) {
            growthThreadPool.submit(() -> {
                synchronized (plant) {
                    growPlant(plant);
                }
            });
        }
    }

    private void growPlant(Plant plant) {
        if (plant.isAlive()) {
            plant.grow(growthRate);
            System.out.println(plant.getName() + " виросла до " + plant.getWeight() + " кг.");
        }
    }

    public void shutdown() {
        growthThreadPool.shutdown();
        try {
            if (!growthThreadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                growthThreadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            growthThreadPool.shutdownNow();
        }
    }
}

package simulation;

import animals.Animal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnimalLifeCycle implements Runnable {
    private final List<Animal> animals;
    private final ExecutorService animalThreadPool;

    public AnimalLifeCycle(List<Animal> animals) {
        this.animals = animals;
        this.animalThreadPool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void run() {
        for (Animal animal : animals) {
            animalThreadPool.submit(() -> {
                synchronized (animal) {
                    performLifeCycleActions(animal);
                }
            });
        }
    }

    private void performLifeCycleActions(Animal animal) {
        if (animal.isAlive()) {
            animal.eat();
            animal.move();
            animal.reproduce();
        }
    }

    public void shutdown() {
        animalThreadPool.shutdown();
        try {
            if (!animalThreadPool.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                animalThreadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            animalThreadPool.shutdownNow();
        }
    }
}

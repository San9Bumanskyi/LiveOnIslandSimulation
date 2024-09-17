package simulation;

import animals.Animal;
import plants.Plant;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsTask implements Runnable {
    private final List<Animal> animals;
    private final List<Plant> plants;

    public StatisticsTask(List<Animal> animals, List<Plant> plants) {
        this.animals = animals;
        this.plants = plants;
    }

    @Override
    public void run() {
        generateStatistics();
    }
    private void generateStatistics() {
        System.out.println("\n=== Статистика ===");
        System.out.println(String.format("%-20s%-10s", "Вид тварини", "Кількість"));
        Map<Class<? extends Animal>, Long> animalCounts = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClass, Collectors.counting()));

        for (Map.Entry<Class<? extends Animal>, Long> entry : animalCounts.entrySet()) {
            System.out.println(String.format("%-20s%-10d", entry.getKey().getSimpleName(), entry.getValue()));
        }
        System.out.println("\nСтатистика рослин:");
        System.out.println(String.format("%-20s%-10s", "ID рослини", "Вага"));
        for (Plant plant : plants) {
            System.out.println(String.format("Рослина #%-10d Вага: %.2f кг", plant.getId(), plant.getWeight()));
        }

        System.out.println("====================================\n");
        printAdditionalStatistics();
    }
    private void printAdditionalStatistics() {
        double averageAnimalEnergy = animals.stream()
                .filter(Animal::isAlive)
                .mapToDouble(Animal::getEnergy)
                .average()
                .orElse(0.0);

        System.out.println("Середній рівень енергії тварин: " + averageAnimalEnergy + " %");

        double averagePlantWeight = plants.stream()
                .filter(Plant::isAlive)
                .mapToDouble(Plant::getWeight)
                .average()
                .orElse(0.0);

        System.out.println("Середня вага живих рослин: " + averagePlantWeight + " кг");
    }
}

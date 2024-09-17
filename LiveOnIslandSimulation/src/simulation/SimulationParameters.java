package simulation;

import java.util.HashMap;
import java.util.Map;

public class SimulationParameters {
    public static final int ISLAND_WIDTH = 10; // Ширина острова (кількість клітинок по горизонталі)
    public static final int ISLAND_HEIGHT = 10; // Висота острова (кількість клітинок по вертикалі)

    public static final int SIMULATION_STEP_DURATION = 1000; // Тривалість одного такту симуляції (у мілісекундах)

    public static final int INITIAL_ANIMAL_COUNT = 50; // Початкова кількість тварин кожного виду
    public static final int INITIAL_PLANT_COUNT = 200; // Початкова кількість рослин на острові

    public static final double PLANT_GROWTH_RATE = 1.0; // Швидкість росту рослин (у кілограмах за такт)

    public static final int MAX_SIMULATION_STEPS = 1000; // Максимальна кількість тактів для симуляції
    public static final int MINIMUM_LIVING_ANIMALS_TO_CONTINUE = 1; // Мінімальна кількість живих тварин для продовження симуляції

    private static final Map<String, Integer> animalSpecificParameters = new HashMap<>();

    static {
        animalSpecificParameters.put("Wolf", 10);
        animalSpecificParameters.put("Rabbit", 20);
        animalSpecificParameters.put("Fox", 8);
        animalSpecificParameters.put("Boa", 7);
        animalSpecificParameters.put("Bear", 5);
        animalSpecificParameters.put("Eagle", 6);
        animalSpecificParameters.put("Boar", 12);
        animalSpecificParameters.put("Buffalo", 7);
        animalSpecificParameters.put("Mouse", 30);
        animalSpecificParameters.put("Caterpillar", 60);
        animalSpecificParameters.put("Deer", 15);
        animalSpecificParameters.put("Duck", 16);
        animalSpecificParameters.put("Goat", 13);
        animalSpecificParameters.put("Horse", 4);
        animalSpecificParameters.put("Sheep", 15);
    }

    public static int getAnimalParameter(String animalType) {
        return animalSpecificParameters.getOrDefault(animalType, INITIAL_ANIMAL_COUNT);
    }

}

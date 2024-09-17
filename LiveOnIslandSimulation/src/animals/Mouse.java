package animals;

import plants.Plant;

import java.util.List;
import java.util.Random;

public class Mouse extends Herbivore {
    private static final Random random = new Random();

    public Mouse(int x, int y) {
        super("Mouse", 0.05, 500, 1, 0.01); // Ініціалізуємо мишу з її характеристиками: вага 0.05 кг, макс. кількість 500, швидкість 1, їжа 0.01 кг
        this.x = x;
        this.y = y;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає рослини або комах для поїдання...");
        List<Plant> availablePlants = findPlants();
        if (!availablePlants.isEmpty()) {
            Plant selectedPlant = selectPlant(availablePlants);
            consumePlant(selectedPlant);
            increaseEnergy(foodRequired);
        } else if (random.nextInt(100) < 50) {
            System.out.println(getName() + " знайшла і з'їла гусінь.");
            increaseEnergy(0.005);
        } else {
            System.out.println(getName() + " не знайшла їжі і голодує.");
            decreaseEnergy(foodRequired);
        }
    }

    @Override
    public void move() {
        System.out.println(getName() + " рухається в пошуках їжі.");
        super.move();
    }

    @Override
    public void reproduce() {
        System.out.println(getName() + " шукає партнера для розмноження.");
        super.reproduce();
    }

    @Override
    public void die() {
        System.out.println(getName() + " померла від голоду або була з'їдена.");
        super.die();
    }
}

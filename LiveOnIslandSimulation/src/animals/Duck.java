package animals;

import plants.Plant;

import java.util.List;
import java.util.Random;

public class Duck extends Herbivore {
    private static final Random random = new Random();

    public Duck(int x, int y) {
        super("Duck", 1, 200, 4, 0.15);
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
        } else if (random.nextInt(100) < 30) {
            System.out.println(getName() + " знайшла і з'їла гусінь.");
            increaseEnergy(0.05);
        } else {
            System.out.println(getName() + " не знайшла їжі і голодує.");
            decreaseEnergy(foodRequired);
        }
    }

    @Override
    public void move() {
        System.out.println(getName() + " плаває або ходить у пошуках їжі.");
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
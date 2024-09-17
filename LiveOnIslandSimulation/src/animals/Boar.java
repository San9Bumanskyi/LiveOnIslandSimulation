package animals;

import plants.Plant;

import java.util.List;
import java.util.Random;

public class Boar extends Herbivore {
    private static final Random random = new Random();

    public Boar(int x, int y) {
        super("Boar", 400, 50, 2, 50);
        this.x = x;
        this.y = y;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає рослини чи комах для поїдання...");
        List<Plant> availablePlants = findPlants();
        if (!availablePlants.isEmpty()) {
            Plant selectedPlant = selectPlant(availablePlants);
            consumePlant(selectedPlant);
            increaseEnergy(foodRequired);
        } else if (random.nextInt(100) < 50) {
            System.out.println(getName() + " знайшов і з'їв гусінь.");
            increaseEnergy(0.1);
        } else {
            System.out.println(getName() + " не знайшов їжі і голодує.");
            decreaseEnergy(foodRequired);
        }
    }

    @Override
    public void move() {
        System.out.println(getName() + " шукає нові місця з рослинами чи комахами.");
        super.move();
    }

    @Override
    public void reproduce() {
        System.out.println(getName() + " намагається знайти партнера для розмноження.");
        super.reproduce();
    }

    @Override
    public void die() {
        System.out.println(getName() + " помер.");
        super.die();
    }
}

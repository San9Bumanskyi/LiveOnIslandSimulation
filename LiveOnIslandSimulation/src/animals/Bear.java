package animals;

import java.util.HashMap;
import java.util.Map;

public class Bear extends Carnivore {
    private static final Map<Class<? extends Animal>, Integer> eatingProbabilities = new HashMap<>();

    static {
        eatingProbabilities.put(Boa.class, 80);
        eatingProbabilities.put(Fox.class, 0);
        eatingProbabilities.put(Wolf.class, 0);
        eatingProbabilities.put(Eagle.class, 0);
        eatingProbabilities.put(Horse.class, 40);
        eatingProbabilities.put(Deer.class, 80);
        eatingProbabilities.put(Rabbit.class, 80);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Goat.class, 70);
        eatingProbabilities.put(Sheep.class, 70);
        eatingProbabilities.put(Boar.class, 50);
        eatingProbabilities.put(Buffalo.class, 20);
        eatingProbabilities.put(Duck.class, 10);
        eatingProbabilities.put(Caterpillar.class, 5);
    }

    public Bear(int x, int y) {
        super("Bear", 500, 5, 2, 80);
        this.x = x;
        this.y = y;
    }

    @Override
    protected int getEatingProbability(Animal prey) {
        return eatingProbabilities.getOrDefault(prey.getClass(), 0);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає здобич для поїдання...");
        super.eat();
    }

    @Override
    public void move() {
        System.out.println(getName() + " повільно рухається до нової локації.");
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

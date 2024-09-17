package animals;

import java.util.HashMap;
import java.util.Map;

public class Eagle extends Carnivore {
    private static final Map<Class<? extends Animal>, Integer> eatingProbabilities = new HashMap<>();

    static {
        eatingProbabilities.put(Fox.class, 10);
        eatingProbabilities.put(Rabbit.class, 90);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Duck.class, 80);
    }

    public Eagle(int x, int y) {
        super("Eagle", 6, 20, 3, 1);
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
        System.out.println(getName() + " летить над островом у пошуках здобичі.");
        super.move();
    }

    @Override
    public void reproduce() {
        System.out.println(getName() + " шукає партнера для розмноження.");
        super.reproduce();
    }

    @Override
    public void die() {
        System.out.println(getName() + " помер від голоду або був з'їдений.");
        super.die();
    }
}

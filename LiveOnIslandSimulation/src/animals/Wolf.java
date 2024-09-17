package animals;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Carnivore {
    private static final Map<Class<? extends Animal>, Integer> eatingProbabilities = new HashMap<>();

    static {
        eatingProbabilities.put(Rabbit.class, 70);
        eatingProbabilities.put(Mouse.class, 80);
        eatingProbabilities.put(Goat.class, 60);
        eatingProbabilities.put(Sheep.class, 70);
        eatingProbabilities.put(Horse.class, 10);
        eatingProbabilities.put(Deer.class, 50);
        eatingProbabilities.put(Boar.class, 15);
        eatingProbabilities.put(Buffalo.class, 10);
        eatingProbabilities.put(Duck.class, 40);
    }

    public Wolf(int x, int y) {
        super("Wolf", 50, 30, 3, 8);
        this.x = x;
        this.y = y;
    }

    @Override
    protected int getEatingProbability(Animal prey) {  return eatingProbabilities.getOrDefault(prey.getClass(), 0);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає здобич для поїдання...");
        super.eat();
    }

    @Override
    public void move() {
        System.out.println(getName() + " рухається до нової локації в пошуках здобичі.");
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

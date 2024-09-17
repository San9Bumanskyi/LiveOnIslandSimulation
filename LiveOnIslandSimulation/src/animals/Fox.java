package animals;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Carnivore {
    private static final Map<Class<? extends Animal>, Integer> eatingProbabilities = new HashMap<>();

    static {
        eatingProbabilities.put(Rabbit.class, 70);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Duck.class, 60);
        eatingProbabilities.put(Caterpillar.class, 40);
    }

    public Fox(int x, int y) {
        super("Fox", 8, 30, 2, 2);
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
        super.eat(); // Викликає стандартну логіку поїдання хижака
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
        System.out.println(getName() + " померла від голоду або була з'їдена.");
        super.die();
    }
}
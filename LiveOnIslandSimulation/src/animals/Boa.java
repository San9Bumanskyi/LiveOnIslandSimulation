package animals;

import java.util.HashMap;
import java.util.Map;

public class Boa extends Carnivore {
    private static final Map<Class<? extends Animal>, Integer> eatingProbabilities = new HashMap<>();

    static {
        eatingProbabilities.put(Fox.class, 15);
        eatingProbabilities.put(Rabbit.class, 20);
        eatingProbabilities.put(Mouse.class, 40);
        eatingProbabilities.put(Duck.class, 10);
    }

    public Boa(int x, int y) {
        super("Boa", 15, 30, 1, 3); // Ініціалізуємо удава з його характеристиками: вага 15 кг, макс. кількість 30, швидкість 1, їжа 3 кг
        this.x = x;
        this.y = y;
    }

    @Override
    protected int getEatingProbability(Animal prey) {
        return eatingProbabilities.getOrDefault(prey.getClass(), 0); // Повертає ймовірність поїдання відповідного виду тварини
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає здобич для поїдання...");
        super.eat();
    }

    @Override
    public void move() {
        System.out.println(getName() + " повільно повзає до нової локації.");
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

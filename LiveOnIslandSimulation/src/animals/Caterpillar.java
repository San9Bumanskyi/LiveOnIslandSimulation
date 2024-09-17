package animals;

import plants.Plant;

import java.util.List;

public class Caterpillar extends Herbivore {

    public Caterpillar(int x, int y) {
        super("Caterpillar", 0.01, 1000, 1, 0.005); // Ініціалізуємо гусінь з її характеристиками: вага 0.01 кг, макс. кількість 1000, швидкість 1, їжа 0.005 кг
        this.x = x;
        this.y = y;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " шукає рослини для поїдання...");
        super.eat();
    }

    @Override
    public void move() {
        System.out.println(getName() + " повільно повзає в пошуках їжі.");
        super.move();
    }

    @Override
    public void reproduce() {
        System.out.println(getName() + " намагається знайти партнера для розмноження.");
        super.reproduce();
    }

    @Override
    public void die() {
        System.out.println(getName() + " померла від голоду або була з'їдена.");
        super.die();
    }
}

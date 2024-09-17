package animals;

import plants.Plant;

import java.util.List;

public class Rabbit extends Herbivore {

    public Rabbit(int x, int y) {
        super("Rabbit", 2, 150, 2, 0.45);
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
        System.out.println(getName() + " стрибає до нової локації в пошуках їжі.");
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

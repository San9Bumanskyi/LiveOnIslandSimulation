package animals;

import plants.Plant;

import java.util.List;

public class Sheep extends Herbivore {

    public Sheep(int x, int y) {
        super("Sheep", 70, 140, 3, 15);
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
        System.out.println(getName() + " рухається до нової локації в пошуках їжі.");
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

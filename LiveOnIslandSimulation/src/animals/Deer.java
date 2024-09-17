package animals;

import plants.Plant;

import java.util.List;

public class Deer extends Herbivore {

    public Deer(int x, int y) {
        super("Deer", 300, 20, 4, 50);
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
        System.out.println(getName() + " помер від голоду або був з'їдений.");
        super.die();
    }
}
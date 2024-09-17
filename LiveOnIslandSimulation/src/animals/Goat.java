package animals;

import plants.Plant;

import java.util.List;

public class Goat extends Herbivore {

    public Goat(int x, int y) {
        super("Goat", 60, 140, 3, 10);
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
        System.out.println(getName() + " шукає нові місця з рослинами для поїдання.");
        super.move(); // Викликає стандартну логіку руху
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
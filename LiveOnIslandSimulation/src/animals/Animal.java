package animals;

import Else.Location;
public abstract class Animal {
    protected String name;
    protected int id;
    private static int idCounter = 0;
    protected double weight;
    protected int maxCountOnCell;
    protected int speed;
    protected double foodRequired;
    protected int x;
    protected int y;
    protected double energy;
    protected Location currentLocation;
    public Animal(String name, double weight, int maxCountOnCell, int speed, double foodRequired) {
        this.name = name;
        this.id = ++idCounter;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.speed = speed;
        this.foodRequired = foodRequired;
        this.energy = 100;
    }

    public abstract void eat();
    public abstract void move();
    public abstract void reproduce();
    public abstract void die();

    public void decreaseEnergy(double amount) {
        this.energy -= amount;
        if (this.energy <= 0) {
            this.die();
        }
    }

    public void increaseEnergy(double amount) {
        this.energy = Math.min(this.energy + amount, 100);
    }

    public void moveTo(int newX, int newY, Location newLocation) {
        this.x = newX;
        this.y = newY;
        if (this.currentLocation != null) {
            this.currentLocation.removeAnimal(this);
        }
        this.currentLocation = newLocation;
        this.currentLocation.addAnimal(this);

        System.out.println(getName() + " перемістився на нову позицію: (" + x + ", " + y + ")");
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name + '#' + id;
    }

    public double getWeight() {
        return weight;
    }
    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodRequired() {
        return foodRequired;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean isAlive() {
        return energy > 0;
    }
    public boolean isReadyToMate() {
        return energy > 50;
    }

    protected int[] getRandomMove(int maxDistance) {
        int deltaX = (int) (Math.random() * (maxDistance + 1)) - maxDistance / 2;
        int deltaY = (int) (Math.random() * (maxDistance + 1)) - maxDistance / 2;
        return new int[] {deltaX, deltaY};
    }
    public Location getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

}

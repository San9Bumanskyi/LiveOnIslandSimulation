package animals;

import Else.Location;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Carnivore extends Animal {
    private static final Random random = new Random();

    public Carnivore(String name, int weight, int maxCountOnCell, int speed, double foodRequired) {
        super(name, weight, maxCountOnCell, speed, foodRequired);
    }

    @Override
    public void eat() {
        List<Animal> preyList = findPrey();
        if (preyList.isEmpty()) {
            System.out.println(getName() + " не знайшов жертву та голодує.");
            decreaseEnergy(foodRequired); // Якщо немає їжі, хижак втрачає енергію
        } else {
            Animal selectedPrey = selectPrey(preyList);
            if (attemptToEat(selectedPrey)) {
                System.out.println(getName() + " з'їв " + selectedPrey.getName());
                selectedPrey.die();
                increaseEnergy(selectedPrey.getWeight()); // Збільшення енергії після вдалого полювання
            } else {
                System.out.println(getName() + " не зміг з'їсти " + selectedPrey.getName());
                decreaseEnergy(foodRequired / 2); // Втрата енергії при невдалій спробі полювання
            }
        }
    }

    private List<Animal> findPrey() {
        Location eatLocation = currentLocation.getIsland().getLocation(getX(), getY());
        return eatLocation.getAnimals().stream()
                .filter(prey -> getEatingProbability(prey) > 0)
                .collect(Collectors.toList());
    }
    private Animal selectPrey(List<Animal> preyList) {
        int index = random.nextInt(preyList.size());
        return preyList.get(index);
    }

    private boolean attemptToEat(Animal prey) {
        int probability = getEatingProbability(prey);
        return random.nextInt(100) < probability;
    }

    protected abstract int getEatingProbability(Animal prey);
    @Override
    public void move() {
        int[] moveVector = getRandomMove(speed);
        int newX = x + moveVector[0];
        int newY = y + moveVector[1];

        Location newLocation = currentLocation.getIsland().getLocation(newX, newY);
        moveTo(newX, newY, newLocation);
        decreaseEnergy(1);
    }

    private List<Animal> findReproduceMate(){
        Location reproduceLocation = currentLocation.getIsland().getLocation(getX(), getY());
        return reproduceLocation.getAnimals().stream()
                .filter(mate -> this.getClass() == mate.getClass())
                .collect(Collectors.toList());
    }

    private Animal selectReproduceMate(List<Animal> reproduceList){
        for (int i = 0; i < reproduceList.size(); i++) {
            if ((this.getX() - reproduceList.get(i).getX() < this.getSpeed()) && (this.getY() - reproduceList.get(i).getY() < this.getSpeed())){
                if (!this.getName().equals(reproduceList.get(i).getName())) {
                    return reproduceList.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public void reproduce() {
        List<Animal> reproduceList = findReproduceMate();
        if (reproduceList.isEmpty()) {
            System.out.println(getName() + " немає партнера для розмноження");
        } else {
            Animal selectedPartner = selectReproduceMate(reproduceList);
            if (selectedPartner != null) {
                System.out.println(this.getName() + " та " + selectedPartner.getName() + " розмножуються");
                currentLocation.addAnimal(this);
            } else {
                System.out.println("Задалеко для розмноження");
            }
        }
    }

    @Override
    public void die() {
        this.setEnergy(0);
        currentLocation.removeAnimal(this);
        System.out.println(getName() + " помер від голоду або був з'їдений.");
    }
}

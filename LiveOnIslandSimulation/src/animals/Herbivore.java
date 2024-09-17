package animals;

import plants.Plant;
import Else.Location;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Herbivore extends Animal {
    private static final Random random = new Random();

    public Herbivore(String name, double weight, int maxCountOnCell, int speed, double foodRequired) {
        super(name, weight, maxCountOnCell, speed, foodRequired);
    }

    @Override
    public void eat() {
        List<Plant> availablePlants = findPlants();
        if (availablePlants.isEmpty()) {
            System.out.println(getName() + " не знайшов їжі та голодує.");
            decreaseEnergy(foodRequired/2);
        } else {
            Plant selectedPlant = selectPlant(availablePlants);
            consumePlant(selectedPlant);
            System.out.println(getName() + " з'їв рослину.");
            increaseEnergy(foodRequired);
        }
    }

    protected List<Plant> findPlants() {
        Location eatLocation = currentLocation.getIsland().getLocation(getX(), getY());
        return eatLocation.getPlants();
    }
    protected Plant selectPlant(List<Plant> plantList) {
        int index = random.nextInt(plantList.size());
        return plantList.get(index);
    }

    protected void consumePlant(Plant plant) {
        plant.consume(foodRequired);
    }

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

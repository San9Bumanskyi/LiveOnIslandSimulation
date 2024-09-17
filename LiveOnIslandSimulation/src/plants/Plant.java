package plants;

public class Plant {
    private int id;
    private String name;
    private static int idCounter = 0;
    private double weight;
    private boolean isAlive;

    public Plant(String name, double weight) {
        this.name = name;
        this.id = ++idCounter;
        this.weight = weight;
        this.isAlive = true;
    }

    public double consume(double amount) {
        if (!isAlive) {
            System.out.println("Рослина вже з'їдена.");
            return 0;
        }

        double consumedAmount = Math.min(amount, this.weight);
        this.weight -= consumedAmount;

        return consumedAmount;
    }
    public void grow(double amount) {
        if (isAlive) {
            this.weight += amount;
        }
    }

    public String getName() {
        return name + '#' +id;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Рослина " + getName() + " вагою " + weight + " кг " + (isAlive ? "жива" : "мертва");
    }
}
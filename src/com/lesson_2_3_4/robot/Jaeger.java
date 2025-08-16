package src.com.lesson_2_3_4.robot;

public class Jaeger {
    private String model;
    private String status;
    private String origin;

    private double height;
    private double weight;

    private int speed; // 9
    private int armor; // 6
    private int strength; // 8

    public Jaeger() {
    }

    public Jaeger(String model, String status, String origin,
            double height, double weight, int speed, int armor, int strength) {
        this.model = model;
        this.status = status;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.armor = armor;
        this.strength = strength;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void scan() {
        System.out.println("Scaning");
    }

    public void run() {
        System.out.println("Runing");
    }

    public void reloadGun() {
        System.out.println("Reload gun");
    }
}

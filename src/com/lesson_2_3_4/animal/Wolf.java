package src.com.lesson_2_3_4.animal;

public class Wolf {
    private String gender;
    private String name;
    private String color;
    private int weight;
    private int age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Пол не может быть пустым");
        }

        final String normalized = gender.trim().toLowerCase();

        if (!normalized.equals("male") && !normalized.equals("female")) {
            throw new IllegalArgumentException("Пол должен быть только male или female");
        }

        this.gender = normalized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя должно быть не короче трех символов");
        }

        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }

        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть больше нуля");
        }

        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 8) {
            throw new IllegalArgumentException("Некорректный возраст");
        }

        this.age = age;
    }

    public void move() {
        System.out.println("Move");
    }

    public void sit() {
        System.out.println("Sit");
    }

    public void run() {
        System.out.println("Run");
    }

    public void howl() {
        System.out.println("Howl");
    }

    public void hunt() {
        System.out.println("Hunt");
    }
}

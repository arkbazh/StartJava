package src.com.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setName("Grey");
        wolfOne.setAge(3);
        wolfOne.setColor("grey");
        wolfOne.setGender("male");

        System.out.println("Name = " + wolfOne.getName());
        System.out.println("Age = " + wolfOne.getAge());
        System.out.println("Color = " + wolfOne.getColor());
        System.out.println("Gender = " + wolfOne.getGender());
        wolfOne.run();
        wolfOne.sit();
        wolfOne.howl();
        wolfOne.hunt();
        wolfOne.move();
    }
}

package src.com.lesson_2_3_4.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger crimsonTyphoon = new Jaeger();
        crimsonTyphoon.setModel("Mark-4");
        crimsonTyphoon.setStatus("Destroyed");
        crimsonTyphoon.setOrigin("China");

        System.out.println("Model " + crimsonTyphoon.getModel());
        System.out.println("Armor " + crimsonTyphoon.getArmor());
        System.out.println("Speed " + crimsonTyphoon.getSpeed());
        System.out.println("Height " + crimsonTyphoon.getHeight() + "\n");

        crimsonTyphoon.setHeight(76.2);
        crimsonTyphoon.setWeight(1.722);
        crimsonTyphoon.setSpeed(9);
        crimsonTyphoon.setStrength(8);
        crimsonTyphoon.setArmor(6);

        Jaeger guardianBravo = new Jaeger("Mark-6", "Active", "Australian",
                73.21, 1.975, 7, 9, 8);

        System.out.println("Model " + guardianBravo.getModel());
        System.out.println("Armor " + guardianBravo.getArmor());
        System.out.println("Speed " + guardianBravo.getSpeed());
        System.out.println("Height " + guardianBravo.getHeight());
    }
}

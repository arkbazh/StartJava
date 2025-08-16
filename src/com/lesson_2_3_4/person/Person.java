package src.com.lesson_2_3_4.person;

public class Person {
    String gender = "male";
    String name = "Tom";
    int height = 180;
    int weight = 80;
    int age = 30;

    void move() {
        System.out.println("move");
    }

    void sit() {
        System.out.println("siting");
    }

    void run() {
        System.out.println("run");
    }

    String speak() {
        return "Hello";
    }

    void learnJava() {
        System.out.println("learning");
    }
}

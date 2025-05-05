package src.com.lesson_2_3_4.guess;

public class Player {
    private String name;
    private int num;

    public Player(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int number) {
        this.num = number;
    }

    @Override
    public String toString() {
        return name;
    }
}

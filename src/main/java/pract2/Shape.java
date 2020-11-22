package pract2;

public class Shape {
    String n = "square";
    int weight = 5;
    String colour = "RED";

    @Override
    public String toString() {
        return "Shape{" +
                "n='" + n + '\'' +
                ", weight=" + weight +
                ", colour='" + colour + '\'' +
                '}';
    }
}

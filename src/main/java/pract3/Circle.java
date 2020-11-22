package pract3;

public class Circle {
    double radius, perimeter, square;
    Circle(double r){
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSquare() {
        square = Math.PI*Math.pow(this.radius, 2);
        return square;
    }

    public double getPerimeter() {
        perimeter = 2*Math.PI*radius;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
}

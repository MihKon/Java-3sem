package pract4;

public class Circle extends Shape{
    double radius = 1;

    Circle(double r, String c, boolean f){
        super(c, f);
        this.radius = r;
    }
    Circle(double r){
        this.radius =  r;
    }
    Circle(){}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI*Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2*Math.PI*radius;
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
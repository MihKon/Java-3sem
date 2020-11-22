package pract4;

public abstract class Shape {
    public String color = "red";
    public boolean filled = true;

    public Shape(String c, boolean f){
        this.color = c;
        this.filled =f;
    }
    public Shape(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea(){
        double area = 1;
        return area;
    }

    public double getPerimeter(){
        double perimeter = 1;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

package pract4;

public class Rectangle extends Shape{
    double width = 1;
    double length = 1;

    Rectangle(double w, double l, String c, boolean f){
        super(c, f);
        this.width = w;
        this.length = l;
    }
    Rectangle(double w, double l){
        this.width = w;
        this.length = l;
    }
    Rectangle(){}

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        double area = this.width*this.length;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = (this.length+this.width)*2;
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

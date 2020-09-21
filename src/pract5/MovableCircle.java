package pract5;

import pract4.Circle;

public class MovableCircle extends Circle implements Movable{
    MovablePoint center;

    public MovableCircle(double radius, int x, int y) {
        this.radius = radius;
        this.center = new MovablePoint(x, y);
    }

    public MovableCircle(int x, int y, int ySpeed, int xSpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, ySpeed, xSpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public double getRadius() {
        return this.radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCenter(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }

    @Override
    public void setSpeed(int xSpeed, int ySpeed) {
        this.center.setSpeed(xSpeed, ySpeed);
    }
}

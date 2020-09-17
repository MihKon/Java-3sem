package pract5;

public class MovableCircle implements Movable{
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int ySpeed, int xSpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, ySpeed, xSpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    public int getRadius() {
        return radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
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
}

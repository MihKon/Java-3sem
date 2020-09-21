package pract5;

public class MovablePoint implements Movable{
    int x, y, ySpeed, xSpeed;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MovablePoint(int x, int y, int ySpeed, int xSpeed) {
        this.x = x;
        this.y = y;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", ySpeed=" + ySpeed +
                ", xSpeed=" + xSpeed +
                '}';
    }

    @Override
    public void moveUp() {
        this.y+=this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y-=this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x-=this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x+=this.xSpeed;
    }

    @Override
    public void setSpeed(int xSpeed, int ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

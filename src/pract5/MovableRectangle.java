package pract5;

public class MovableRectangle implements Movable{
    MovablePoint highleft, downright;
    int width, length;

    public MovableRectangle(int x1, int y1, int x2, int y2, int ySpeed1, int xSpeed1, int ySpeed2, int xSpeed2) {
        this.highleft = new MovablePoint(x1, y1, xSpeed1, ySpeed1);
        this.downright = new MovablePoint(x2, y2, xSpeed2, ySpeed2);
    }

    public MovableRectangle(int x1, int y1, int x2, int y2) {
        this.highleft = new MovablePoint(x1, y1);
        this.downright = new MovablePoint(x2, y2);
    }

    @Override
    public void moveUp() {
        this.highleft.moveUp();
        this.downright.moveUp();
    }

    @Override
    public void moveDown() {
        this.highleft.moveDown();
        this.downright.moveDown();
    }

    @Override
    public void moveLeft() {
        this.highleft.moveLeft();
        this.downright.moveLeft();
    }

    @Override
    public void moveRight() {
        this.highleft.moveRight();
        this.downright.moveRight();
    }

    @Override
    public void setSpeed(int xSpeed, int ySpeed) {
        this.highleft.setSpeed(xSpeed, ySpeed);
        this.downright.setSpeed(xSpeed, ySpeed);
    }

    public int getWidth() {
        return Math.abs(this.highleft.getY()-this.downright.getY());
    }

    public int getlength() {
        return Math.abs(this.downright.getX()-this.highleft.getX());
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

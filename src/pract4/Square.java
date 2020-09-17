package pract4;

public class Square extends Rectangle{
    Square(double side, String c, boolean f){
        super(side, side, c, f);
    }
    Square(double s){
        super(s, s);
    }
    Square(){}

    public double getSide(){
        return super.getLength();
    }

    public void setSide(double side){
        super.width = side;
        super.length = side;
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

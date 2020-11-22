package pract3;

public class Leg {
    double length;
    float weight;

    Leg(double l, float w){
        this.length = l;
        this.weight = w;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }
}

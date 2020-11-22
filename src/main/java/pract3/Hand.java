package pract3;

public class Hand {
    double length;
    float weight;

    Hand(double l, float w){
        this.length = l;
        this.weight = w;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public float getWeight() {
        return weight;
    }
}

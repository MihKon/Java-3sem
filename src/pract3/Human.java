package pract3;

public class Human {
    Head head;
    Leg rleg, lleg;
    Hand rhand, lhand;

    Human(Head h, Hand rhd, Hand lhd, Leg rl, Leg ll){
        this.head = h;
        this.rleg = rl;
        this.lleg = ll;
        this.rhand = rhd;
        this.lhand = lhd;
    }
    Human(){}

    public void setLhand(Hand lhand) {
        this.lhand = lhand;
    }

    public void setRhand(Hand rhand) {
        this.rhand = rhand;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setRleg(Leg rleg) {
        this.rleg = rleg;
    }

    public void setLleg(Leg lleg) {
        this.lleg = lleg;
    }

    public Hand getLhand() {
        return lhand;
    }

    public Hand getRhand() {
        return rhand;
    }

    public Leg getRleg() {
        return rleg;
    }

    public Leg getLleg() {
        return lleg;
    }

    public Head getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "Human{" +
                "head=" + head +
                ", rleg=" + rleg +
                ", lleg=" + lleg +
                ", rhand=" + rhand +
                ", lhand=" + lhand +
                '}';
    }
}

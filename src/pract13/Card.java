package pract13;

public class Card {
    private double cash;

    public void addCash(double bonus) throws Exception {
        if (bonus <= 0)
            throw new Exception();
        cash += bonus;
    }

    public void withdrawCash(double money) throws MyException {
        if (cash < money)
            throw new MyException();
        cash -= money;
    }

    public double getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cash=" + cash +
                '}';
    }
}

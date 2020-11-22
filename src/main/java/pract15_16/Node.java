package pract15_16;

import java.util.Map;
import java.util.TreeMap;

public class Node {
    private int numOfAction;
    private int number;
    private String action;
    private String next;

    public Node(int numOfAction, int number, String next) {
        this.numOfAction = numOfAction;
        this.number = number;
        this.next = next;
        this.action = Tree.getActions().get(numOfAction);
    }

    public int getNumOfAction() {
        return numOfAction;
    }

    public void setNumOfAction(int numOfAction) {
        this.numOfAction = numOfAction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

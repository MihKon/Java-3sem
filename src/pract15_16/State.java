package pract15_16;

import java.util.ArrayList;

public class State {
    private String name;
    private Node node1;
    private Node node2;
    private ArrayList<Node> nodes = new ArrayList<>();

    public State(String name, int numOfAction1, String next1, int numOfAction2, String next2) {
        this.name = name;
        this.node1 = new Node(numOfAction1, 0, next1);
        this.node2 = new Node(numOfAction2, 1, next2);
        nodes.add(node1);
        nodes.add(node2);
    }

    public Node getNode(int num) {
        Node node = null;
        for (Node n : nodes) {
            if (num == n.getNumber())
                node = n;
        }
        return node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}

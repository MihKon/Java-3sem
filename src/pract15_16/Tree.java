package pract15_16;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tree {
    public static Map<Integer, String> actions = new TreeMap<>();

    public static void main(String[] args) {
        actions.put(1, "create_project");
        actions.put(2, "add_library");
        actions.put(3, "restart");
        actions.put(4, "test");
        actions.put(5, "deploy");
        actions.put(6, "drop_db");

        State s1, s2, s3, s4, s5;
        s1 = new State("s1", 1, "s2", 2, "s5");
        s2 = new State("s2", 4, "s3", 6, "s4");
        s3 = new State("s3", 6, "s4", 2, "s5");
        s4 = new State("s4", 3, "s3", 5, "s5");
        s5 = new State("s5", 5, "s1", 3, "s3");

        ArrayList<State> states = new ArrayList<>();
        states.add(s1);
        states.add(s2);
        states.add(s3);
        states.add(s4);
        states.add(s5);

        String currentState = s1.getName();
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        ArrayList<String> result = new ArrayList<>();
        while (flag) {
            for (State e : states) {
                if (currentState.equals(e.getName())) {
                    currentState = e.getNode(num).getNext();
                    result.add(e.getNode(num).getAction());
                    break;
                }
            }
            num = scan.nextInt();
            if (num == -1)
                flag = false;
        }
        for (String e : result) {
            System.out.println(e);
        }
    }

    public static Map<Integer, String> getActions() {
        return actions;
    }
}

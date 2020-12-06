package pract25_26;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        table.add(1, "hello");
        table.add(2, "world");
        table.add(32, "smth");
        table.add(4, "yes");
        table.add(0, "bye");
        table.add(8, "definitely maybe");
        System.out.println("foreach");
        for (String s : table) {
            System.out.println(s);
        }
        System.out.println("getting i = " + 0 + ": " + table.get(0));
        table.add(0, "no");
        System.out.println("getting i = " + 0 + ": " + table.get(0));
        System.out.println("getting i = " + 2 + ": " + table.get(2));
        System.out.println("getting i = " + 4 + ": " + table.get(4));
        System.out.println("removing i = " + 0 + ": " + table.remove(0));
        System.out.println("foreach");
        for (String s : table) {
            System.out.println(s);
        }
        Iterator<String> it1 = table.iterator();
        System.out.println("iterator 1");
        for (int i = 0; i < 3; i++) {
            if (it1.hasNext()) {
                System.out.println(it1.next());
            }
        }
        System.out.println("iterator 2");
        Iterator<String> it2 = table.iterator();
        for (int i = 0; i < 1; i++) {
            if (it2.hasNext()) {
                System.out.println(it2.next());
            }
        }
        System.out.println("iterator 1");
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    }
}

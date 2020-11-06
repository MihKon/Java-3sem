## C:\Users\miha-\IdeaProjects\Java-3sem\src\com\company\Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract1\Fifth.java
```java
package pract1;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] arg){
        int fact;
        Scanner scan = new Scanner(System.in);
        fact = scan.nextInt();
        System.out.print(factor(fact));
    }
    public static int factor(int f){
        int res=1;
        while(f>0){
            res *=f;
            f--;
        }
        return res;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract1\Fourth.java
```java
package pract1;

import java.util.Arrays;
import java.util.Random;

public class Fourth {
    public static void main(String[] arg){
        int[] a = new int[10];
        int i, j;
        for (i=0; i<10; i++){
            a[i] =  0+(int) (Math.random()*80);
            System.out.print(a[i] + " ");
        }
        Arrays.sort(a);
        System.out.println();
        for (j=0; j<10; j++){
            System.out.print(a[j]+" ");
        }
        System.out.println();
        int[] b = new int[10];
        for (i=0; i<10; i++)
        {
            Random rand = new Random();
            b[i] = rand.nextInt(100);
            System.out.print(b[i] + " ");
        }
        Arrays.sort(b);
        System.out.println();
        for (j=0; j<10; j++){
            System.out.print(b[j]+" ");
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract1\Main.java
```java
package pract1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // п.1
        int[] m = new int[5];
        int i, sum=0;
        for(i=0; i<5; i++){
            m[i] = scan.nextInt();
            sum+=m[i];
        }
        System.out.println("summa = " + sum);
        sum=0;
        i=0;
        while (i<5){
            sum+=m[i];
            i++;
        }
        System.out.println(sum);
        sum=0;
        i=0;
        do {
            sum+=m[i];
            i++;
        }while(i<5);
        System.out.println(sum);
        scan.close();
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract1\Second.java
```java
package pract1;

public class Second {
    public static void main(String[] arg){
        for(String str: arg){
            System.out.println("arguments: "+str);
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract1\Third.java
```java
package pract1;

public class Third {
    public static void main(String[] arg){
        int n;
        float x;
        for (n=1; n<11; n++) {
            x = 1 / (float) n;
            System.out.printf("%f%n", x);
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract10\Main.java
```java
package pract10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyCalculator calculator = new MyCalculator();
            calculator.setVisible(true);
        });
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract10\MyCalculator.java
```java
package pract10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyCalculator extends JFrame {
    private double a;
    private double b;
    private double res;
    private Font f = new Font("For number", Font.PLAIN, 20);
    private Font f1 = new Font("For buttons", Font.BOLD, 20);
    private Font lf = new Font("For label", Font.BOLD, 17);
    public MyCalculator(){
        setTitle("Мой калькулятор");
        setSize(450, 550);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Вводите двоичные числа с точкой, а не запятой.");
        label1.setFont(lf);
        JLabel label = new JLabel();
        label.setFont(lf);

        JTextField valueA = new JTextField("Значение A",15);
        valueA.setFont(f);
        JTextField valueB = new JTextField("Значение B", 15);
        valueB.setFont(f);
        JTextField result = new JTextField("Результат", 15);
        result.setFont(f1);
        result.setEditable(false);
        result.setBackground(Color.WHITE);

        JButton addition = new JButton("+");
        addition.setFont(f1);
        JButton subtraction = new JButton("-");
        subtraction.setFont(f1);
        JButton multiplication = new JButton("*");
        multiplication.setFont(f1);
        JButton division = new JButton("/");
        division.setFont(f1);

        valueA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (valueA.getText().equals("Значение A"))
                    valueA.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (valueA.getText().isEmpty())
                    valueA.setText("Значение A");
            }
        });
        valueB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (valueB.getText().equals("Значение B"))
                    valueB.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (valueB.getText().isEmpty())
                    valueB.setText("Значение B");
            }
        });

        valueA.addCaretListener(action -> {
            try {
                a = Double.parseDouble(valueA.getText());
            } catch (Exception ex){
                if (valueA.getText().isEmpty() || valueA.getText().equals("Значение A"))
                    label.setText("");
                else
                    label.setText("Неверный ввод. Вводите числа.");
            }
        });
        valueB.addCaretListener(action -> {
            try {
                b = Double.parseDouble(valueB.getText());
            } catch (Exception ex) {
                if (valueB.getText().isEmpty() || valueB.getText().equals("Значение B"))
                    label.setText("");
                else
                    label.setText("Неверный ввод. Вводите числа.");
            }
        });

        addition.addActionListener(action -> {
            res = a + b;
            result.setText(String.format("%.4f%n", res));
            label.setText("");
        });
        subtraction.addActionListener(actionEvent -> {
            res = a - b;
            result.setText(String.format("%.4f%n", res));
            label.setText("");
        });
        multiplication.addActionListener(actionEvent -> {
            res = a * b;
            result.setText(String.format("%.4f%n", res));
            label.setText("");
        });
        division.addActionListener(actionEvent -> {
            try{
                if (b==0)
                    throw new ArithmeticException();
                res = a / b;
                result.setText(String.format("%.4f%n", res));
            } catch (ArithmeticException ex){
                label.setText("Уууупс! Вы не можете делить на 0.");
            }
        });

        panel.setLayout(null);
        label1.setBounds(20, 0, 500, 20);
        valueA.setBounds(110, 30, 200, 70);
        valueB.setBounds(110 , 230, 200, 70);
        result.setBounds(110, 400, 200, 100);
        addition.setBounds(80, 135, 50 ,50);
        subtraction.setBounds(150, 135, 50, 50);
        multiplication.setBounds(220, 135, 50, 50);
        division.setBounds(290, 135, 50, 50);
        label.setBounds(20, 300, 500, 100);

        panel.add(valueA);
        panel.add(label);
        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);
        panel.add(valueB);
        panel.add(result);

        add(label1);
        add(panel);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract11\Test.java
```java
package pract11;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    //static int op = new Random().nextInt(2020)+200;
    static int totalSum1 = 0;
    static AtomicInteger totalSum2 = new AtomicInteger();
    static ReentrantLock lock = new ReentrantLock();
    static int totalSum3 = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int i1 = i;
            Thread thread = new Thread(() -> doWork(i1));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("TOTAL: " + (end - start));
        System.out.println("TOTAL SUM WITH LOCK: " + totalSum1);
        System.out.println("ATOMIC INTEGER TOTAL SUM: " + totalSum2.get());
        System.out.println("TOTAL SUM WITH SYNCHRONIZED: " + totalSum3);
    }

    private static void doWork(int i) {
        int op = 2020;
        long start = System.currentTimeMillis();
        long result = doSomeWork(i * 1000, op * 10_1_00);
        long end = System.currentTimeMillis();
        System.out.println(i + ": " + result + " time: " + (end - start));
    }

    private static long doSomeWork(int operand, int count) {
        long res = 0;
        for (int i = 0; i < count; i++) {
            res += (operand + i) * (operand + i) * (Math.sqrt(operand + i) + Math.PI);
            incSum1();
            incSum2();
            incSum3();
        }
        return res;
    }

    private static void incSum1(){
        lock.lock();
        totalSum1++;
        lock.unlock();
    }

    private static void incSum2(){
        totalSum2.incrementAndGet();
    }
    private synchronized static void incSum3(){
        totalSum3++;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract12\Main.java
```java
package pract12;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        for (TestEnum e: TestEnum.values()){
            printColorText(e);
        }
    }

    public static void printColorText(TestEnum testEnum) {
       switch (testEnum) {
            case RED:
                testEnum.printText("THIS IS RED", testEnum);
                break;
            case BLUE:
                testEnum.printText("THIS IS BLUE", testEnum);
                break;
            case BLACK:
                testEnum.printText("THIS IS BLACK", testEnum);
                break;
            case GREEN:
                testEnum.printText("THIS IS GREEN", testEnum);
                break;
            case MAGENTA:
                testEnum.printText("THIS IS PURPLE", testEnum);
                break;
            case YELLOW:
                testEnum.printText("THIS IS YELLOW", testEnum);
                break;
            case WHITE:
                testEnum.printText("THIS IS WHITE", testEnum);
                break;
           case TRON:
               testEnum.printText("THIS IS TRON. THE SYSTEM IS WAITING YOU.", testEnum);
               break;
           case USSR:
               testEnum.printText("SOVIET UNION", testEnum);
               break;
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract12\TestEnum.java
```java
package pract12;

public enum TestEnum {
    RED("\u001B[38;2;255;0;0;1m"),
    BLUE("\u001B[38;2;0;55;218;1m"),
    BLACK("\u001B[38;2;0;0;0;1m"),
    WHITE("\u001B[38;2;255;255;255;1m"),
    YELLOW("\u001B[38;2;229;229;16;1m"),
    GREEN("\u001B[38;2;19;161;14;1m"),
    MAGENTA("\u001B[38;2;205;0;205;1m"),
    USSR("\u001B[93;1;48;2;255;0;0m"),
    TRON("\u001B[96;1;4;48;2;0;0;0m");

    private final String color;

    TestEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void printText(String text, TestEnum testEnum) {
        System.out.println(testEnum.getColor() + text);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract13\Card.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract13\Main.java
```java
package pract13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Card card = new Card();
        try {
            card.addCash(600);
            double money = Double.parseDouble(scan.nextLine());
            card.withdrawCash(money);
            card.addCash(-45);
        } catch (MyException me) {
            System.out.println("You can't withdraw this sum, because you haven't got enough money.");
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong enter");
        } catch (Exception ex) {
            System.out.println("You can't add money <= 0. Use another operation.");
        } finally {
            System.out.println(card);
        }

        if (card.getCash() == 600)
            throw new MyRuntimeException();
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract13\MyException.java
```java
package pract13;

public class MyException extends IllegalArgumentException{
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract13\MyRuntimeException.java
```java
package pract13;

public class MyRuntimeException extends RuntimeException{
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract14\Main.java
```java
package pract14;

import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int N;
    private static String[] reg;
    private static String[] nWords;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        reg = new String[N];
        nWords = new String[N];
        for (int i = 0; i < N; i++) {
            reg[i] = scan.next();
            nWords[i] = scan.next();
        }
        String word = scan.next();
        StringBuilder regex = new StringBuilder();
        regex.append(reg[0]);
        for (int i = 1; i < N; i++) {
            regex.append("|");
            regex.append(reg[i]);
        }
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(word);
        String nWord = "";
        nWord = matcher.replaceAll(new Function<MatchResult, String>() {
            @Override
            public String apply(MatchResult matchResult) {
                String s = "";
                for (int i = 0; i < N; i++) {
                    if (matchResult.group().equals(reg[i]))
                        s = nWords[i];
                }
                return s;
            }
        });
        System.out.println(nWord);
        changeWord(word);
    }

    public static void changeWord(String word) {
        int beginPos;
        int endPos;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            boolean f = false;
            for (int j = 0; j < N; j++) {
                beginPos = i;
                endPos = i + reg[j].length();
                if (endPos < word.length() && reg[j].equals(word.substring(beginPos, endPos))) {
                    s.append(nWords[j]);
                    i = endPos - 1;
                    f = true;
                    break;
                }
            }
            if (!f)
                s.append(word.charAt(i));
        }
        System.out.println(s);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract15_16\Node.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract15_16\State.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract15_16\Tree.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract17_18\Main.java
```java
package pract17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //private static ArrayList<String> files = new ArrayList<>();
    private static Path path = Paths.get("src").toAbsolutePath();
    private static String basePath = path.toString();
    private static PrintWriter writer = null;

    static {
        try {
            String result = "projects.md";
            writer = new PrintWriter(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //System.out.println(path);
        //System.out.println(basePath);
        File file = new File(basePath);
        try {
            fileDirectory(file);
        } finally {
            writer.close();
        }
        /*String result = "projects.md";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s : files) {
            //System.out.println(s);
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
                    if (writer != null)
                    {
                        writer.write("##" + s);
                        writer.write('\n');
                        writer.write("```java");
                        writer.write('\n');
                        String line = reader.readLine();
                        while (line != null) {
                            //System.out.println(line);
                            writer.write(line);
                            writer.write('\n');
                            line = reader.readLine();
                        }
                        writer.write("```");
                        writer.write('\n');
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }*/
    }

    public static void fileDirectory(File file) {
        if (file.isDirectory()) {
            String[] s = file.list();
            for (int i = 0; i < s.length; i++) {
                //System.out.println(Paths.get(file.getPath(), s[i]).toAbsolutePath().toString());
                fileDirectory(new File(Paths.get(file.getPath(), s[i]).toString()));
            }
        }
        if (file.isFile()) {
            //System.out.println(file.getPath());
            //files.add(file.getPath());
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
                    if (writer != null) {
                        writer.write("## " + file.getPath());
                        writer.write('\n');
                        writer.write("```java");
                        writer.write('\n');
                        String line = reader.readLine();
                        //StringBuilder result = new StringBuilder();
                        while (line != null) {
                            /*result.append(line);
                            result.append('\n');*/
                            //System.out.println(line);
                            writer.write(line);
                            writer.write('\n');
                            line = reader.readLine();
                        }
                        /*writer.write(result.toString());
                        writer.write('\n');
                        System.out.println(result);*/
                        writer.write("```");
                        writer.write('\n');
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\Ball.java
```java
package pract2;

public class Ball {
    int weight = 3;
    String colour = "Blue";
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\Book.java
```java
package pract2;

public class Book {
    int weight = 2;
    String colour = "Green";
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\Dog.java
```java
package pract2;

public class Dog {
    String name;
    int age;
    Dog(String n, int a){
        this.name = n;
        this.age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int ageIntoHuman(){
        this.age*=8;
        return this.age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\DogKennel.java
```java
package pract2;

import java.util.Scanner;

public class DogKennel {
    public void addDog(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Dog [] ken = new Dog[N];
        for(int i=0; i<N; i++){
            String n = scan.next();
            int a = (int)(Math.random()*15)+1;
            ken[i] = new Dog(n, a);
            System.out.print(ken[i].getName()+" "+ken[i].getAge());
        }
    }

}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\Main.java
```java
package pract2;

public class Main {

    public static void main(String[] args) {
        DogKennel n = new DogKennel();
        n.addDog();
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract2\Shape.java
```java
package pract2;

public class Shape {
    String n = "square";
    int weight = 5;
    String colour = "RED";

    @Override
    public String toString() {
        return "Shape{" +
                "n='" + n + '\'' +
                ", weight=" + weight +
                ", colour='" + colour + '\'' +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Book.java
```java
package pract3;

public class Book {
    String author, date, name;

    Book(String author, String name, String date){
        this.author = author;
        this.name = name;
        this.date = date;
    }

    public String getAuthor() {
        System.out.println(this.author);
        return author;
    }

    public String getDate() {
        System.out.println(this.date);
        return date;
    }

    public String getName() {
        System.out.println(this.name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\BookTest.java
```java
package pract3;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String author = scan.nextLine();
        String name = scan.nextLine();
        String date = scan.nextLine();
        Book b1 = new Book(author, name, date);
        b1.getAuthor();
        b1.getName();
        b1.getDate();
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Circle.java
```java
package pract3;

public class Circle {
    double radius, perimeter, square;
    Circle(double r){
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSquare() {
        square = Math.PI*Math.pow(this.radius, 2);
        return square;
    }

    public double getPerimeter() {
        perimeter = 2*Math.PI*radius;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\CircleTest.java
```java
package pract3;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double r = scan.nextDouble();
        Circle c1 = new Circle(r);
        System.out.println(c1.getRadius());
        System.out.println(c1.getSquare());
        System.out.println(c1.getPerimeter());
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Hand.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Head.java
```java
package pract3;

public class Head {
    double length;
    float weight;

    Head(double l, float w){
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Human.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Leg.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract3\Main.java
```java
package pract3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double l;
        float w;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter head");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Head head = new Head(l, w);

        System.out.println("Enter right hand");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Hand rhand = new Hand(l, w);

        System.out.println("Enter left hand");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Hand lhand = new Hand(l, w);

        System.out.println("Enter right leg");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Leg rleg = new Leg(l, w);

        System.out.println("Enter left leg");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Leg lleg = new Leg(l, w);

        Human man = new Human(head, rhand, lhand, rleg, lleg);

        System.out.println("Head:");
        System.out.println("Length: "+man.getHead().getLength()+" Weight:"+man.getHead().getWeight());
        System.out.println("Right Hand:");
        System.out.println("Length: "+man.getRhand().getLength()+" Weight:"+man.getRhand().getWeight());
        System.out.println("Left Hand:");
        System.out.println("Length: "+man.getLhand().getLength()+" Weight:"+man.getLhand().getWeight());
        System.out.println("Right Leg:");
        System.out.println("Length: "+man.getRleg().getLength()+" Weight:"+man.getRleg().getWeight());
        System.out.println("Left Leg:");
        System.out.println("Length: "+man.getLleg().getLength()+" Weight:"+man.getLleg().getWeight());
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract4\Circle.java
```java
package pract4;

public class Circle extends Shape{
    public double radius = 1;

    public Circle(double r, String c, boolean f){
        super(c, f);
        this.radius = r;
    }
    public Circle(double r){
        this.radius =  r;
    }
    public Circle(){}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI*Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2*Math.PI*radius;
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract4\Main.java
```java
package pract4;

public class Main {

    public static void main(String[] args) {
        Rectangle r = new Square(5);
        System.out.println(r);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract4\Rectangle.java
```java
package pract4;

public class Rectangle extends Shape{
    double width = 1;
    double length = 1;

    Rectangle(double w, double l, String c, boolean f){
        super(c, f);
        this.width = w;
        this.length = l;
    }
    Rectangle(double w, double l){
        this.width = w;
        this.length = l;
    }
    Rectangle(){}

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        double area = this.width*this.length;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = (this.length+this.width)*2;
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract4\Shape.java
```java
package pract4;

public abstract class Shape {
    public String color = "red";
    public boolean filled = true;

    public Shape(String c, boolean f){
        this.color = c;
        this.filled =f;
    }
    public Shape(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea(){
        double area = 1;
        return area;
    }

    public double getPerimeter(){
        double perimeter = 1;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract4\Square.java
```java
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
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract5\Main.java
```java
package pract5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*System.out.println("Enter point and speed");
        System.out.print("x = ");
        int x = scan.nextInt();
        System.out.print("y = ");
        int y = scan.nextInt();
        System.out.print("ySpeed = ");
        int ySpeed = scan.nextInt();
        System.out.print("xSpeed = ");
        int xSpeed = scan.nextInt();
        MovablePoint point = new MovablePoint(x, y, ySpeed, xSpeed);
        System.out.println(point);
        point.moveUp();
        point.moveRight();
        System.out.println(point);

        System.out.println();
        System.out.println("Enter center of circle, speed of center and radius of circle");
        System.out.print("x = ");
        x = scan.nextInt();
        System.out.print("y = ");
        y = scan.nextInt();
        System.out.print("ySpeed = ");
        ySpeed = scan.nextInt();
        System.out.print("xSpeed = ");
        xSpeed = scan.nextInt();
        System.out.print("radius = ");
        int r = scan.nextInt();
        MovableCircle circle = new MovableCircle(x, y, ySpeed, xSpeed, r);
        System.out.println(circle);
        circle.moveDown();
        circle.moveLeft();
        System.out.println(circle);*/
        MovableRectangle r = new MovableRectangle(0, 1, 1, -1);
        System.out.println(r);
        r.setWidth(7);
        r.setLength(5);
        System.out.println(r);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract5\Movable.java
```java
package pract5;

public interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
    public void setSpeed(int xSpeed, int ySpeed);
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract5\MovableCircle.java
```java
package pract5;

import pract4.Circle;

public class MovableCircle extends Circle implements Movable{
    MovablePoint center;

    public MovableCircle(double radius, int x, int y) {
        this.radius = radius;
        this.center = new MovablePoint(x, y);
    }

    public MovableCircle(int x, int y, int ySpeed, int xSpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, ySpeed, xSpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public double getRadius() {
        return this.radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCenter(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }

    @Override
    public void setSpeed(int xSpeed, int ySpeed) {
        this.center.setSpeed(xSpeed, ySpeed);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract5\MovablePoint.java
```java
package pract5;

public class MovablePoint implements Movable{
    int x, y, ySpeed, xSpeed;


    public MovablePoint(int x, int y, int ySpeed, int xSpeed) {
        this.x = x;
        this.y = y;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
    }

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", ySpeed=" + ySpeed +
                ", xSpeed=" + xSpeed +
                '}';
    }

    @Override
    public void moveUp() {
        this.y+=this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y-=this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x-=this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x+=this.xSpeed;
    }

    @Override
    public void setSpeed(int xSpeed, int ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract5\MovableRectangle.java
```java
package pract5;

public class MovableRectangle implements Movable{
    MovablePoint highleft, downright;
    int width, length;

    public MovableRectangle(int x1, int y1, int x2, int y2, int ySpeed1, int xSpeed1, int ySpeed2, int xSpeed2) {
        this.highleft = new MovablePoint(x1, y1, xSpeed1, ySpeed1);
        this.downright = new MovablePoint(x2, y2, xSpeed2, ySpeed2);
        this.width = this.getWidth();
        this.length = this.getlength();
    }

    public MovableRectangle(int x1, int y1, int x2, int y2) {
        this.highleft = new MovablePoint(x1, y1);
        this.downright = new MovablePoint(x2, y2);
        this.width = this.getWidth();
        this.length = this.getlength();
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
        int res = width - this.width;
        this.highleft.setY(this.highleft.getY()+res);
        //this.downright.setY(width - this.highleft.getY());
        this.width = width;
    }

    public void setLength(int length) {
        int res = length - this.length;
        this.downright.setX(this.downright.getX()+res);
        //this.highleft.setX(length-this.downright.getX());
        this.length = length;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "highleft=" + highleft +
                ", downright=" + downright +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract6\Main.java
```java
package pract6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                //a[i][j] = (int) (Math.random() * 200 - 100) + 1;
                a[i][j] = scan.nextInt();
                //System.out.print(a[i][j] + "  ");
            }
            //System.out.println();
        }
        System.out.println();
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s = a[0][0];
        i = 0;
        j = 0;
        while (i != n - 1 || j != n - 1) {
            int max;
            if (i == n - 1 || j == n - 1) {
                if (i == n - 1) {
                    s += a[i][j + 1];
                    j++;
                } else if (j == n - 1) {
                    s += a[i + 1][j];
                    i++;
                }
            } else {
                if (j != n - 2 && i != n - 2) {
                    s1 = a[i][j + 1] + a[i][j + 2];
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s3 = a[i + 1][j] + a[i + 2][j];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                } else if (i == n - 2 && j != n - 2) {
                    s1 = a[i][j + 1] + a[i][j + 2];
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                    s3 = s4;
                } else if (i != n - 2 && j == n - 2) {
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s1 = s2;
                    s3 = a[i + 1][j] + a[i + 2][j];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                } else if (i == n - 2 && j == n - 2) {
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s1 = s2;
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                    s3 = s4;
                }
                max = maximum(s1, s2, s3, s4);
                if (s2 == s4) {
                    if (s1 > s3) {
                        s += a[i][j + 1];
                        j++;
                    } else if (s1 < s3) {
                        s += a[i + 1][j];
                        i++;
                    } else {
                        if (a[i][j + 1] > a[i + 1][j])
                            s += a[i][j + 1];
                        else
                            s += a[i + 1][j];
                        i++;
                        j++;
                    }
                } else if (s1 == s3) {
                    if (s2 > s4) {
                        s += a[i][j + 1];
                        j++;
                    } else if (s2 < s4) {
                        s += a[i + 1][j];
                        i++;
                    }
                } else {
                    if (max == s1 || max == s2) {
                        s += a[i][j + 1];
                        j++;
                    } else if (max == s3 || max == s4) {
                        s += a[i + 1][j];
                        i++;
                    }
                }
            }
            System.out.println(s + " " + a[i][j] + " " + i + " " + j);
        }
        System.out.println(s);
    }

    public static int maximum(int s1, int s2, int s3, int s4) {
        int max = -101;
        if (max < s1)
            max = s1;
        if (max < s2)
            max = s2;
        if (max < s3)
            max = s3;
        if (max < s4)
            max = s4;
        return max;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract6\Nickelback.java
```java
package pract6;

import java.util.Scanner;

public class Nickelback {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int i = 0, j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 200 - 100) + 1;
                //a[i][j] = scan.nextInt();
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    a[i][j] += Math.max(a[i - 1][j], a[i][j - 1]);
                } else if (i > 0) {
                    a[i][j] += a[i - 1][j];
                } else if (j > 0) {
                    a[i][j] += a[i][j - 1];
                }
            }
        }

        System.out.println(a[n - 1][n - 1]);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\Company.java
```java
package pract7;

import java.util.ArrayList;
import java.util.List;

public class Company {
    ArrayList<Employee> list = new ArrayList<Employee>();
    double income1 = 0;

    public void hire(Employee employee){
        list.add(employee);
    }
    public void hireAll(ArrayList <Employee> hireList){
        list.addAll(hireList);
        for (Employee e: list) {
            if (e.employeePosition instanceof Manager)
                income1 += ((Manager) e.employeePosition).getIncome();
        }
        for (Employee e: list) {
            if (e.employeePosition instanceof TopManager)
                ((TopManager) e.employeePosition).setIncome(income1);
        }
    }
    public void fire(Employee employee){
        list.remove(employee);
    }
    public double getIncome(){
        for (Employee e: list){
            if (e.employeePosition instanceof Manager)
                income1+=((Manager) e.employeePosition).getIncome();
        }
        return income1;
    }
    public List<Employee> getTopSalaryStaff(int count){
        ArrayList<Employee> topList = list;
        for (int i=0; i<topList.size()-1; i++){
            for (int j=i+1; j<topList.size(); j++){
                if (topList.get(i).getEmployeePosition().calcSalary(topList.get(i).getConstSalary())<topList.get(j).getEmployeePosition().calcSalary(topList.get(j).getConstSalary())){
                    Employee e = topList.get(j);
                    topList.set(j, topList.get(i));
                    topList.set(i, e);
                }
            }
        }
        if (count<0)
            System.out.println("Error");
        if (count>list.size())
            return topList.subList(0, list.size());
        else
            return topList.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count){
        ArrayList<Employee> lowList = list;
        for (int i=0; i<lowList.size()-1; i++){
            for (int j=i+1; j<lowList.size(); j++){
                if (lowList.get(i).getEmployeePosition().calcSalary(lowList.get(i).getConstSalary())>lowList.get(j).getEmployeePosition().calcSalary(lowList.get(j).getConstSalary())){
                    Employee e = lowList.get(j);
                    lowList.set(j, lowList.get(i));
                    lowList.set(i, e);
                }
            }
        }
        if (count<0)
            System.out.println("Error");
        if (count>list.size())
            return lowList.subList(0, list.size());
        else
            return lowList.subList(0, count);
    }

    public double getIncome1() {
        return income1;
    }
    public void printList(List<Employee> employeeArrayList){
        for (Employee e: employeeArrayList){
            System.out.println(e.getName()+" "+e.getSurname()+" "+e.getEmployeePosition().getJobTitle()+" "+e.getEmployeePosition().calcSalary(e.getConstSalary())+" руб.");
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\Employee.java
```java
package pract7;

import java.util.Comparator;

public class Employee {
    String surname, name, job;
    double constSalary;
    EmployeePosition employeePosition;

    public Employee(String name, String surname, EmployeePosition employeePosition) {
        if (employeePosition instanceof Operator) {
            this.constSalary = 20000;
        }
        if (employeePosition instanceof Manager) {
            this.constSalary = 60000;
        }
        if (employeePosition instanceof TopManager) {
            this.constSalary = 85000;
        }
        this.name = name;
        this.surname = surname;
        this.job = employeePosition.getJobTitle();
        this.employeePosition = employeePosition;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
        this.job = employeePosition.getJobTitle();
    }

    public double getConstSalary() {
        return constSalary;
    }

    public void setConstSalary(double constSalary) {
        this.constSalary = constSalary;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\EmployeePosition.java
```java
package pract7;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\Main.java
```java
package pract7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Company company = new Company();
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int i=0;
        for (i=0; i<180; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Tom";
            String surname = "Riddle";
            Employee e = new Employee(name, surname, operator);
            employees.add(e);
        }
        for (i=0; i<80; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Albus";
            String surname = "Dambledore";
            Employee e = new Employee(name, surname, manager);
            employees.add(e);
        }
        for (i=0; i<10; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Severus";
            String surname = "Snape";
            Employee e = new Employee(name, surname, topManager);
            employees.add(e);
        }
        company.hireAll(employees);
        company.printList(company.getTopSalaryStaff(15));
        System.out.println();
        company.printList(company.getLowestSalaryStaff(30));
        int j = employees.size();
        while (i<employees.size()/2 && j>0){
            int k = (int) Math.random()*j;
            company.fire(employees.get(k));
        }
        System.out.println();
        company.printList(company.getTopSalaryStaff(10));
        System.out.println();
        company.printList(company.getLowestSalaryStaff(30));
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\Manager.java
```java
package pract7;

public class Manager implements EmployeePosition{
    double income;

    public double getIncome() {
        this.income = Math.random()*(145000-115000)+115000;
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary+0.05*this.income;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\Operator.java
```java
package pract7;

public class Operator implements EmployeePosition{
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract7\TopManager.java
```java
package pract7;

public class TopManager implements EmployeePosition{
    double income;

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (income>10000000)
            return baseSalary+1.5*baseSalary;
        else
            return baseSalary;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\Company.java
```java
package pract9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hire(Employee e) {
        employees.add(e);
    }

    public void fire(Employee e) {
        employees.remove(e);
    }

    public void hireAll(ArrayList<Employee> hireList) {
        employees.addAll(hireList);
    }

    public void EmployeesSort(EmployeesHandler handler) {
        for (Employee e : employees) {
            handler.HandleEmployees(e);
        }
    }

    public void EmployeesSecondSort(EmployeesSignal signal, EmployeesHandler handler) {
        int count = 0;
        for (Employee e : employees) {
            if (signal.isThisEmployee(e)) {
                handler.HandleEmployees(e);
                count++;
            }
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\Employee.java
```java
package pract9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employee {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private String location;
    private String phoneNumber;
    private double baseSalary;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Employee(String name, String surname, LocalDate dateOfBirth, String location, String phoneNumber, double baseSalary) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", dateOfBirth = " + dtf.format(dateOfBirth) +
                ", location = '" + location + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                ", baseSalary = " + baseSalary +
                '}';
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\EmployeesHandler.java
```java
package pract9;

import java.util.ArrayList;

public interface EmployeesHandler {
    public void HandleEmployees(Employee employee);
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\EmployeesSelector.java
```java
package pract9;

import java.util.ArrayList;

public class EmployeesSelector implements EmployeesHandler {
    private int year;
    private int count = 0;

    public EmployeesSelector(int year) {
        this.year = year;
    }

    @Override
    public void HandleEmployees(Employee employee) {
        if (employee.getDateOfBirth().getYear() < year) {
            count++;
            System.out.println(employee);
        }
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\EmployeesSignal.java
```java
package pract9;

public interface EmployeesSignal {
    boolean isThisEmployee(Employee e);
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\pract9\Main.java
```java
package pract9;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int i = 0;

        for (i = 0; i < 53; i++) {
            company.hire(new Employee(
                    "Thor",
                    "Oddinson",
                    LocalDate.of(random.nextInt(42) + 1960, random.nextInt(11) + 1, random.nextInt(28) + 1),
                    "MOSCOW, VO RTU MIREA",
                    "8-925-***-**-**",
                    random.nextInt(80_000) + 20_000));
        }

        System.out.println("sort by Year");
        company.EmployeesSort(new EmployeesSelector(1976));

        System.out.println("sort by Salary");
        company.EmployeesSort(new EmployeesHandler() {
            private int count = 0;

            @Override
            public void HandleEmployees(Employee employee) {
                if (employee.getBaseSalary() > 65_000) {
                    System.out.println(employee);
                    count++;
                }
            }
        });

        System.out.println("sort by Month");
        company.EmployeesSecondSort(
                e -> e.getDateOfBirth().getMonthValue() == 2 || e.getDateOfBirth().getMonthValue() == 10,
                e -> System.out.println(e));
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\sidequests\Main.java
```java
package sidequests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        //Nickelback n = new Nickelback(sum);
        //int p = 1+n.F3()+n.F5();
        int i, j, k, p = 0;
        for (i = 0; i <= sum / 5; i++) {
            for (j = 0; j <= sum / 3; j++) {
                for (k = 0; k <= sum; k++) {
                    if ((5 * i + 3 * j + k) == sum)
                        p++;
                }
            }
        }
        System.out.println(p);
    }
}
```
## C:\Users\miha-\IdeaProjects\Java-3sem\src\sidequests\Nickelback.java
```java
package sidequests;

public class Nickelback {

}
```

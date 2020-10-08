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

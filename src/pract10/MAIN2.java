package pract10;

import javax.swing.*;

public class MAIN2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MJU calculator = new MJU();
            calculator.setVisible(true);
        });
    }
}

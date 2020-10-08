package pract10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyCalculator extends JFrame {
    public MyCalculator(){
        setTitle("My Calculator");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label = new JLabel();

        JTextField valueA = new JTextField("Значение A",15);
        valueA.setBounds(300, 0, 5, 5);
        //add(valueA);
        JTextField valueB = new JTextField("Значение B", 15);
        JTextField result = new JTextField("Результат");

        JButton addition = new JButton("+");
        JButton subtraction = new JButton("-");
        JButton multiplication = new JButton("*");
        JButton division = new JButton("/");

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
        valueA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //panel.setLayout(new GridLayout(4, 3));
        panel.add(valueA);
        panel.add(valueB);
        panel.add(result);
        panel2.add(addition);
        panel2.add(subtraction);
        panel2.add(multiplication);
        panel2.add(division);
        //panel.add(label);




        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
    }
}

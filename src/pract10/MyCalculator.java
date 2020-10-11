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

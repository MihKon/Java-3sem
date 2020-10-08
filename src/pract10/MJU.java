package pract10;

import javax.swing.*;
import java.awt.*;

public class MJU extends JFrame {
    private int clickCount = 0;
    public MJU(){
        setTitle("My swing app!!!");
        setSize(500, 500);

        JLabel label = new JLabel("Hello world");
        JTextField field = new JTextField();
        field.addCaretListener(action -> {
            try {
                int value = Integer.parseInt(field.getText());
                label.setText("" + ++value);
            } catch (Exception ex) {
                label.setText(ex.getMessage());
            }

        });
        JButton button = new JButton("Click me");
        button.addActionListener(action -> {

            clickCount++;
            label.setText(field.getText());
        });
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(button);
        JPanel secondPanel = new JPanel();
        secondPanel.add(field);
        secondPanel.add(new JButton("+"));
        panel.add(secondPanel);
        panel.add(new JButton("!!"));
        panel.add(new JButton("!!"));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

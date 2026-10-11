package projectPractice;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class GreetingApp extends JFrame implements ActionListener {
    JTextField name = new JTextField(15);
    JCheckBox upper = new JCheckBox("Uppercase");
    JButton greet = new JButton("Greet");
    JLabel label2 = new JLabel();
    public GreetingApp() {
        setTitle("Greeting App");
        setBackground(Color.blue);
        setLayout(new BorderLayout());
        JLabel label1 = new JLabel("Enter name:");
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(label1, BorderLayout.WEST);
        p1.add(name, BorderLayout.EAST);
        p1.add(upper, BorderLayout.SOUTH);
        greet.addActionListener(this);
        add(p1, BorderLayout.CENTER);
        add(greet, BorderLayout.SOUTH);
        add(label2, BorderLayout.NORTH);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputName = name.getText();
        if (upper.isSelected()) {
            inputName = inputName.toUpperCase();
        }
        label2.setText("Hello, " + inputName + " ");
    }
    public static void main(String[] args) {
        new GreetingApp();
    }
}

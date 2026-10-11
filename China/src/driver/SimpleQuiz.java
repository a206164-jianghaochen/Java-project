package driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleQuiz extends JFrame implements ActionListener {
    JRadioButton Cat, Bird, Fish;
    JTextField resultField;
    JLabel questionLabel, selectedLabel;
    public SimpleQuiz() {
        setTitle("Simple Quiz");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        questionLabel = new JLabel("Which Animal can fly?");
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.WEST;
        add(questionLabel, gbc);
        Cat = new JRadioButton("Cat");
        Bird = new JRadioButton("Bird");
        Fish = new JRadioButton("Fish");
        ButtonGroup group = new ButtonGroup();
        group.add(Cat);
        group.add(Bird);
        group.add(Fish);
        gbc.gridwidth = 1; 
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; 
        add(Cat, gbc);
        gbc.gridy = 2;
        add(Bird, gbc);
        gbc.gridy = 3;
        add(Fish, gbc);
        selectedLabel = new JLabel("You have selected:");
        gbc.gridy = 4;
        add(selectedLabel, gbc);
        resultField = new JTextField(25);
        resultField.setEditable(false);
        gbc.gridy = 5;
        add(resultField, gbc);
        Cat.addActionListener(this);
        Bird.addActionListener(this);
        Fish.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Cat.isSelected()) {
            resultField.setText("Cat can't fly. Try again.");
        } else if (Bird.isSelected()) {
            resultField.setText("Bird can fly. Excellent.");
        } else if (Fish.isSelected()) {
            resultField.setText("Fish can't fly. Try again.");
        }
    }
    public static void main(String[] args) {
        SimpleQuiz frame = new SimpleQuiz();
        frame.setVisible(true);
    }
}


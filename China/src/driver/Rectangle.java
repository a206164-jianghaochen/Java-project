package driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Rectangle extends JFrame implements ActionListener {
    JTextField lengthField, widthField;
    JLabel areaLabel;
    JButton calculateButton;
    public Rectangle() {
        setTitle("Rectangle");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2)); 
        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lengthPanel.add(new JLabel("Length:"));
        add(lengthPanel);
        lengthField = new JTextField();
        add(lengthField);
        JPanel widthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        widthPanel.add(new JLabel("Width:"));
        add(widthPanel);     
        widthField = new JTextField();
        add(widthField);
        calculateButton = new JButton("Enter");
        calculateButton.addActionListener(this);
        add(calculateButton);
        areaLabel = new JLabel("Area of Rectangle: ");
        add(areaLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());
            double area = length * width;
            areaLabel.setText("Area: " + area);
        } catch (NumberFormatException ex) {
            areaLabel.setText("Invalid input. Please enter numbers.");
        }
    }
    public static void main(String[] args) {
        Rectangle frame = new Rectangle();
        frame.setVisible(true);
    }
}


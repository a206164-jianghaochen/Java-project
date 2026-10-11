package driver;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.FlowLayout; 
import javax.swing.JLabel;
import javax.swing.JTextField; 
import javax.swing.JButton; 
import java.awt.Font;
public class MyGUIFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnSubmit;
    private JButton btnHelp;
    public MyGUIFrame() {
        setTitle("FlowLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Correct method name and constant
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Correct commas
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel lblSearchFor = new JLabel("Search for:");
        lblSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblSearchFor);
        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(10);
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(btnSubmit);
        btnHelp = new JButton("Help");
        btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(btnHelp);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MyGUIFrame frame = new MyGUIFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

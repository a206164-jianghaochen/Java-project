package driver;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
public class GridLayoutDemo extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    public GridLayoutDemo() {
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2, 10, 10));
        JLabel lblLogin = new JLabel("Login:");
        contentPane.add(lblLogin);
        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("Password:");
        contentPane.add(lblNewLabel);
        passwordField = new JPasswordField();
        contentPane.add(passwordField);
        passwordField.setColumns(10);
        JButton btnNewButton = new JButton("Login");
        contentPane.add(btnNewButton);
        JButton btnShutDown = new JButton("Shut Down");
        contentPane.add(btnShutDown);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GridLayoutDemo frame = new GridLayoutDemo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

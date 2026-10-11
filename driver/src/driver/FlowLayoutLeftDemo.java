package driver;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class FlowLayoutLeftDemo extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public FlowLayoutLeftDemo() {
        setTitle("FlowLayout Left Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JLabel lblSearchFor = new JLabel("Search for:");
        lblSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblSearchFor);
        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(10);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(btnSubmit);
        JButton btnHelp = new JButton("Help");
        btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(btnHelp);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FlowLayoutLeftDemo frame = new FlowLayoutLeftDemo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


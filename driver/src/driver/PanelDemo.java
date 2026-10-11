package driver;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
public class PanelDemo extends JFrame {
    private JPanel contentPane;
    public PanelDemo() {
        setTitle("PanelDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        JButton btnSubmit = new JButton("Submit");
        panel.add(btnSubmit);
        JButton btnCancel = new JButton("Cancel");
        panel.add(btnCancel);
        JLabel lblYourComments = new JLabel("Your Comments:");
        lblYourComments.setHorizontalAlignment(SwingConstants.CENTER);
        lblYourComments.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblYourComments, BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        contentPane.add(textArea, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PanelDemo frame = new PanelDemo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

package driver;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
public class PanelDemo2 extends JFrame {
    private JPanel contentPane;
    public PanelDemo2() {
        setTitle("PanelDemo2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 3));
        keypad.add(new JButton("1"));
        keypad.add(new JButton("2"));
        keypad.add(new JButton("3"));
        keypad.add(new JButton("4"));
        keypad.add(new JButton("5"));
        keypad.add(new JButton("6"));
        keypad.add(new JButton("7"));
        keypad.add(new JButton("8"));
        keypad.add(new JButton("9"));
        keypad.add(new JButton("0"));
        keypad.add(new JButton("Start"));
        keypad.add(new JButton("Stop"));
        panel.add(new JTextField(10), BorderLayout.NORTH);
        panel.add(keypad, BorderLayout.CENTER);
        contentPane.add(new JButton("Place your food here"), BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.EAST);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PanelDemo2 frame = new PanelDemo2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

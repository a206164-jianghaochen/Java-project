package driver;
import javax.swing.*;
import java.awt.*;
public class BorderLayoutDemo extends JFrame {
    private JTextField textField;
    public BorderLayoutDemo() {
        setTitle("BorderLayoutDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        getContentPane().setLayout(new BorderLayout(0, 0));
        JLabel lblLabBooking = new JLabel("MP1 LAB BOOKING 17/03/2018");
        getContentPane().add(lblLabBooking, BorderLayout.NORTH);
        JLabel lblEnterStudentNo = new JLabel("Enter student no:");
        getContentPane().add(lblEnterStudentNo, BorderLayout.WEST);
        textField = new JTextField();
        getContentPane().add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
        JCheckBox chckbxDoubleSlot = new JCheckBox("Double slot");
        getContentPane().add(chckbxDoubleSlot, BorderLayout.EAST);
        JButton btnSubmit = new JButton("Submit");
        getContentPane().add(btnSubmit, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BorderLayoutDemo frame = new BorderLayoutDemo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



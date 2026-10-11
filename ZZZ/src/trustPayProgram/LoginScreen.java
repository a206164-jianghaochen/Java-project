package trustPayProgram;
import javax.swing.*;

import java.awt.event.*;
public class LoginScreen {
    private final UserManager userManager;
    private final MainMenuScreen mainMenuScreen;
    private final JFrame loginFrame;

    public LoginScreen(UserManager userManager, MainMenuScreen mainMenuScreen, JFrame loginFrame) {
        this.userManager = userManager;
        this.mainMenuScreen = mainMenuScreen;
        this.loginFrame = loginFrame;
    }

    public void setup(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(90, 80, 100, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(90, 120, 100, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if (userManager.validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    loginFrame.dispose();
                    mainMenuScreen.showMainApp(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = JOptionPane.showInputDialog("Enter your username:");
                String newPassword = JOptionPane.showInputDialog("Enter your password:");
                if (!userManager.validateLogin(newUsername, newPassword)) {
                    userManager.addUser(newUsername, newPassword, 0.0);
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                }
            }
        });
    }
    public void showLoginScreen() {       
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        loginFrame.add(panel);
        this.setup(panel); 
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                userManager.saveData();  
            }
        });
    }
}

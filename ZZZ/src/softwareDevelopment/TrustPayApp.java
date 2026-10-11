package softwareDevelopment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class TrustPayApp {
    private static List<User> users = new ArrayList<>();
    private static final String DATA_FILE = "D:/TrustPayData.dat";
    private static String currentUsername;
    public static void main(String[] args) {
        loadData();
        showLoginScreen();
    }
    static class User implements Serializable {
        String username;
        String password;
        double balance;
        ArrayList<String> transactions;
        public User(String username, String password, double initialBalance) {
            this.username = username;
            this.password = password;
            this.balance = initialBalance;
            this.transactions = new ArrayList<>();
        }
    }
    private static void showLoginScreen() {
        JFrame frame = new JFrame("TrustPay Login");
        frame.setSize(300, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeLoginComponents(panel);
        frame.setVisible(true);
    }
    private static void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(15, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 150, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(15, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 150, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton signupButton = new JButton("Sign up");
        signupButton.setBounds(180, 80, 80, 25);
        panel.add(signupButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if (validateLogin(username, password)) {
                    currentUsername = username;
                    showMainApp();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials.");
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if (getUserByUsername(username) == null) { 
                    addUser(username, password, 0.0);
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                    saveData();
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exists.");
                }
            }
        });
    }
    private static void showMainApp() {
        JFrame frame = new JFrame("TrustPay Main Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeEwalletComponents(panel);
        frame.setVisible(true);
    }

    private static void placeEwalletComponents(JPanel panel) {
        panel.setLayout(null);
        User currentUser = getUserByUsername(currentUsername);

        JLabel balanceLabel = new JLabel("Balance: $" + currentUser.balance);
        balanceLabel.setBounds(10, 20, 200, 25);
        panel.add(balanceLabel);

        JTextField addMoneyText = new JTextField(20);
        addMoneyText.setBounds(10, 50, 165, 25);
        panel.add(addMoneyText);

        JButton addMoneyButton = new JButton("Add Money");
        addMoneyButton.setBounds(180, 50, 150, 25);
        panel.add(addMoneyButton);

        addMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (validateLogin(currentUsername, password)) {
                    try {
                        double amount = Double.parseDouble(addMoneyText.getText());
                        currentUser.balance += amount;
                        balanceLabel.setText("Balance: $" + currentUser.balance);
                        currentUser.transactions.add("Added $" + amount);
                        JOptionPane.showMessageDialog(null, "Money added successfully.");
                        addMoneyText.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password incorrect.");
                }
            }
        });

        JTextField transferText = new JTextField(20);
        transferText.setBounds(10, 80, 165, 25);
        panel.add(transferText);

        JButton transferButton = new JButton("Transfer Money");
        transferButton.setBounds(180, 80, 150, 25);
        panel.add(transferButton);

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (validateLogin(currentUsername, password)) {
                    try {
                        double amount = Double.parseDouble(transferText.getText());
                        if (amount > currentUser.balance) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance.");
                        } else {
                            String targetUser = chooseTransferTarget(currentUsername);
                            if (targetUser != null) {
                                User recipient = getUserByUsername(targetUser);
                                currentUser.balance -= amount;
                                recipient.balance += amount;
                                balanceLabel.setText("Balance: $" + currentUser.balance);
                                currentUser.transactions.add("Transferred $" + amount + " to " + targetUser);
                                recipient.transactions.add("Received $" + amount + " from " + currentUsername);
                                JOptionPane.showMessageDialog(null, "Transfer successful.");
                                transferText.setText("");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password incorrect.");
                }
            }
        });
    }

    private static boolean validateLogin(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.password.equals(password);
    }

    private static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    private static void addUser(String username, String password, double initialBalance) {
        users.add(new User(username, password, initialBalance));
    }

    private static String chooseTransferTarget(String currentUser) {
        List<String> userList = new ArrayList<>();
        for (User user : users) {
            if (!user.username.equals(currentUser)) {
                userList.add(user.username);
            }
        }
        if (userList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No other users available.");
            return null;
        }
        return (String) JOptionPane.showInputDialog(null, "Select a user to transfer money:", "Transfer",
                JOptionPane.QUESTION_MESSAGE, null, userList.toArray(), userList.get(0));
    }

    private static void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            users = (ArrayList<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            initializeDefaultUsers();
        }
    }

    private static void initializeDefaultUsers() {
        addUser("JiangHaochen", "12345", 0.0);
        addUser("YuanRunhua", "password1", 0.0);
        addUser("ZengQiLin", "password2", 0.0);
        addUser("JinJie", "password3", 0.0);
    }
}



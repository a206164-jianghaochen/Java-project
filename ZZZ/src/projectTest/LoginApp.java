package projectTest;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;
public class LoginApp {
    private static HashMap<String, Double> userBalances = new HashMap<>();
    private static HashMap<String, ArrayList<String>> userTransactions = new HashMap<>();
    private static HashMap<String, String> userPasswords = new HashMap<>();
    private static final String DATA_FILE = "ewallet_data.dat";  
    public static void main(String[] args) {
        loadData();  
        showLoginScreen();
    }
    private static void initializeDefaultUsers() {
        addUser("JiangHaochen", "12345", 0.0);
        addUser("YuanRunhua", "password1", 0.0);
        addUser("ZengQiLin", "password2", 0.0);
        addUser("JinJie", "password3", 0.0);
    }
    private static void addUser(String username, String password, double initialBalance) {
        userBalances.put(username, initialBalance);
        userTransactions.put(username, new ArrayList<>());
        userPasswords.put(username, password);
    }
    private static void showLoginScreen() {
        JFrame loginFrame = new JFrame("Trust Pay Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeLoginComponents(panel, loginFrame);
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveData();  
            }
        });
    }
    private static void placeLoginComponents(JPanel panel, JFrame loginFrame) {
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
                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    loginFrame.dispose();
                    showMainApp(username);
                } else {
                    JOptionPane.showMessageDialog(null, "username or password is wrong.");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = JOptionPane.showInputDialog("Enter your username:");
                if (newUsername == null || newUsername.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username cannot be empty.");
                    return;
                }
                if (userPasswords.containsKey(newUsername)) {
                    JOptionPane.showMessageDialog(null, "Username already exists.");
                    return;
                }
                String newPassword = JOptionPane.showInputDialog("Enter your password:");
                if (newPassword == null || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password cannot be empty.");
                    return;
                }
                addUser(newUsername, newPassword, 0.0);
                JOptionPane.showMessageDialog(null, "Registered successfully.");
            }
        });
    }
    private static boolean validateLogin(String username, String password) {
        return userPasswords.containsKey(username) && userPasswords.get(username).equals(password);
    }
    private static void showMainApp(String username) {
        JFrame mainFrame = new JFrame("E-Wallet for " + username);
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        mainFrame.add(panel);
        placeEwalletComponents(panel, mainFrame, username);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveData();  
            }
        });
    }
    private static void placeEwalletComponents(JPanel panel, JFrame mainFrame, String username) {
        panel.setLayout(null);
        JLabel balanceLabel = new JLabel("Balance: ¥" + userBalances.get(username));
        balanceLabel.setBounds(10, 10, 200, 25);
        panel.add(balanceLabel);
        JLabel exchangeRateLabel = new JLabel("Exchange Rate = 1.64(100RM = 164RMB)");
        exchangeRateLabel.setBounds(10, 30, 400, 20);
        panel.add(exchangeRateLabel);
        JLabel topUpLabel = new JLabel("Top up:");
        topUpLabel.setBounds(10, 60, 100, 25);
        panel.add(topUpLabel);
        JTextField topUpText = new JTextField(10);
        topUpText.setBounds(120, 60, 120, 25);
        panel.add(topUpText);
        JButton topUpButton = new JButton("top Up");
        topUpButton.setBounds(255, 60, 100, 25);
        panel.add(topUpButton);                              
        topUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (validateLogin(username, password)) {
                    try {
                        double amount = Double.parseDouble(topUpText.getText());
                        double newBalance = userBalances.get(username) + amount;
                        userBalances.put(username, newBalance);
                        balanceLabel.setText("Balance: ¥" + newBalance);
                        userTransactions.get(username).add("Added ¥" + amount);
                        JOptionPane.showMessageDialog(null, "Money added successfully.");
                        topUpText.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password incorrect.");
                }
            }
        });
        JLabel transferLabel = new JLabel("Transfer Money:");
        transferLabel.setBounds(10, 100, 100, 25);
        panel.add(transferLabel);
        JTextField transferText = new JTextField(10);
        transferText.setBounds(120, 100, 120, 25);
        panel.add(transferText);
        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(255, 100, 100, 25);
        panel.add(transferButton);
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (validateLogin(username, password)) {
                    try {
                        double amount = Double.parseDouble(transferText.getText());
                        double currentBalance = userBalances.get(username);
                        if (amount > currentBalance) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance.");
                        } else {
                            String targetUser = chooseTransferTarget(username);
                            if (targetUser != null) {
                                double newBalance = currentBalance - amount;
                                userBalances.put(username, newBalance);
                                userBalances.put(targetUser, userBalances.get(targetUser) + amount);
                                balanceLabel.setText("Balance: RM" + newBalance);
                                userTransactions.get(username).add("Transferred RM" + amount + " to " + targetUser);
                                userTransactions.get(targetUser).add("Received RM" + amount + " from " + username);
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
         JLabel exchangeLabel = new JLabel("Exchange:");   
         exchangeLabel.setBounds(10, 140, 100, 25);
         panel.add(exchangeLabel);
         JTextField exchangeText = new JTextField(10);
         exchangeText.setBounds(120, 140, 120, 25);
         panel.add(exchangeText);
         JButton exchangeButton = new JButton("Exchange");
         exchangeButton.setBounds(255, 140, 100, 25);
         panel.add(exchangeButton);
        
        
        
        
        
        
        
        JButton transactionHistoryButton = new JButton("Bill History");
        transactionHistoryButton.setBounds(110, 180, 150, 25);
        panel.add(transactionHistoryButton);
        transactionHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> transactions = userTransactions.get(username);
                if (transactions.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No transactions found.");
                } else {
                    JOptionPane.showMessageDialog(null, String.join("\n", transactions));
                }
            }
        });
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(140, 220, 80, 25);
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showLoginScreen();
            }
        });
    }
    private static String chooseTransferTarget(String currentUser) {
        String[] users = userBalances.keySet().stream().filter(user -> !user.equals(currentUser)).toArray(String[]::new);
        if (users.length == 0) {
            JOptionPane.showMessageDialog(null, "No other users available.");
            return null;
        }
        return (String) JOptionPane.showInputDialog(null, "Select a user to transfer money:", "Transfer", JOptionPane.QUESTION_MESSAGE, null, users, users[0]);
    }
    private static void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(userBalances);
            out.writeObject(userTransactions);
            out.writeObject(userPasswords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            userBalances = (HashMap<String, Double>) in.readObject();
            userTransactions = (HashMap<String, ArrayList<String>>) in.readObject();
            userPasswords = (HashMap<String, String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            initializeDefaultUsers();  
        }
    }
}
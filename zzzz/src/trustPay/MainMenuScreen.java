package trustPay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenuScreen {
    private final UserManager userManager;
    private JFrame mainFrame;
    public MainMenuScreen(UserManager userManager) {
        this.userManager = userManager;
    }
    public void showMainApp(String username) {
        mainFrame = new JFrame("E-Wallet for " + username);
        mainFrame.setSize(510, 350);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        mainFrame.add(panel);
        setupMainMenu(panel, username);
        mainFrame.setVisible(true);
    }
    private void setupMainMenu(JPanel panel, String username) {
        JLabel balanceLabel = new JLabel("Balance: ¥" + userManager.getBalance(username));
        balanceLabel.setBounds(10, 10, 300, 25);
        panel.add(balanceLabel);
        JLabel rmBalanceLabel = new JLabel("Balance (RM): RM" + userManager.getRmBalance(username));
        rmBalanceLabel.setBounds(10, 40, 300, 25);
        panel.add(rmBalanceLabel);
        JLabel exchangeRateLabel = new JLabel("Exchange Rate = 1.64 (100RM = 164RMB)");
        exchangeRateLabel.setBounds(10, 70, 300, 25);
        panel.add(exchangeRateLabel);      
        JLabel topUpLabel = new JLabel("Top up:");
        topUpLabel.setBounds(10, 110, 80, 25);
        panel.add(topUpLabel);
        JTextField topUpField = new JTextField();
        topUpField.setBounds(130, 110, 120, 25);
        panel.add(topUpField);
        JButton topUpButton = new JButton("top Up");
        topUpButton.setBounds(270, 110, 100, 25);
        panel.add(topUpButton);
        topUpButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String password = JOptionPane.showInputDialog("Enter your password:");
        	    if (userManager.validateLogin(username, password)) {
        	        try {
        	            double amount = Double.parseDouble(topUpField.getText());
        	            double newBalance = userManager.getBalance(username) + amount;
        	            userManager.setBalance(username, newBalance);
        	            balanceLabel.setText("Balance: ¥" + newBalance);
        	            JOptionPane.showMessageDialog(panel, "Top-up successful!");       	            
        	            userManager.recordTransaction(username, "Top-up ¥" + amount);       	                   	            
        	            topUpField.setText("");
        	        } catch (NumberFormatException ex) {
                              
        	            JOptionPane.showMessageDialog(panel, "Invalid amount.");
        	        }
        	    } else {
        	        JOptionPane.showMessageDialog(panel, "Password incorrect.");
        	    }
        	}});
        JLabel transferLabel = new JLabel("Transfer Money:");
        transferLabel.setBounds(10, 150, 120, 25);
        panel.add(transferLabel);
        JTextField transferField = new JTextField();
        transferField.setBounds(130, 150, 120, 25);
        panel.add(transferField);
        JComboBox<String> transferCurrency = new JComboBox<>(new String[]{"RMB", "RM"});
        JComboBox<String> targetUserComboBox = new JComboBox<>(userManager.getAllUsernames().toArray(new String[0]));
        targetUserComboBox.setBounds(130, 180, 120, 25);
        panel.add(targetUserComboBox);
        transferCurrency.setBounds(270, 150, 100, 25);
        panel.add(transferCurrency);
        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(380, 150, 100, 25);
        panel.add(transferButton);
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (userManager.validateLogin(username, password)) {
                    try {
                        double amount = Double.parseDouble(transferField.getText());
                        String targetUsername = (String) targetUserComboBox.getSelectedItem();  
                        String currency = (String) transferCurrency.getSelectedItem();
                        if (targetUsername != null && !targetUsername.equals(username)) {
                            if ("RMB".equals(currency)) {
                                double balance = userManager.getBalance(username);
                                if (balance >= amount) {
                                    userManager.setBalance(username, balance - amount);
                                    userManager.setBalance(targetUsername, userManager.getBalance(targetUsername) + amount);
                                    userManager.recordTransaction(username, "Transferred ¥" + amount + " to " + targetUsername);
                                    userManager.recordTransaction(targetUsername, "Received ¥" + amount + " from " + username);
                                    balanceLabel.setText("Balance: ¥" + userManager.getBalance(username));
                                    JOptionPane.showMessageDialog(panel, "Transfer successful!");
                                } else {
                                    JOptionPane.showMessageDialog(panel, "Insufficient balance.");
                                }
                            } else if ("RM".equals(currency)) {
                                double rmBalance = userManager.getRmBalance(username);
                                if (rmBalance >= amount) {
                                    userManager.setRmBalance(username, rmBalance - amount);
                                    userManager.setRmBalance(targetUsername, userManager.getRmBalance(targetUsername) + amount);

                                    userManager.recordTransaction(username, "Transferred RM" + amount + " to " + targetUsername);
                                    userManager.recordTransaction(targetUsername, "Received RM" + amount + " from " + username);

                                    rmBalanceLabel.setText("Balance (RM): RM" + userManager.getRmBalance(username));
                                    JOptionPane.showMessageDialog(panel, "Transfer successful!");
                                } else {
                                    JOptionPane.showMessageDialog(panel, "Insufficient balance.");
                                }
                            }
                            transferField.setText(""); 
                        } else {
                            JOptionPane.showMessageDialog(panel, "Cannot transfer to yourself.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Password incorrect.");
                }
            }
        });
        JLabel exchangeLabel = new JLabel("Exchange:");
        exchangeLabel.setBounds(10, 215, 80, 25);
        panel.add(exchangeLabel);
        JTextField exchangeField = new JTextField();
        exchangeField.setBounds(130, 215, 120, 25);
        panel.add(exchangeField);
        JButton exchangeButton = new JButton("Exchange");
        exchangeButton.setBounds(270, 215, 100, 25);
        panel.add(exchangeButton);
        exchangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = JOptionPane.showInputDialog("Enter your password:");
                if (userManager.validateLogin(username, password)) {
                    try {
                        double amount = Double.parseDouble(exchangeField.getText());
                        double currentBalance = userManager.getBalance(username);

                        if (currentBalance >= amount) {
                            double newBalance = currentBalance - amount;
                            double newRmBalance = userManager.getRmBalance(username) + amount / 1.64;
                            newBalance = Double.parseDouble(String.format("%.2f", newBalance));
                            newRmBalance = Double.parseDouble(String.format("%.2f", newRmBalance));
                            userManager.setBalance(username, newBalance);
                            userManager.setRmBalance(username, newRmBalance);
                            userManager.recordTransaction(username, "Exchanged ¥" + amount + " to RM" + String.format("%.2f", amount / 1.64));
                            balanceLabel.setText("Balance: ¥" + String.format("%.2f", newBalance));
                            rmBalanceLabel.setText("Balance (RM): RM" + String.format("%.2f", newRmBalance));
                            JOptionPane.showMessageDialog(panel, "Exchange successful!");
                            exchangeField.setText("");  
                        } else {
                            JOptionPane.showMessageDialog(panel, "Insufficient balance.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid amount.");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Password incorrect.");
                }
            }
        });
        JButton historyButton = new JButton("Bill History");
        historyButton.setBounds(85, 260, 120, 30);
        panel.add(historyButton);
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HistoryScreen(userManager, username).show();
            }
        });
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(285, 260, 120, 30);
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Logged out successfully!");                                                                         
                mainFrame.dispose();                
                EWalletApp.getInstance().showLoginScreen();
            }
        });
    }
}

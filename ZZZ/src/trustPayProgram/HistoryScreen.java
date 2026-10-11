package trustPayProgram;
import javax.swing.*;

import java.util.ArrayList;
public class HistoryScreen {
    private final UserManager userManager;
    private final String username;
    public HistoryScreen(UserManager userManager, String username) {
        this.userManager = userManager;
        this.username = username;
    }
    public void show() {
        JFrame historyFrame = new JFrame("Bill History for " + username);
        historyFrame.setSize(400, 300);
        historyFrame.setLocationRelativeTo(null); 

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false); 
        ArrayList<String> transactions = userManager.getTransactions(username);

        if (transactions.isEmpty()) {
            historyArea.append("No transactions found.\n"); 
        } else {
            for (String transaction : transactions) {
                historyArea.append(transaction + "\n");
            }
        }
        JScrollPane scrollPane = new JScrollPane(historyArea);
        historyFrame.add(scrollPane); 
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.setVisible(true);
    }
}

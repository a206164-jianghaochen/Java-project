package driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CreateYourPizza {
    private static JLabel selectedSizeLabel = null;
    private static JLabel selectedCrustLabel = null;
    private static JPanel sizePanel;
    private static JPanel crustPanel;
    private static JLabel outputLabel;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Create Your Own Pizza");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        JLabel titleLabel = new JLabel("Cheap & Tasty (Limited 1 customer = 1 pizza)");
        panel.add(titleLabel, gbc);
        gbc.gridy = 1;
        JLabel lineLabel = new JLabel("***********************************************");
        panel.add(lineLabel, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel nameLabel = new JLabel("Customer Name:");
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        JTextField nameText = new JTextField(20);
        panel.add(nameText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        JLabel sizeLabel = new JLabel("Size:");
        panel.add(sizeLabel, gbc);
        gbc.gridx = 1;
        JLabel crustLabel = new JLabel("Crust:");
        panel.add(crustLabel, gbc);
        gbc.gridx = 2;
        JLabel toppingsLabel = new JLabel("Toppings (RM1 each):");
        panel.add(toppingsLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
        sizePanel.setBackground(Color.WHITE);
        sizePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));       
        JLabel smallSize = createClickableLabel("Small (RM3)");
        JLabel regularSize = createClickableLabel("Regular (RM5)");
        JLabel largeSize = createClickableLabel("Large (RM7)");
        JLabel extraLargeSize = createClickableLabel("Xtra Large (RM9)");       
        sizePanel.add(smallSize);
        sizePanel.add(regularSize);
        sizePanel.add(largeSize);
        sizePanel.add(extraLargeSize);
        panel.add(sizePanel, gbc);
        gbc.gridx = 1;
        crustPanel = new JPanel();
        crustPanel.setLayout(new BoxLayout(crustPanel, BoxLayout.Y_AXIS));
        crustPanel.setBackground(Color.WHITE);
        crustPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));        
        JLabel classicCrust = createClickableLabel("Classic (RM2)");
        JLabel thinCrust = createClickableLabel("Crunchy Thin (RM3)");
        JLabel stuffedCrust = createClickableLabel("Stuffed (RM4)");
        JLabel cheeseBurstCrust = createClickableLabel("Cheese Burst (RM5)");       
        crustPanel.add(classicCrust);
        crustPanel.add(thinCrust);
        crustPanel.add(stuffedCrust);
        crustPanel.add(cheeseBurstCrust);
        panel.add(crustPanel, gbc);
        gbc.gridx = 2;
        JPanel toppingsPanel = new JPanel(new GridLayout(3, 2)); // 3 rows, 2 columns
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox sausage = new JCheckBox("Sausage");
        JCheckBox mushroom = new JCheckBox("Mushroom");
        JCheckBox cheese = new JCheckBox("Cheese");
        JCheckBox onion = new JCheckBox("Onion");
        JCheckBox pepper = new JCheckBox("Pepper");
        toppingsPanel.add(pepperoni);
        toppingsPanel.add(cheese);
        toppingsPanel.add(sausage);
        toppingsPanel.add(onion);
        toppingsPanel.add(mushroom);
        toppingsPanel.add(pepper);
        panel.add(toppingsPanel, gbc);
        JPanel buttonPanel = new JPanel();
        JButton orderButton = new JButton("Order");
        JButton resetButton = new JButton("Reset");
        buttonPanel.add(orderButton);
        buttonPanel.add(resetButton);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        outputLabel = new JLabel("");
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(outputLabel, gbc);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                if (name.isEmpty() || selectedSizeLabel == null || selectedCrustLabel == null) {
                    outputLabel.setText("Please complete the form. TQ");
                    return;
                }
                String size = selectedSizeLabel != null ? selectedSizeLabel.getText() : "";
                int sizePrice = getPrice(size);               
                String crust = selectedCrustLabel != null ? selectedCrustLabel.getText() : "";
                int crustPrice = getPrice(crust);              
                int toppingPrice = 0;
                String toppings = "";
                if (pepperoni.isSelected()) { toppings += "Pepperoni "; toppingPrice += 1; }
                if (sausage.isSelected()) { toppings += "Sausage "; toppingPrice += 1; }
                if (mushroom.isSelected()) { toppings += "Mushroom "; toppingPrice += 1; }
                if (cheese.isSelected()) { toppings += "Cheese "; toppingPrice += 1; }
                if (onion.isSelected()) { toppings += "Onion "; toppingPrice += 1; }
                if (pepper.isSelected()) { toppings += "Pepper "; toppingPrice += 1; }
                int totalPrice = sizePrice + crustPrice + toppingPrice;
                outputLabel.setText("Order for " + name + ": Size: " + size + " | Crust: " + crust + " | Toppings: " + toppings + " | Total: RM" + totalPrice);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                selectedSizeLabel = null;
                selectedCrustLabel = null;
                pepperoni.setSelected(false);
                sausage.setSelected(false);
                mushroom.setSelected(false);
                cheese.setSelected(false);
                onion.setSelected(false);
                pepper.setSelected(false);
                outputLabel.setText("");
                updateLabels();
            }
        });
    }
    private static JLabel createClickableLabel(String text) {
        JLabel label = new JLabel(text);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (label.getParent() == sizePanel) {
                    selectedSizeLabel = label;
                } else if (label.getParent() == crustPanel) {
                    selectedCrustLabel = label;
                }
                updateLabels();
            }
        });
        return label;
    }
    private static void updateLabels() {
        for (Component component : sizePanel.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setForeground(label.equals(selectedSizeLabel) ? Color.RED : Color.BLACK);
            }
        }
        for (Component component : crustPanel.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setForeground(label.equals(selectedCrustLabel) ? Color.RED : Color.BLACK);
            }
        }
    }
    private static int getPrice(String text) {
        if (text.contains("Small")) return 3;
        if (text.contains("Regular")) return 5;
        if (text.contains("Large")) return 7;
        if (text.contains("Xtra Large")) return 9;
        if (text.contains("Classic")) return 2;
        if (text.contains("Crunchy Thin")) return 3;
        if (text.contains("Stuffed")) return 4;
        if (text.contains("Cheese Burst")) return 5;
        return 0;
    }
}


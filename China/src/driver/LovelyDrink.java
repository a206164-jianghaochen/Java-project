package driver;
import javax.swing.*;
import java.awt.*;
public class LovelyDrink extends JFrame {
    private JList<String> drinkList;
    private JTextField selectedDrinkField;
    private JLabel selectedDrinkLabel;
    public LovelyDrink() {
        setTitle("**Lovely Drink**");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String[] drinks = {
            "Caramel Choco", "Pepper Mint", "Tropical Candy",
            "Honey Bubble", "Vanilla Orea", "Irish Cream", "Milk Tea"
        };
        drinkList = new JList<>(drinks);
        drinkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedDrinkField = new JTextField(10); 
        selectedDrinkField.setEditable(false);
        selectedDrinkLabel = new JLabel("Selected Drink <<<");
        JPanel selectedDrinkPanel = new JPanel(new FlowLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        selectedDrinkPanel.add(selectedDrinkLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        selectedDrinkPanel.add(selectedDrinkField, gbc);
        selectedDrinkPanel.add(selectedDrinkLabel);
        selectedDrinkPanel.add(selectedDrinkField);
        drinkList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedDrink = drinkList.getSelectedValue();
                selectedDrinkField.setText(selectedDrink);
            }
        });
        add(new JScrollPane(drinkList), BorderLayout.CENTER);
        add(selectedDrinkPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        LovelyDrink frame = new LovelyDrink();
        frame.setVisible(true);
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


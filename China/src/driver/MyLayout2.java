package driver;
import javax.swing.*;  // Import the Swing package for UI components
import java.awt.*;     // Import the AWT package for layouts and other utilities
class MyLayout extends JFrame { 
    JButton b1, b2, b3, b4, b5; // Declare components
    public MyLayout() {
        Container pane = getContentPane(); 
        pane.setLayout(new GridBagLayout()); // Set Layout
        GridBagConstraints gbc = new GridBagConstraints();    
        b1 = new JButton("One"); // Create b1
        b2 = new JButton("Two"); // Create b2
        b3 = new JButton("Three"); // Create b3
        b4 = new JButton("Four"); // Create b4
        b5 = new JButton("Five"); // Create b5
        // Add b1 to the first row
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 3; // Span 3 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(b1, gbc);
        // Add b2, b3, b4 to the second row
        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Span 1 column each
        pane.add(b2, gbc);
        gbc.gridx = 1; // Column 1
        pane.add(b3, gbc);
        gbc.gridx = 2; // Column 2
        pane.add(b4, gbc);
        // Add b5 to the third row
        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        gbc.gridwidth = 3; // Span 3 columns
        pane.add(b5, gbc);
    }
 
    public static void main(String[] args) { 
        MyLayout frame = new MyLayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("Button Layout Example"); // Set the title
        frame.setSize(250, 200); // Set size
        frame.setVisible(true);
    }
}


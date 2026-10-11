package driver;
import javax.swing.*;  // Import the Swing package for UI components
import java.awt.*;     // Import the AWT package for layouts and other utilities
class MyLayout extends JFrame { 
    JButton b1, b2, b3, b4, b5; // Declare component
    public MyLayout() {
        Container pane = getContentPane(); 
        pane.setLayout(new FlowLayout()); // Set Layout      
        b1 = new JButton("One"); // Create b1
        b2 = new JButton("Two"); // Create b2
        b3 = new JButton("Three"); // Create b3
        b4 = new JButton("Four"); // Create b4
        b5 = new JButton("Five"); // Create b5       
        pane.add(b1); // Add b1
        pane.add(b2); // Add b2
        pane.add(b3); // Add b3
        pane.add(b4); // Add b4
        pane.add(b5); // Add b5
    }
    public static void main(String[] args) { 
        MyLayout frame = new MyLayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("Button Layout Example"); // Set the title
        frame.setSize(300, 200); 
        frame.setVisible(true);
    }
}

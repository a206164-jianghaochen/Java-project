package driver;
	import javax.swing.*; 
	 import java.awt.*; 
	
	 public class TextField extends JFrame {
     private JLabel name, matric;
	 private JTextField textName, textMatric;
	
	 public TextField()
	 {
	 Container pane = getContentPane();
	 pane.setLayout(new GridLayout(2,1));
	
	
	 name = new JLabel("Name");
	 textName = new JTextField(20);
	 matric = new JLabel("Matric No");
	 textMatric = new JTextField(20);
	 pane.add(name);
	 pane.add(textName);
	 pane.add(matric);
	 pane.add(textMatric);
	 }
	
	 public static void main(String [] args) { 
	 TextField frame = new TextField();
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 frame.setTitle("Student Info");
	 frame.setSize(300, 100); 
	 frame.setVisible(true);
	 }
	 }


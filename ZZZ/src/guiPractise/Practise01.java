package guiPractise;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
public class Practise01 {
    public static void main(String[] args) {
    	 JFrame frame1 = new JFrame("fame example");
    	 frame1.setLayout(new GridLayout(3,2));
    	 frame1.setLocation(600,350);
    	 JPanel panel1 = new JPanel();
    	 JPanel panel2 = new JPanel();
    	 JPanel panel3 = new JPanel();
    	 JButton button1 = new JButton("button1");
    	 JButton button2 = new JButton("button2");
    	 JButton button3 = new JButton("button3");
    	 JButton button4 = new JButton("button4");
    	 JButton button5 = new JButton("button5");
    	 JButton button6 = new JButton("button6");
    	 JButton button7 = new JButton("button7");
    	 JButton button8 = new JButton("button8");
    	 JButton button9 = new JButton("button9");
    	 JButton button10 = new JButton("button10");   	 
    	 JButton button11 = new JButton("button11");
    	 JButton button12 = new JButton("button12");
    	 JButton button13 = new JButton("button13");
    	 JButton button14 = new JButton("button14");
    	 JButton button15 = new JButton("button15");
    	 JButton button16 = new JButton("button16");
    	 panel1.setLayout(new BorderLayout());
    	 panel2.setLayout(new GridLayout(2,3));
    	 panel3.setLayout(new GridLayout(4,5));
    	 frame1.add(panel1);
    	 frame1.add(panel2);
    	 frame1.add(panel3);
    	 panel1.add(button1, BorderLayout.WEST);
    	 panel1.add(button2, BorderLayout.EAST);
    	 panel1.add(button3, BorderLayout.SOUTH);
    	 panel1.add(button4, BorderLayout.NORTH);
    	 panel2.add(button5);
    	 panel2.add(button6);
    	 panel2.add(button7);
    	 panel2.add(button8);
    	 panel2.add(button9);
    	 panel2.add(button10);
    	 panel3.add(button11);
    	 panel3.add(button12);
    	 panel3.add(button13);
    	 panel3.add(button14);
    	 panel3.add(button15);	
    	 panel3.add(button16);
    	 frame1.setSize(500,300);
    	 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 frame1.setVisible(true);   
    	 button1.addActionListener(new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {  		
    			 JOptionPane.showMessageDialog(null, "button!");
    			 System.out.println("button1");
    		 }		 
    	 });
    	 button2.addActionListener(new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 NewForm nf = new NewForm();
    			 nf.setLocationRelativeTo(null);
    			 } 
    	 });	 
    }	 
} 
      class NewForm extends JFrame{
    	  public NewForm(){
    		  setLayout(null);
    		  setTitle("New application");
    		  setSize(300,200);
    		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		  setVisible(true); 
    		  JLabel lbl = new JLabel("Welcome to use the application");
    		  lbl.setBounds(0,0,300,20);
    		  add(lbl);
    		  JLabel userLabel = new JLabel("username:");
    		  userLabel.setBounds(30, 50, 80, 20);
    		  add(userLabel);
    		  JTextField userField = new JTextField();
    		  userField.setBounds(100, 52, 150, 20);
    		  add(userField);
    		  JLabel passwordLabel = new JLabel("password:");
    		  passwordLabel.setBounds(30, 80, 80, 20);
    		  add(passwordLabel);  
    		  JTextField passwordField = new JTextField();
    		  passwordField.setBounds(100, 82, 150, 20);
    		  add(passwordField);
    		  JButton loginButton = new JButton("Login");
    		  loginButton.setBounds(90, 120, 100, 25);
    		  add(loginButton);
    	  }  
      }
    	 class NewWindow extends JFrame{
    		 public NewWindow() {
    			 setLayout(null);
    			 setTitle("I wanna funk your mother");
    			 setSize(300,200);
    			 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       		     setVisible(true); 
       		  JLabel lbl = new JLabel("11111");
    			 
    			 
    			 
    			 
    		 }
    		 
    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    


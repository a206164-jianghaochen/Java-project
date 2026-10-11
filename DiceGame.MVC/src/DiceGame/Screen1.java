package DiceGame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Screen1 extends JFrame implements ActionListener {
	private JButton btnRoll = new JButton("Roll Dice");
	private DiceGame diceGame = new DiceGame();
	
	public Screen1() {		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("img/dice.jpg");
		JLabel diceImage = new JLabel(icon);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(diceImage);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(btnRoll);
		
		pane.add(panel1, BorderLayout.CENTER);
		pane.add(panel2, BorderLayout.SOUTH);
		
		btnRoll.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		diceGame.play();
		new Screen2(diceGame);
	}
	
	public static void main(String[] args) {
		Screen1 frame = new Screen1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("First screen");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}


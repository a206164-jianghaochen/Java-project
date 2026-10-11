package DiceGame;
import java.awt.*;
import javax.swing.*;

public class Screen2 extends JFrame {
	
	public Screen2(DiceGame diceGame) {
		setTitle("Second screen");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
	
		JTextField text1 = new JTextField("1st die:"+diceGame.getDie1().getFaceValue()+" 2nd die:"+diceGame.getDie2().getFaceValue());
		JTextField text2 = new JTextField(diceGame.getResult());
		
		pane.add(text1, BorderLayout.CENTER);
		pane.add(text2, BorderLayout.SOUTH);
	}
}
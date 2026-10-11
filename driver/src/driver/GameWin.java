package driver;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class GameWin extends JFrame{

	
	public void launch() {
		
		this.setVisible(true);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		this.setTitle("TanChiShe");
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.black);
		g.drawLine(0, 60, 600, 60);
		for(int i = 0; i <= 20; i++) {
			g.drawLine(0, i*30, 600, i*30);	
		}
		for(int i = 0; i <= 20; i++) {
			g.drawLine(i*30, 0 , i*30, 600);	
		}
	}
	
	
	public static void main(String[] args) {
		GameWin gameWin = new GameWin();
		gameWin.launch();
		
	}
}

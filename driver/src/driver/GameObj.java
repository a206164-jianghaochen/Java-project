package driver;

import java.awt.*;
public class GameObj {

	
	Image img;
	int x;
	int y;
	
	int width = 30;
	int height = 30;
	
	GameWin frame;
	
	public Image getImg() {		
		return img;
	}
	public void setImg(Image img) {
	this.img = img;
   }
	public int getHeight() {
		
		return height;
		
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public GameWin getFrame() {
		return frame;
	}
	public void setFrame(GameWin frame) {
		this.frame = frame;
		
	}
	public GameObj() {
	}
	
	public GameObj(Image img, int x, int y, int width, int height, GameWin frame) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
	}
	
	
	
	
	
	public void paintSelf(Graphics g) {
	g.drawImage(img,x,y, null);
	
	
	
}
}
	
	
	
	
	
	
	

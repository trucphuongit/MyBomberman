package Model;

import java.awt.Graphics; 
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Bomb extends Entity{
	public static final int BOMB_TIME = 100;
	public Bomb(Position position, int width, int height, EntityManager manager) {
		super(position, width, height, manager);
		image = new ImageIcon("image/bomb-1602109_640.png").getImage();
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), width, height, null);
	}


	
}

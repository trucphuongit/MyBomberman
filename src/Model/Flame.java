package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Flame extends Entity{
	public static final int FLAME_TIME = 100;
	public Flame(Position position, int width, int height, EntityManager manager) {
		super(position, width, height, manager);
		image = new ImageIcon("image/flamee.png").getImage();
	}




	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g ;
		g2.drawImage(image, position.getX(), position.getY(), width, height, null);
		
	}
	
	
}

package Model;

import java.awt.Graphics; 
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Monster extends MovealeObject{

	public Monster(Position position, int width, int height, EntityManager manager, Direction direction, int speed) {
		super(position, width, height, manager, direction, speed);
		image = new ImageIcon("image/monster.png").getImage();
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), width, height, null);
	}
	
	
	
}

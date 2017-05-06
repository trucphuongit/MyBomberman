package Model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends MovealeObject {
	private int maxBomb;
	private int numberOfBombWasCreated;
	public Player(Position position, int width, int height, EntityManager manager, Direction direction, int speed,
			int maxBomb, int numberOfBombWasCreated) {
		super(position, width, height, manager, direction, speed);
		this.maxBomb = maxBomb;
		this.numberOfBombWasCreated = numberOfBombWasCreated;
		this.image = new ImageIcon("image/player.png").getImage();
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		switch (this.direction) {
		case N:
			g2.drawImage(image, position.getX(), position.getY(), width, height, null);
			break;
		case S:
			g2.drawImage(new ImageIcon("image/playerUp.png").getImage(), position.getX(), position.getY(), width, height,null);
			break;
		case E:
			g2.drawImage(new ImageIcon("image/playerLeft.png").getImage(), position.getX(), position.getY(), width, height,null);
			break;
		case W:
			g2.drawImage(new ImageIcon("image/playerRight.png").getImage(), position.getX(), position.getY(), width, height,null);
			break;
		default:
			break;
		}
	}
	
}

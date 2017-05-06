package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

public class Player extends MovealeObject implements Observer{

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
			g2.drawImage(new ImageIcon("image/playerUp.png").getImage(), position.getX(), position.getY(), width,
					height, null);
			break;
		case S:
			g2.drawImage(image, position.getX(), position.getY(), width, height, null);
			break;
		case E:
			g2.drawImage(new ImageIcon("image/playerRight.png").getImage(), position.getX(), position.getY(), width,
					height, null);
			break;
		case W:
			g2.drawImage(new ImageIcon("image/playerLeft.png").getImage(), position.getX(), position.getY(), width,
					height, null);
			break;
		default:
			break;
		}
	}

	@Override
	public void move() {
		switch (this.direction) {
		case N:
			this.position.decreateY(this.speed);
			break;
		case S:
			this.position.increateY(this.speed);
			break;
		case E:
			this.position.increateX(this.speed);
			break;
		case W:
			this.position.decreateX(this.speed);
			break;
		default:
			break;
		}
	}

	@Override
	public void startMove() {

	}

	@Override
	public void stopMove() {
	}

	public void putBoom() {
		if (numberOfBombWasCreated < maxBomb) {
			Bomb bomb = new Bomb(new Position(this.position.getX(), this.position.getY()), 50, 50, manager);
			manager.addEntity(bomb);
			
			((Observable) bomb).addObserver(this);
			numberOfBombWasCreated++;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		numberOfBombWasCreated--;
	}

}

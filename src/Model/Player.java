package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

public class Player extends MovealeObject implements Observer {

	private int maxBomb;
	private int numberOfBombWasCreated;

	public Player(Position position, EntityManager manager, Direction direction, int speed, int maxBomb,
			int numberOfBombWasCreated) {
		super(position, manager, direction, speed);
		this.maxBomb = maxBomb;
		this.numberOfBombWasCreated = numberOfBombWasCreated;
		this.image = new ImageIcon("image/player.png").getImage();
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		switch (this.direction) {
		case N:
			g2.drawImage(new ImageIcon("image/playerUp.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
			break;
		case S:
			g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);
			break;
		case E:
			g2.drawImage(new ImageIcon("image/playerRight.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
			break;
		case W:
			g2.drawImage(new ImageIcon("image/playerLeft.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
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
		switch (this.direction) {
		case N:
			this.position.decreateY(0);
			break;
		case S:
			this.position.increateY(0);
			break;
		case E:
			this.position.increateX(0);
			break;
		case W:
			this.position.decreateX(0);
			break;
		default:
			break;
		}
		;
	}

	public void putBoom() {
		if (numberOfBombWasCreated < maxBomb) {
			Bomb bomb = new Bomb(new Position(this.position.getX(), this.position.getY()), manager);
			manager.addEntity(bomb);

			((Observable) bomb).addObserver(this);
			numberOfBombWasCreated++;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		numberOfBombWasCreated--;
	}

	@Override
	public void collisionable() {
		// TODO Auto-generated method stub

	}

	
}

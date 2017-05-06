package model;

import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class Monster extends MovealeObject implements Runnable{
	private Thread thread;
	public Monster(Position position, int width, int height, EntityManager manager, Direction direction, int speed) {
		super(position, width, height, manager, direction, speed);
		image = new ImageIcon("image/monster.png").getImage();
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), width, height, null);
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
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void stopMove() {
		if(thread != null){
			thread.stop();
			thread = null;
		}
	}

	@Override
	public void run() {
		Random r = new Random();
		int times = 0;
		while(true){
			move();
			setDirection(Direction.values()[r.nextInt(4)]);
			manager.notifyChanged();
			times++;
			if(times==10){
				this.setSpeed(this.speed *2);
				times = 0;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}

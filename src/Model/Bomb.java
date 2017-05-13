package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Bomb extends Entity implements Runnable {
	public static final int BOMB_TIME = 3000;

	public Bomb(Position position, EntityManager manager) {
		super(position, manager);
		image = new ImageIcon("image/bomb-1602109_640.png").getImage();
		new Thread(this).start();
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(BOMB_TIME);
			int x = this.position.getX();
			int y = this.position.getY();
			List<Entity> listFlame = new ArrayList<>();
			for (int i = x - 150; i < x + 150; i += 50) {
				listFlame.add(new Flame(new Position(i, y), manager));
			}
			for (int i = y - 150; i < y + 150; i += 50) {
				listFlame.add(new Flame(new Position(x, i), manager));
			}
			// add list flame vao sau khi bomb no
			manager.addEntity(listFlame);
			Thread.sleep(100);
			manager.removeEntity(this);
			setChanged();
			notifyObservers();

			Thread.sleep(2000);
			// delete list flame
			manager.removeEntity(listFlame);
			setChanged();
			notifyObservers();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}

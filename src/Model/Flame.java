package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Flame extends Entity {
	public static final int FLAME_TIME = 100;

	public Flame(Position position, EntityManager manager) {
		super(position, manager);
		image = new ImageIcon("image/flamee.png").getImage();
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);

	}

	public void isCollision() {

		// if (this.getBounds().intersects(manager.getPlayer().getBounds())) {
		// manager.getPlayer().die();
		// manager.removeEntity(manager.getPlayer());
		//
		// }
		// for (Monster m : manager.getMonsters()) {
		// if (this.getBounds().intersects(m.getBounds())) {
		// manager.removeEntity(m);
		// }
		// }

		for (Entity en : manager.getList()) {
			if (en instanceof Brick) {
				Brick b = (Brick) en;
				if (this.getBounds().intersects(b.getBounds())) {
					manager.removeEntity(b);
				}
			}
			if (en instanceof Monster) {
				Monster m = (Monster) en;
				if (this.getBounds().intersects(m.getBounds())) {
					manager.removeEntity(m);
				}
			}
			if (this.getBounds().intersects(manager.getPlayer().getBounds())) {
				manager.removePlayer(manager.getPlayer());
			}
		}
		setChanged();
		notifyObservers();
	}

}

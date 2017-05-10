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

	@Override
	public void collisionable() {
		for (Entity entity : manager.getList()) {
			if (entity instanceof Brick) {
				Brick b = (Brick) entity;
				if (this.getBounds().intersects(b.getBounds())) {
					manager.removeEntity(b);
				}
			} else if (entity instanceof Monster) {
				Monster m = (Monster) entity;
				if (this.getBounds().intersects(m.getBounds())) {
					manager.removeEntity(m);
				}
//			} else if (entity instanceof Wall) {
//				Wall w = (Wall) entity;
//				if (this.getBounds().intersects(w.getBounds())) {
//					manager.removeEntity(this);
//				}

			} else if (entity instanceof Player) {
				Player p = (Player) entity;
				if (this.getBounds().intersects(p.getBounds())) {
					manager.getPlayer().stopMove();
					manager.removeEntity(p);

				}
			}
			setChanged();
			notifyObservers();
		}
	}
}

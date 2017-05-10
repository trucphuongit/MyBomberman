package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Observable;

public abstract class Entity extends Observable {
	protected Position position;
	protected static final int WIDTH = 50;
	protected static final int HEIGHT = 50;
	protected EntityManager manager;
	protected Image image;

	public Entity(Position position, EntityManager manager) {
		super();
		this.position = position;
		this.manager = manager;
	}

	public Entity() {
	}

	public boolean toBeKilled() {
		return true;
	}

	public abstract void draw(Graphics g);

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.position.getX(), this.position.getY(), WIDTH, HEIGHT);
	}

	public boolean collision(Entity other) {
		return this.getBounds().intersects(other.getBounds());
	}

	public abstract void collisionable();
}

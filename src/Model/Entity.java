package model;

import java.awt.Graphics; 
import java.awt.Image;
import java.util.Observable;

public abstract class Entity extends Observable{
	protected  Position position;
	protected int width;
	protected int height;
	protected EntityManager manager;
	protected Image image;
	
	
	
	public Entity(Position position, int width, int height, EntityManager manager) {
		super();
		this.position = position;
		this.width = width;
		this.height = height;
		this.manager = manager;
	}
	


	public Entity() {
	}



	public boolean toBeKilled() {
		return true;
	}
	public abstract void draw(Graphics g) ;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	
}

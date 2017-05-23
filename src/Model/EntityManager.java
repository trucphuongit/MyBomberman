package model;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

public class EntityManager extends Observable {
	private List<Entity> list;
	private Player player;

	public EntityManager() {
		player = new Player(new Position(50, 50), this, Direction.N, 50, 5, 0);
		this.list = new Vector<>();
		list.add(new Wall(new Position(0, 0), this));
		list.add(new Wall(new Position(0, 50), this));
		list.add(new Wall(new Position(0, 100), this));
		list.add(new Wall(new Position(0, 150), this));
		list.add(new Wall(new Position(0, 200), this));
		list.add(new Wall(new Position(0, 250), this));
		list.add(new Brick(new Position(350, 350), this));
		list.add(new Brick(new Position(400, 350), this));
		list.add(new Brick(new Position(450, 350), this));
		list.add(new Brick(new Position(450, 350), this));
		list.add(new Monster(new Position(550, 350), this, Direction.N, 30));

	}

	public synchronized void addEntity(List<Entity> list) {
		this.list.addAll(list);
		notifyChanged();
	}

	public synchronized void addEntity(Entity e) {
		this.list.add(e);
		notifyChanged();
	}

	public void removeEntity(Entity e) {
		this.list.remove(e);
		notifyChanged();
	}

	public void removeEntity(List<Entity> list) {
		this.list.removeAll(list);
		notifyChanged();
	}

	public void removePlayer(Player player) {
		this.deleteObserver(player);
		notifyChanged();
	}

	public List<Entity> getEntityFromBound(Rectangle getbound) {
		List<Entity> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBounds().equals(getbound)) {
				res.add(list.get(i));
			}
		}
		if (player.getBounds().equals(getbound)) {
			res.add(player);
		}
		return res;
	}

	public void draw(Graphics g) {
		player.draw(g);

		Iterator<Entity> itr = list.iterator();
		while (itr.hasNext()) {
			Entity e = itr.next();
			e.draw(g);
		}
	}

	public int size() {
		return list.size();
	}

	public synchronized void collisionable() {
		List<Entity> listCollision = new Vector<>();
		for (Entity entity : list) {
			listCollision.addAll(entity.getCollision());
		}
		listCollision.addAll(player.getCollision());
		list.removeAll(listCollision);

	}

	public void move(Direction direction) {
		player.setDirection(direction);
		player.move();
		notifyChanged();
		System.out.println(player.position.getX() + "  " + player.position.getY());
	}

	public void putBoom() {
		player.putBoom();
	}

	// start những thằng tự động di chuyển.
	public void startMoveableObject() {
		Iterator<Entity> itr = list.iterator();
		while (itr.hasNext()) {
			Entity entity = itr.next();
			if (entity instanceof MovealeObject)
				((MovealeObject) entity).startMove();
		}
	}

	

	public void notifyChanged() {
		setChanged();
		notifyObservers();
	}

	public List<Entity> getList() {
		return list;
	}

	public List<Entity> getBoundsList(Entity entity) {
		List<Entity> list = new Vector<>();
		Iterator<Entity> itr = this.list.iterator();
		while (itr.hasNext()) {
			Entity e = itr.next();
			if (e.getBounds().intersects(entity.getBounds())) {
				list.add(e);
			}
		}
		if (this.player.getBounds().intersects(entity.getBounds()))
			list.add(player);
		return list;

	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	// public void gameOverSystem(){
	// this.
	// }
}

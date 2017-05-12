package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class EntityManager extends Observable {
	private List<Entity> list;
	private Player player;
	// private ArrayList<Monster> monsters;

	public EntityManager() {
		player = new Player(new Position(50, 40), this, Direction.N, 50, 5, 0);
		this.list = new ArrayList<>();
		list.add(new Wall());
		list.add(new Brick(new Position(360, 360), this));
		list.add(new Brick(new Position(400, 360), this));
		list.add(new Brick(new Position(440, 360), this));
		list.add(new Brick(new Position(480, 360), this));
		list.add(new Monster(new Position(530, 360), this, Direction.N, 30));
		// monsters = new ArrayList<Monster>();
		// monsters.add(new Monster(new Position(530, 360), this, Direction.N,
		// 50));

	}

	public void addEntity(List<Entity> list) {
		this.list.addAll(list);
		notifyChanged();
	}

	public void addEntity(Entity e) {
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

	public Entity getEntityFromPosition(Position position) {
		Entity res = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPosition().equals(position)) {
				res = list.get(i);
			}
		}
		if (player.getPosition().equals(position)) {
			res = player;
		}
		return res;

	}

	public void draw(Graphics g) {
		player.draw(g);
		for (Entity entity : list) {
			entity.draw(g);
		}
		// for (Monster monster : monsters) {
		// monster.draw(g);
		// }
	}

	public int size() {
		return list.size();
	}

	public void collisionable() {
		for (Entity entity : list) {
			entity.isCollision();
		}
		player.isCollision();

	}

	public void move(Direction direction) {
		player.setDirection(direction);
		player.move();
		// for (Monster monster : monsters) {
		// monster.move();
		// }
		notifyChanged();
	}

	public void putBoom() {
		player.putBoom();
	}

	public void startMoveableObject() {
		for (Entity entity : list) {
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

	public void setList(List<Entity> list) {
		this.list = list;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// public ArrayList<Monster> getMonsters() {
	// return monsters;
	// }

	// public void setMonsters(ArrayList<Monster> monsters) {
	// this.monsters = monsters;
	// }

}

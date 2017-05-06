package Model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityManager {
	private List<Entity> list ;

	public EntityManager() {
		this.list = new ArrayList<>();
		list.add(new Wall());
		list.add(new Bomb(new Position(50, 200), 50, 40, this));
		list.add(new Player(new Position(50, 50), 50, 40, this, Direction.N, 5, 5, 0));
		list.add(new Brick(new Position(360, 360), 50, 40, this));
		list.add(new Brick(new Position(400, 360), 50, 40, this));
		list.add(new Brick(new Position(440, 360), 50, 40, this));
		list.add(new Brick(new Position(480, 360), 50, 40, this));
		
	}
	public void addEntity(Entity e) {
		this.list.add(e);
	}
	
	
	public Entity getEntityFromPosition(Position position) {
		Entity res = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPosition().equals(position)) {
				res = list.get(i);
						
			}
		}
		return res;
	}
	public void draw(Graphics g) {
		for (Entity entity : list) {
			entity.draw(g);
		}
	}
	public int size() {
		return list.size();
	}
}	

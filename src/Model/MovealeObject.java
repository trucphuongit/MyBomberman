package Model;

import java.awt.Graphics; 

public abstract class MovealeObject extends Entity {
	protected Direction direction;
	protected int speed;
	public MovealeObject(Position position, int width, int height, EntityManager manager, Direction direction,
			int speed) {
		super(position, width, height, manager);
		this.direction = direction;
		this.speed = speed;
		image = null;
	}
	public  abstract void draw(Graphics g) ;	
		
		
	
	
}

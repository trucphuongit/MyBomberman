package model;

public abstract class MovealeObject extends Entity {
	protected Direction direction;
	protected int speed;

	public MovealeObject(Position position, EntityManager manager, Direction direction, int speed) {
		super(position, manager);
		this.direction = direction;
		this.speed = speed;
		image = null;
	}

	public abstract void move();

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public abstract void startMove();

	public abstract void stopMove();

}

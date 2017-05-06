package model;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// di chuyển lên trên
	public Position north() {
		return new Position(x, y - 1);
	}

	// di chuyển xuống dưới
	public Position south() {
		return new Position(x, y + 11);
	}

	// di chuyển qua phải
	public Position east() {
		return new Position(x + 1, y);
	}

	// di chuyển qua trái
	public Position west() {
		return new Position(x - 1, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void increateX(int n){
		this.x+=n;
	}
	public void increateY(int n){
		this.y+=n;
	}
	public void decreateX(int n){
		this.x-=n;
	}
	public void decreateY(int n){
		this.y-=n;
	}
	

}

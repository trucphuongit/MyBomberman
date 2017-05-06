package model;

import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Bomb extends Entity implements Runnable{
	public static final int BOMB_TIME = 3000;
	public Bomb(Position position, int width, int height, EntityManager manager) {
		super(position, width, height, manager);
		image = new ImageIcon("image/bomb-1602109_640.png").getImage();
		new Thread(this).start();
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), width, height, null);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(BOMB_TIME);
			int x = this.position.getX();
			int y = this.position.getY();
			List<Entity> listFlame = new ArrayList<>();
			for (int i = x - 150; i < x + 150; i+=50) {
				listFlame.add(new Flame(new Position(i, y),50 ,50,manager));
			}
			for (int i = y - 150; i < y + 150; i+=50) {
				listFlame.add(new Flame(new Position(x, i),50 ,50,manager));
			}
			manager.addEntity(listFlame);
			manager.removeEntity(this);
			
			setChanged();
			notifyObservers();
			
			Thread.sleep(2000);
			manager.removeEntity(listFlame);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
}

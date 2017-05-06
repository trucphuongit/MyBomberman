package View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.EntityManager;

public class Map extends JPanel{
	EntityManager manager;
	
	 
	public Map(EntityManager manager) {
		super();
		this.manager = manager;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		manager.draw(g);
	}
	 public static void main(String[] args) {
		 EntityManager manager = new EntityManager();
		 Map map = new Map(manager);
		 map.setBackground(Color.WHITE);
		JFrame fr = new JFrame();
		fr.add(map);
//		fr.setBackground(Color.WHITE);
		fr.setSize(800, 590);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}
}

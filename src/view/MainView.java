package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;
import model.EntityManager;

public class MainView extends JFrame implements Observer{
	EntityManager entityManger;
	GameController gameController;
	JPanel mainContent;
	
	public MainView(EntityManager entityManager, GameController gameController) {
		super();
		this.entityManger = entityManager;
		this.gameController = gameController;
		((Observable) entityManager).addObserver(this);
		
		mainContent = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				entityManger.draw(g);
			}
		};
		
		mainContent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				gameController.keyRelease(e.getKeyCode());
			}
		});
		
		
		mainContent.setFocusable(true);
		
		getContentPane().add(mainContent, BorderLayout.CENTER);
		
		this.setSize(800, 590);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		gameController.start();
	}
	
	public void initView(){
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		mainContent.repaint();
	}
}

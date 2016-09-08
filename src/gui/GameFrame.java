package gui;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	private GamePanel gameFrame;
	
	public GameFrame() {
		super("Tetris");
		
		gameFrame = new GamePanel();
		add(gameFrame);
		addKeyListener(new KeyInputListener());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameFrame();
		
	}
	
}

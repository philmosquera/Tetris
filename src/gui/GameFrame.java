package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameLogic.GameLoop;

public class GameFrame extends JFrame {

	private GamePanel gamePanel;

	public GameFrame() {
		super("Tetris");

		gamePanel = new GamePanel();
		add(gamePanel);
		addKeyListener(new KeyInputListener());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

}

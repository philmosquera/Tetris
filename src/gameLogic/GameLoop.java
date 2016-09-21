package gameLogic;

import board.GameBoard;
import gui.GameFrame;
import gui.GamePanel;

public class GameLoop implements Runnable {

	private static GamePanel gamePanel;
	private boolean isRunning = false;
	private GameBoard gameBoard = GameBoard.getInstance();
	private static Thread gameThread;

	public GameLoop() {
	}

	public void start() {
		isRunning = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void stop() {
		isRunning = false;
		gameThread.interrupt();
	}
	
	public static void interruptLock() {
		gameThread.interrupt();
	}

	@Override
	public void run() {
		sleep(1000);
		while (isRunning) {
			long currentTime = System.currentTimeMillis();
			// game logic
			// move piece down 1 square
			// redraw everything
			gameBoard.movePieceDown();
			gamePanel.repaint();
			sleep(1000);
		}

	}

	private void sleep(long timeToSleep) {
		try {
			Thread.sleep(timeToSleep);
		} catch (InterruptedException e) {
			sleep(timeToSleep);
		}
	}

	public static void main(String[] args) {
		GameFrame mainFrame = new GameFrame();
		gamePanel = mainFrame.getGamePanel();
		new GameLoop().start();
	}
}

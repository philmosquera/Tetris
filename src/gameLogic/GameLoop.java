package gameLogic;
import gui.GameFrame;
import gui.GamePanel;

public class GameLoop implements Runnable {

	private static GamePanel gamePanel;
	private boolean isRunning = false;
	private GameBoard gameBoard = new GameBoard();
	private Thread gameThread;

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

	@Override
	public void run() {

		while (isRunning) {
			long currentTime = System.currentTimeMillis();
			System.out.println("Loop");
			// game logic
			// move piece down 1 square
			// redraw everything
			gamePanel.repaint();
			sleep(1000);
		}

	}

	private void sleep(long timeToSleep) {
		try {
			Thread.sleep(timeToSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GameFrame mainFrame = new GameFrame();
		gamePanel = mainFrame.getGamePanel();
		new GameLoop().start();
	}
}

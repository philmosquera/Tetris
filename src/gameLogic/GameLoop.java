package gameLogic;
import board.Tile;

public class GameLoop implements Runnable {

	private boolean isRunning = false;
	private GameBoard gameBoard = new GameBoard();
	private Thread gameThread;

	public GameLoop() {
	}

	public void start() {
		isRunning = true;
		gameThread = new Thread(this);
	}

	public void stop() {
		isRunning = false;
		gameThread.interrupt();
	}

	@Override
	public void run() {

		while (isRunning) {
			long currentTime = System.currentTimeMillis();
			// game logic

			// move piece down 1 square
			// redraw everything

			sleep(250);
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
}

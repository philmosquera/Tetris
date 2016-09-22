package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import board.GameBoard;
import gameLogic.GameLoop;

public class KeyInputListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 32:
			// GameBoard.getInstance().dropPiece();
		case 37:
			GameBoard.getInstance().movePieceLeft();
			if (GameBoard.getInstance().isPieceGrounded()) {
				GameLoop.interruptLock();
			}
			GamePanel.getInstance().repaint();
			break;
		case 38:
			break;
		case 39:
			GameBoard.getInstance().movePieceRight();
			if (GameBoard.getInstance().isPieceGrounded()) {
				GameLoop.interruptLock();
			}
			GamePanel.getInstance().repaint();
			break;
		case 40:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

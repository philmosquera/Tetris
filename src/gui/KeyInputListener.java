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
			if (GameBoard.getInstance().isPieceGrounded() && GameBoard.getInstance().movePieceLeft()) {
				GameLoop.interruptLock();
			}
			GamePanel.getInstance().repaint();
			break;
		case 38:
			break;
		case 39:
			if (GameBoard.getInstance().isPieceGrounded() && GameBoard.getInstance().movePieceRight()) {
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

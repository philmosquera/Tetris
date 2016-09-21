package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import board.GameBoard;

public class KeyInputListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			GameBoard.getInstance().movePieceLeft();
			GamePanel.getInstance().repaint();
			break;
		case 38:
			break;
		case 39:
			GameBoard.getInstance().movePieceRight();
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

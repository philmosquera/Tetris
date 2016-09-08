package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode() + "," + e.getKeyCode());
		switch (e.getKeyCode()) {
		case 37:
			System.out.println("left");
			break;
		case 38:
			System.out.println("up");
			break;
		case 39:
			System.out.println("right");
			break;
		case 40:
			System.out.println("down");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

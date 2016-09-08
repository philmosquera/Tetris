package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import board.Tile;

public class GamePanel extends JPanel {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 600;
	private static int scale = 30;

	private static Tile[][] gameBoard = new Tile[10][20];
	static {
		for (int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				gameBoard[x][y] = new Tile();
			}
		}
	}
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				g.setColor(gameBoard[x][y].getCurrentColor());
				g.fillRect(x * scale, y * scale, scale, scale);
				g.setColor(Color.BLACK);
				g.drawRect(x * scale, y * scale, scale, scale);
			}
		}
	}

}

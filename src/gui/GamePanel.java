package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import board.Tile;
import gameLogic.GameBoard;
import pieces.ActivePiece;

public class GamePanel extends JPanel {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 700;
	private static int scale = 30;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		Tile[][] gameBoard = GameBoard.getBoard();

		drawBoard(g, gameBoard);
		drawPiece(g);
		drawGrid(g, gameBoard);

	}

	private void drawGrid(Graphics g, Tile[][] gameBoard) {
		for (int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				g.setColor(Color.BLACK);
				g.drawRect(x * scale, (y-2) * scale, scale, scale);
			}
		}
	}

	private void drawBoard(Graphics g, Tile[][] gameBoard) {
		for (int x = 0; x < gameBoard.length; x++) {
			for (int y = 0; y < gameBoard[x].length; y++) {
				g.setColor(gameBoard[x][y].getCurrentColor());
				g.fillRect(x * scale, (y-2) * scale, scale, scale);
			}
		}
	}

	private void drawPiece(Graphics g) {
		ActivePiece currentPiece = GameBoard.getActivePiece();
		g.setColor(currentPiece.getColor());
		for (Point point : currentPiece.getSquares()) {
			g.fillRect(((int) point.getX()) * scale, ((int) point.getY() - 2) * scale, scale, scale);
		}
	}

}

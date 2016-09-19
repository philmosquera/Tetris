package pieces;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Vector;

public class ActivePiece {

	private Vector<Point> squares = new Vector<Point>(4);
	private Color pieceColor;

	protected ActivePiece(int nextPiece) {

		Random myRandom = new Random();
		switch (myRandom.nextInt(3)) {
		case 0:
			pieceColor = Color.GREEN;
			break;
		case 1:
			pieceColor = Color.BLUE;
			break;
		default:
			pieceColor = Color.RED;
			break;
		}
		squares.add(new Point(5, 10));

	}

	public Vector<Point> getSquares() {
		return squares;
	}

	public Color getColor() {
		return pieceColor;
	}

	public void moveDown() {
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).y += 1;
		}
	}

	public void moveLeft() {
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).x -= 1;
		}
	}

	public void moveRight() {
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).x += 1;
		}
	}
}

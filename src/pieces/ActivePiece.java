package pieces;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Vector;

public class ActivePiece {

	private Vector<Point> squares = new Vector<Point>(4);
	private Color pieceColor = Color.red;

	protected ActivePiece(int nextPiece) {

		squares.add(new Point(5, 10));

	}

	public Vector<Point> getSquares() {
		return squares;
	}

	public Color getColor() {
		return pieceColor;
	}
}

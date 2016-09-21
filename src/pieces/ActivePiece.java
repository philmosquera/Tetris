package pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class ActivePiece {

	private Vector<Point> squares = new Vector<Point>(4);
	private Color pieceColor;

	protected ActivePiece(int nextPiece) {
		nextPiece = 0;

		switch (nextPiece) {
		case 0:
			pieceColor = Color.CYAN;
			squares.addAll(PieceCoordinates.getIPiece());
			break;
		case 1:
			pieceColor = Color.YELLOW;
			break;
		case 2:
			pieceColor = Color.PINK;
			break;
		case 3:
			pieceColor = Color.GREEN;
			break;
		case 4:
			pieceColor = Color.RED;
			break;
		case 5:
			pieceColor = Color.BLUE;
			break;
		case 6:
			pieceColor = Color.ORANGE;
			break;
		}
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

	public TreeSet<Integer> getYCoordinates() {
		TreeSet<Integer> coords = new TreeSet<Integer>();
		
		for (Point point : squares) {
			coords.add((int) point.getY());
		}
		return coords;
	}
}

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
	private int currentPieceType;

	protected ActivePiece(int nextPiece) {
		currentPieceType = nextPiece;

		switch (nextPiece) {
		case 0:
			pieceColor = Color.CYAN;
			squares.addAll(PieceCoordinates.getIPiece());
			break;
		case 1:
			pieceColor = Color.YELLOW;
			squares.addAll(PieceCoordinates.getOPiece());
			break;
		case 2:
			pieceColor = Color.PINK;
			squares.addAll(PieceCoordinates.getTPiece());
			break;
		case 3:
			pieceColor = Color.GREEN;
			squares.addAll(PieceCoordinates.getSPiece());
			break;
		case 4:
			pieceColor = Color.RED;
			squares.addAll(PieceCoordinates.getZPiece());
			break;
		case 5:
			pieceColor = Color.BLUE;
			squares.addAll(PieceCoordinates.getJPiece());
			break;
		case 6:
			pieceColor = Color.ORANGE;
			squares.addAll(PieceCoordinates.getLPiece());
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

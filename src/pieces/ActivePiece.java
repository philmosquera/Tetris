package pieces;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Vector;

public class ActivePiece {

	private Vector<Point2D> squares = new Vector<Point2D>(4);
	private Color pieceColor = Color.red;


	protected ActivePiece(int nextPiece) {
	}

}

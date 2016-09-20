package pieces;

import java.awt.Point;
import java.util.Collection;
import java.util.Vector;

public class PieceCoordinates {

	public static Collection<? extends Point> getIPiece() {
		Vector<Point> points = new Vector<>(4);
		points.add(new Point(5,2));
		points.add(new Point(5,3));
		points.add(new Point(5,4));
		points.add(new Point(5,5));
		// TODO Auto-generated method stub
		return points;
	}

}

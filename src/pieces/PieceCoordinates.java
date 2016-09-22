package pieces;

import java.awt.Point;
import java.util.Collection;
import java.util.Vector;

public class PieceCoordinates {

	public static Collection<? extends Point> getIPiece() {
		Vector<Point> points = new Vector<>(4);
		points.add(new Point(3, 2));
		points.add(new Point(4, 2));
		points.add(new Point(5, 2));
		points.add(new Point(6, 2));
		
		return points;
	}

	public static Collection<? extends Point> getJPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(5, 1));
		points.add(new Point(4, 1));
		points.add(new Point(3, 1));
		points.add(new Point(3, 0));
		
		return points;
	}
	
	public static Collection<? extends Point> getLPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(5, 1));
		points.add(new Point(4, 1));
		points.add(new Point(3, 1));
		points.add(new Point(5, 0));
		
		return points;
	}
	
	public static Collection<? extends Point> getOPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(4, 1));
		points.add(new Point(5, 1));
		points.add(new Point(4, 0));
		points.add(new Point(5, 0));
		
		return points;
	}
	
	public static Collection<? extends Point> getSPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(4, 0));
		points.add(new Point(4, 1));
		points.add(new Point(5, 0));
		points.add(new Point(3, 1));
		
		return points;
	}
	
	public static Collection<? extends Point> getTPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(4, 1));
		points.add(new Point(4, 0));
		points.add(new Point(3, 1));
		points.add(new Point(5, 1));
		
		return points;
	}
	
	public static Collection<? extends Point> getZPiece() {
		Vector<Point> points = new Vector<>();
		points.add(new Point(4, 1));
		points.add(new Point(4, 0));
		points.add(new Point(3, 0));
		points.add(new Point(5, 1));
		
		return points;
	}
}

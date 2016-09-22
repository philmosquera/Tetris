package board;

import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import pieces.ActivePiece;
import pieces.PiecePicker;

public class GameBoard {

	private static Tile[][] board = new Tile[10][22];
	private static ActivePiece currentPiece;
	private PiecePicker piecePicker;

	private static GameBoard instance;

	private GameBoard() {
		resetBoard();
	}

	public static GameBoard getInstance() {
		if (instance == null) {
			instance = new GameBoard();
		}
		return instance;
	}

	public void resetBoard() {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				board[x][y] = new Tile();
			}
		}

		piecePicker = new PiecePicker();
		currentPiece = piecePicker.getNextPiece();
	}

	// move piece down 1
	public void movePieceDown() {

		Vector<Point> points = currentPiece.getSquares();
		boolean canMoveDown = true;
		for (Point point : points) {
			try {
				if (board[point.x][point.y + 1].getStatus() == Status.OCCUPIED) {
					canMoveDown = false;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				canMoveDown = false;
			}
		}

		if (canMoveDown)
			currentPiece.moveDown();
		else {
			turnPieceIntoBoard();
			currentPiece = piecePicker.getNextPiece();
		}

	}

	private void turnPieceIntoBoard() {
		Vector<Point> points = currentPiece.getSquares();
		for (Point point : points) {
			board[point.x][point.y].setStatus(Status.OCCUPIED);
			board[point.x][point.y].setCurrentColor(currentPiece.getColor());
		}
		checkForClear();
	}

	public void movePieceLeft() {
		Vector<Point> points = currentPiece.getSquares();
		boolean canMove = true;
		for (Point point : points) {
			// this if shouldn't through an ArrayIndexOutOfBounds due to the
			// order of evaluation
			if (point.x - 1 < 0 || board[point.x - 1][point.y].getStatus() == Status.OCCUPIED) {
				canMove = false;
				break;
			}
		}

		if (canMove)
			currentPiece.moveLeft();
	}

	public void movePieceRight() {
		Vector<Point> points = currentPiece.getSquares();
		boolean canMove = true;
		for (Point point : points) {
			// this if shouldn't through an ArrayIndexOutOfBounds due to the
			// order of evaluation
			if (point.x + 1 > 9 || board[point.x + 1][point.y].getStatus() == Status.OCCUPIED) {
				canMove = false;
				break;
			}
		}

		if (canMove)
			currentPiece.moveRight();
	}

	public static Tile[][] getBoard() {
		return board;
	}

	public static ActivePiece getActivePiece() {
		return currentPiece;
	}

	/*
	 * Can optimise this to only check the lines where the piece was. Also need
	 * to check for multiple lines.
	 */
	private void checkForClear() {
		int numOfOccupied, numOfFree;
		TreeSet<Integer> linesToCheck = currentPiece.getYCoordinates();
		Vector<Integer> linesToClear = new Vector<Integer>();

		for (Iterator<Integer> iterator = linesToCheck.descendingIterator(); iterator.hasNext();) {
			Integer y = (Integer) iterator.next();
			numOfOccupied = 0;
			numOfFree = 0;
			for (int x = 0; x < board.length; x++) {
				if (board[x][y].getStatus() == Status.OCCUPIED)
					numOfOccupied++;
				if (board[x][y].getStatus() == Status.FREE)
					numOfFree++;
			}
			// System.out.printf("Line %d has %d free and %d occupied\n", y,
			// numOfFree, numOfOccupied);
			if (numOfOccupied == 10)
				linesToClear.add(y);
			if (numOfFree == 10)
				break;
		}

		// the lines to clear are now calculated. Lines are ordered with highest
		// first.
		Collections.reverse(linesToClear);

		// clear the lines
		for (Integer yCoord : linesToClear) {
			for (int x = 0; x < board.length; x++) {
				for (int y = yCoord; y > 0; y--) {
					board[x][y].setStatus(board[x][y - 1].getStatus());
				}
			}
		}

	}

	public boolean isPieceGrounded() {
		Vector<Point> points = currentPiece.getSquares();
		for (Point point : points) {
			try {
				if (board[point.x][point.y + 1].getStatus() == Status.OCCUPIED) {
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return true;
			}
		}
		return false;
	}
}

package gameLogic;

import java.awt.Point;
import java.util.Vector;

import board.Status;
import board.Tile;
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
				if (board[(int) point.getX()][(int) (point.getY() + 1)].getStatus() == Status.OCCUPIED) {
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
			board[(int) point.getX()][(int) point.getY()].setStatus(Status.OCCUPIED);
			board[(int) point.getX()][(int) point.getY()].setCurrentColor(currentPiece.getColor());
		}
	}

	public void movePieceLeft() {
		Vector<Point> points = currentPiece.getSquares();
		boolean canMove = true;
		for (Point point : points) {
			if (point.getX() - 1 < 0) {
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
			if (point.getX() + 1 > 9) {
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
}

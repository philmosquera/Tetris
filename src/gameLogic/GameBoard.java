package gameLogic;
import board.Tile;
import pieces.ActivePiece;
import pieces.PiecePicker;

public class GameBoard {

	private static Tile[][] board = new Tile[10][22];
	private static ActivePiece currentPiece;
	private PiecePicker piecePicker;

	public GameBoard() {
		resetBoard();
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

	//move piece down 1
	public void dropPiece() {
		currentPiece.moveDown();
	}
	
	public static Tile[][] getBoard() {
		return board;
	}
	
	public static ActivePiece getActivePiece() {
		return currentPiece;
	}
}

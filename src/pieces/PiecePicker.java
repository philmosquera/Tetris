package pieces;

import java.util.Random;
import java.util.Vector;

public class PiecePicker {

	private static Vector<Integer> listOfPieces;

	public PiecePicker() {
		listOfPieces = new Vector<Integer>(7);
		reinstatiateList();
	}

	private void reinstatiateList() {
		for (int i = 0; i < 7; i++) {
			listOfPieces.add(new Integer(i));
		}
	}

	public ActivePiece getNextPiece() {

		if (listOfPieces.size() == 0) {
			reinstatiateList();
		}
		System.out.println(listOfPieces.toString());
		Random myRandom = new Random(System.currentTimeMillis());
		int nextIndex = myRandom.nextInt(listOfPieces.size());

		ActivePiece returnPiece = new ActivePiece(listOfPieces.get(nextIndex));
		listOfPieces.remove(nextIndex);
		return returnPiece;
	}
}

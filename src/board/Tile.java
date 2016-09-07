package board;

import java.awt.Color;

public class Tile {

	private Status status = Status.FREE;

	private Color currentColor = Color.WHITE;

	public Tile() {

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status newStatus) {
		if (newStatus == Status.FREE)
			this.currentColor = Color.WHITE;
		this.status = newStatus;
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
}

package ba.bitcamp.ludogame;

import java.awt.Color;

import javax.swing.JLabel;

public class Player {

	private Color main;
	private Color other;
	private Color white;

	private int x;
	private int y;

	private int tempMove;
	private int tempMoveOther1;
	private int tempMoveOther2;
	private int tempMoveOther3;

	private JLabel[][] label = new JLabel[11][11];
	private int diceValue;

	public Player(int x, int y, Color mainColor, Color otherColor, int tempMove) {
		this.x = x;
		this.y = y;
		this.tempMove = tempMove;
		this.main = mainColor;
		this.other = otherColor;
		this.white = Color.WHITE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

	public int getTempMove() {
		return tempMove;
	}

	public void setTempMoveOther1(int tempMoveOther1) {
		this.tempMoveOther1 = tempMoveOther1;
	}

	public void setTempMoveOther2(int tempMoveOther2) {
		this.tempMoveOther2 = tempMoveOther2;
	}

	public void setTempMoveOther3(int tempMoveOther3) {
		this.tempMoveOther3 = tempMoveOther3;
	}

	public void setLabel(JLabel[][] label) {
		this.label = label;
	}

	public void movement() {
		if (label[x][y].getBackground().equals(main)) {
			if (tempMove >= 40 && tempMove < 43) {
				label[x][y].setBackground(other);
			} else if (tempMove == 43) {

			} else {
				label[x][y].setBackground(white);
			}
			if (tempMove + diceValue == tempMoveOther1
					|| tempMove + diceValue == tempMoveOther2
					|| tempMove + diceValue == tempMoveOther3) {
				label[x][y].setBackground(main);
			} else if (tempMove + diceValue < 44) {
				x = Utility.getMovement(main)[tempMove + diceValue][0];
				y = Utility.getMovement(main)[tempMove + diceValue][1];
				tempMove += diceValue;
				label[x][y].setBackground(main);

			} else {
				label[x][y].setBackground(main);

			}

		}
	}

}
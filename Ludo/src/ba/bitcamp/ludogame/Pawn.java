package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class Pawn {

	private Color main;
	private Color other;
	private Color white;

	private int x;
	private int y;

	private int tempMove;
	private int tempMoveOther1;
	private int tempMoveOther2;
	private int tempMoveOther3;
	private BufferedImage pawn;
	private BufferedImage background;
	private BufferedImage house;

	private JLabel[][] label = new JLabel[11][11];
	private int diceValue;

	public Pawn(int x, int y, Color mainColor, Color otherColor, int tempMove,
			BufferedImage pown, BufferedImage house) {
		this.x = x;
		this.y = y;
		this.tempMove = tempMove;
		this.main = mainColor;
		this.other = otherColor;
		this.white = Color.WHITE;
		this.pawn = pown;
		this.house = house;

		try {
			background = ImageIO.read(new File("graphics/road.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				//label[x][y].setIcon(new ImageIcon(house));
			} else if (tempMove == 43) {

			} else {
				label[x][y].setBackground(white);
				//label[x][y].setIcon(new ImageIcon(background));

			}
			if (tempMove + diceValue == tempMoveOther1
					|| tempMove + diceValue == tempMoveOther2
					|| tempMove + diceValue == tempMoveOther3) {
				label[x][y].setBackground(main);
				//label[x][y].setIcon(new ImageIcon(pawn));
			} else if (tempMove + diceValue < 44) {
				x = GameUtility.getMovement(main)[tempMove + diceValue][0];
				y = GameUtility.getMovement(main)[tempMove + diceValue][1];
				tempMove += diceValue;
				label[x][y].setBackground(main);
				//label[x][y].setIcon(new ImageIcon(pawn));

			} else {
				label[x][y].setBackground(main);
				//label[x][y].setIcon(new ImageIcon(pawn));

			}

		}

	}

}
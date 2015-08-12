package ba.bitcamp.ludogame;

import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utility {

	public static int getRandomNumber() {
		Random rand = new Random();
		int option = rand.nextInt(6) + 1;
		return option;
	}

	public static int[][] getMovement(Color color) {
		if (color == Color.YELLOW) {
			int[][] yellowMove = new int[][] { { 10, 4 }, { 9, 4 }, { 8, 4 },
					{ 7, 4 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 },
					{ 5, 0 }, { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 },
					{ 3, 4 }, { 2, 4 }, { 1, 4 }, { 0, 4 }, { 0, 5 }, { 0, 6 },
					{ 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 4, 7 }, { 4, 8 },
					{ 4, 9 }, { 4, 10 }, { 5, 10 }, { 6, 10 }, { 6, 9 },
					{ 6, 8 }, { 6, 7 }, { 6, 6 }, { 7, 6 }, { 8, 6 }, { 9, 6 },
					{ 10, 6 }, { 10, 5 }, { 9, 5 }, { 8, 5 }, { 7, 5 },
					{ 6, 5 } };
			return yellowMove;

		} else if (color == Color.BLUE) {
			int[][] blueMove = new int[][] { { 6, 10 }, { 6, 9 }, { 6, 8 },
					{ 6, 7 }, { 6, 6 }, { 7, 6 }, { 8, 6 }, { 9, 6 },
					{ 10, 6 }, { 10, 5 }, { 10, 4 }, { 9, 4 }, { 8, 4 },
					{ 7, 4 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 },
					{ 5, 0 }, { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 },
					{ 3, 4 }, { 2, 4 }, { 1, 4 }, { 0, 4 }, { 0, 5 }, { 0, 6 },
					{ 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 4, 7 }, { 4, 8 },
					{ 4, 9 }, { 4, 10 }, { 5, 10 }, { 5, 9 }, { 5, 8 },
					{ 5, 7 }, { 5, 6 } };
			return blueMove;

		} else if (color == Color.RED) {
			int[][] redMove = new int[][] { { 4, 0 }, { 4, 1 }, { 4, 2 },
					{ 4, 3 }, { 4, 4 }, { 3, 4 }, { 2, 4 }, { 1, 4 }, { 0, 4 },
					{ 0, 5 }, { 0, 6 }, { 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 },
					{ 4, 7 }, { 4, 8 }, { 4, 9 }, { 4, 10 }, { 5, 10 },
					{ 6, 10 }, { 6, 9 }, { 6, 8 }, { 6, 7 }, { 6, 6 },
					{ 7, 6 }, { 8, 6 }, { 9, 6 }, { 10, 6 }, { 10, 5 },
					{ 10, 4 }, { 9, 4 }, { 8, 4 }, { 7, 4 }, { 6, 4 },
					{ 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 }, { 5, 0 }, { 5, 1 },
					{ 5, 2 }, { 5, 3 }, { 5, 4 } };
			return redMove;

		} else if (color == Color.GREEN) {
			int[][] greenMove = new int[][] { { 0, 6 }, { 1, 6 }, { 2, 6 },
					{ 3, 6 }, { 4, 6 }, { 4, 7 }, { 4, 8 }, { 4, 9 },
					{ 4, 10 }, { 5, 10 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
					{ 6, 7 }, { 6, 6 }, { 7, 6 }, { 8, 6 }, { 9, 6 },
					{ 10, 6 }, { 10, 5 }, { 10, 4 }, { 9, 4 }, { 8, 4 },
					{ 7, 4 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 },
					{ 5, 0 }, { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 },
					{ 3, 4 }, { 2, 4 }, { 1, 4 }, { 0, 4 }, { 0, 5 }, { 1, 5 },
					{ 2, 5 }, { 3, 5 }, { 4, 5 } };
			return greenMove;
		}
		return null;

	}

	private static int[][] getGameMatrix() {
		int[][] matrix = new int[][] { { 3, 3, 0, 0, 1, 1, 1, 0, 0, 2, 2 },
				{ 3, 3, 0, 0, 1, 8, 1, 0, 0, 2, 2 },
				{ 0, 0, 0, 0, 1, 8, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 8, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1 },
				{ 1, 7, 7, 7, 7, 6, 9, 9, 9, 9, 1 },
				{ 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 1, 11, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 11, 1, 0, 0, 0, 0 },
				{ 5, 5, 0, 0, 1, 11, 1, 0, 0, 4, 4 },
				{ 5, 5, 0, 0, 1, 1, 1, 0, 0, 4, 4 }, };
		return matrix;
	}

	public static JLabel[][] getGameLabels() {
		JLabel[][] label = new JLabel[11][11];
		for (int i = 0; i < getGameMatrix().length; i++) {
			for (int j = 0; j < getGameMatrix()[i].length; j++) {
				label[i][j] = new JLabel();
				label[i][j].setOpaque(true);
				label[i][j].setHorizontalAlignment(JFrame.NORMAL);
				if (getGameMatrix()[i][j] == 3) {
					label[i][j].setBackground(Color.RED);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 2) {
					label[i][j].setBackground(Color.GREEN);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 1) {
					label[i][j].setBackground(Color.WHITE);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 4) {
					label[i][j].setBackground(Color.BLUE);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 5) {
					label[i][j].setBackground(Color.YELLOW);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 6) {
					label[i][j].setIcon(new ImageIcon(new Dice().getRandomDice(6)));
				} else if (getGameMatrix()[i][j] == 7) {
					label[i][j].setBackground(new Color(247, 64, 86));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 0) {
					label[i][j].setBackground(Color.LIGHT_GRAY);
				} else if (getGameMatrix()[i][j] == 8) {
					label[i][j].setBackground(new Color(179, 255, 179));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 9) {
					label[i][j].setBackground(new Color(179, 217, 255));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (getGameMatrix()[i][j] == 11) {
					label[i][j].setBackground(new Color(235, 255, 122));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				}
			}
		}
		return label;
	}
}

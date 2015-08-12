package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class YellowPlayer extends JFrame {
	private static final long serialVersionUID = -7279692822351465019L;

	public static int[][] matrix; // = new int [11][11];
	public static JLabel[][] label = new JLabel[11][11];
	private static int diceValue;

	private static int x1 = 10;
	private static int y1 = 4;

	private static int x2 = 10;
	private static int y2 = 4;

	private static int x3 = 10;
	private static int y3 = 4;

	private static int x4 = 10;
	private static int y4 = 4;

	static int temp1 = 0;
	static int temp2 = 0;
	static int temp3 = 0;
	static int temp4 = 0;

	private static int diceCounter = 0;
	private static Boolean nextTurn = false;

	static int[][] yellowMove = new int[][] { { 10, 4 }, { 9, 4 }, { 8, 4 },
			{ 7, 4 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 },
			{ 5, 0 }, { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 },
			{ 3, 4 }, { 2, 4 }, { 1, 4 }, { 0, 4 }, { 0, 5 }, { 0, 6 },
			{ 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 4, 7 }, { 4, 8 },
			{ 4, 9 }, { 4, 10 }, { 5, 10 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
			{ 6, 7 }, { 6, 6 }, { 7, 6 }, { 8, 6 }, { 9, 6 }, { 10, 6 },
			{ 10, 5 }, { 9, 5 }, { 8, 5 }, { 7, 5 }, { 6, 5 } };

	public YellowPlayer() {
		// String ip =
		// JOptionPane.showInputDialog("Insert ip address of server");
		// System.out.println(ip);
		setLayout(new GridLayout(11, 11));

		matrix = new int[][] { { 3, 3, 0, 0, 1, 1, 1, 0, 0, 2, 2 },
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

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				label[i][j] = new JLabel();
				label[i][j].setOpaque(true);
				label[i][j].setHorizontalAlignment(NORMAL);
				if (matrix[i][j] == 3) {
					label[i][j].setBackground(Color.RED);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 2) {
					label[i][j].setBackground(Color.GREEN);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 1) {
					label[i][j].setBackground(Color.WHITE);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 4) {
					label[i][j].setBackground(Color.BLUE);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 5) {
					label[i][j].setBackground(Color.YELLOW);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 6) {

				} else if (matrix[i][j] == 7) {
					label[i][j].setBackground(new Color(247, 64, 86));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 0) {
					label[i][j].setBackground(Color.LIGHT_GRAY);
				} else if (matrix[i][j] == 8) {
					label[i][j].setBackground(new Color(179, 255, 179));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 9) {
					label[i][j].setBackground(new Color(179, 217, 255));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 11) {
					label[i][j].setBackground(new Color(235, 255, 122));
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				}
				label[i][j].addMouseListener(new Action());

				add(label[i][j]);

			}
		}

		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class Action extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == label[5][5]) {
				if (diceCounter < 3 || diceValue == 6 || nextTurn) {
					diceCounter++;
					diceValue = NumUtility.getRandomNumber();
					label[5][5].setIcon(new ImageIcon(new Dice()
							.getRandomDice(diceValue)));
					System.out.println(diceValue);
					if (diceCounter == 3) {
						nextTurn = true;
						// diceCounter = 0;
					}
				}
			}

			if (e.getSource() == label[x1][y1]) {
				if (label[x1][y1].getBackground().equals(Color.YELLOW)) {
					if (temp1 >= 40 && temp1 < 43) {
						label[x1][y1].setBackground(new Color(235, 255, 122));
					} else if (temp1 == 43) {

					} else {
						label[x1][y1].setBackground(Color.WHITE);
					}
					System.out.println(temp1 + diceValue);
					if (temp1 + diceValue == temp2
							|| temp1 + diceValue == temp3
							|| temp1 + diceValue == temp4) {
						label[x1][y1].setBackground(Color.YELLOW);
					} else if (temp1 + diceValue < 44) {
						x1 = yellowMove[temp1 + diceValue][0];
						y1 = yellowMove[temp1 + diceValue][1];
						temp1 += diceValue;
						label[x1][y1].setBackground(Color.YELLOW);

					} else {
						label[x1][y1].setBackground(Color.YELLOW);

					}

				}

			} else if (e.getSource() == label[x2][y2]) {
				if (label[x2][y2].getBackground().equals(Color.YELLOW)) {
					if (temp2 >= 40 && temp2 < 43) {
						label[x2][y2].setBackground(new Color(235, 255, 122));
					} else if (temp2 == 43) {

					} else {
						label[x2][y2].setBackground(Color.WHITE);
					}
					if (temp2 + diceValue == temp1
							|| temp2 + diceValue == temp3
							|| temp2 + diceValue == temp4) {
						label[x2][y2].setBackground(Color.YELLOW);
					} else if (temp2 + diceValue < 44) {
						x2 = yellowMove[temp2 + diceValue][0];
						y2 = yellowMove[temp2 + diceValue][1];
						temp2 += diceValue;
						label[x2][y2].setBackground(Color.YELLOW);

					} else {
						label[x2][y2].setBackground(Color.YELLOW);
					}

				}
			} else if (e.getSource() == label[x3][y3]) {
				if (label[x3][y3].getBackground().equals(Color.YELLOW)) {
					if (temp3 >= 40 && temp3 < 43) {
						label[x3][y3].setBackground(new Color(235, 255, 122));
					} else if (temp3 == 43) {

					} else {
						label[x3][y3].setBackground(Color.WHITE);
					}

					if (temp3 + diceValue == temp1
							|| temp3 + diceValue == temp2
							|| temp3 + diceValue == temp4) {
						label[x3][y3].setBackground(Color.YELLOW);
					} else if (temp3 + diceValue < 44) {
						x3 = yellowMove[temp3 + diceValue][0];
						y3 = yellowMove[temp3 + diceValue][1];
						temp3 += diceValue;
						label[x3][y3].setBackground(Color.YELLOW);
					} else {
						label[x3][y3].setBackground(Color.YELLOW);
					}

				}
			} else if (e.getSource() == label[x4][y4]) {
				if (label[x4][y4].getBackground().equals(Color.YELLOW)) {
					if (temp4 >= 40 && temp4 < 43) {
						label[x4][y4].setBackground(new Color(235, 255, 122));
					} else if (temp4 == 43) {

					} else {
						label[x4][y4].setBackground(Color.WHITE);
					}

					if (temp4 + diceValue == temp1
							|| temp4 + diceValue == temp2
							|| temp4 + diceValue == temp3) {
						label[x4][y4].setBackground(Color.YELLOW);
					} else if (temp4 + diceValue < 44) {
						x4 = yellowMove[temp4 + diceValue][0];
						y4 = yellowMove[temp4 + diceValue][1];
						temp4 += diceValue;
						label[x4][y4].setBackground(Color.YELLOW);

					} else {
						label[x4][y4].setBackground(Color.YELLOW);
					}

				}
			}

			if (diceValue == 6) {
				if (e.getSource() == label[10][0]
						&& label[10][0].getBackground().equals(Color.YELLOW)) {

					if (label[10][4].getBackground().equals(Color.WHITE)) {
						label[10][4].setBackground(Color.YELLOW);
						label[10][0].setBackground(new Color(235, 255, 122));
					}
				} else if (e.getSource() == label[9][0]
						&& label[9][0].getBackground().equals(Color.YELLOW)) {
					if (label[10][4].getBackground().equals(Color.WHITE)) {
						label[10][4].setBackground(Color.YELLOW);
						label[9][0].setBackground(new Color(235, 255, 122));
					}
				} else if (e.getSource() == label[10][1]
						&& label[10][1].getBackground().equals(Color.YELLOW)) {
					if (label[10][4].getBackground().equals(Color.WHITE)) {
						label[10][4].setBackground(Color.YELLOW);
						label[10][1].setBackground(new Color(235, 255, 122));
					}
				} else if (e.getSource() == label[9][1]
						&& label[9][1].getBackground().equals(Color.YELLOW)) {
					if (label[10][4].getBackground().equals(Color.WHITE)) {
						label[10][4].setBackground(Color.YELLOW);
						label[9][1].setBackground(new Color(235, 255, 122));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new YellowPlayer();
	}

}

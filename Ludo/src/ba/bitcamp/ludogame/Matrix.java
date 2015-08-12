package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Matrix extends JFrame {
	private static final long serialVersionUID = -7279692822351465019L;

	private int[][] matrix; // = new int [11][11];
	private JLabel[][] label = new JLabel[11][11];
	private int x = 4;
	private static int y = 0;
	private static int value;
	static int temp = 0;

	private Color blue = new Color(131, 166, 242);
	private Color red = new Color(242, 131, 131);
	private Color green = new Color(134, 196, 71);
	private Color yellow = new Color(251, 255, 145);

	private Boolean canExit = false;
	
	

	public Matrix() {
		setLayout(new GridLayout(11, 11));

		matrix = new int[][] { { 3, 3, 0, 0, 1, 1, 2, 0, 0, 2, 2 },
				{ 3, 3, 0, 0, 1, 2, 1, 0, 0, 2, 2 },
				{ 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0 },
				{ 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 },
				{ 1, 3, 3, 3, 3, 6, 4, 4, 4, 4, 1 },
				{ 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 4 },
				{ 0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0 },
				{ 5, 5, 0, 0, 1, 5, 1, 0, 0, 4, 4 },
				{ 5, 5, 0, 0, 5, 1, 1, 0, 0, 4, 4 }, };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				label[i][j] = new JLabel();
				label[i][j].setOpaque(true);
				label[i][j].setHorizontalAlignment(NORMAL);
				if (matrix[i][j] == 3) {
					label[i][j].setBackground(red);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));

				} else if (matrix[i][j] == 2) {
					label[i][j].setBackground(green);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));

				} else if (matrix[i][j] == 1) {
					label[i][j].setBackground(Color.WHITE);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
				} else if (matrix[i][j] == 4) {
					label[i][j].setBackground(blue);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));

				} else if (matrix[i][j] == 5) {
					label[i][j].setBackground(yellow);
					label[i][j].setBorder(BorderFactory
							.createLineBorder(Color.BLACK));

				} else if (matrix[i][j] == 6) {

					// label[i][j].addMouseListener(new Action());
				} else if (matrix[i][j] == 0) {
					label[i][j].setBackground(Color.LIGHT_GRAY);
				}
				label[i][j].addMouseListener(new Movement());

				add(label[i][j]);

			}
		}
		label[5][5].addMouseListener(new DiceAction());

		label[9][9].setIcon(new ImageIcon(new PlayerGraphics().getBlue()));
		label[9][10].setIcon(new ImageIcon(new PlayerGraphics().getBlue()));
		label[10][9].setIcon(new ImageIcon(new PlayerGraphics().getBlue()));
		label[10][10].setIcon(new ImageIcon(new PlayerGraphics().getBlue()));

		label[0][0].setIcon(new ImageIcon(new PlayerGraphics().getRed()));
		label[0][1].setIcon(new ImageIcon(new PlayerGraphics().getRed()));
		label[1][0].setIcon(new ImageIcon(new PlayerGraphics().getRed()));
		label[1][1].setIcon(new ImageIcon(new PlayerGraphics().getRed()));

		label[0][10].setIcon(new ImageIcon(new PlayerGraphics().getGreen()));
		label[0][9].setIcon(new ImageIcon(new PlayerGraphics().getGreen()));
		label[1][10].setIcon(new ImageIcon(new PlayerGraphics().getGreen()));
		label[1][9].setIcon(new ImageIcon(new PlayerGraphics().getGreen()));

		label[10][0].setIcon(new ImageIcon(new PlayerGraphics().getYellow()));
		label[10][1].setIcon(new ImageIcon(new PlayerGraphics().getYellow()));
		label[9][0].setIcon(new ImageIcon(new PlayerGraphics().getYellow()));
		label[9][1].setIcon(new ImageIcon(new PlayerGraphics().getYellow()));

		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class DiceAction extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == label[5][5]) {
				value = NumUtility.getRandomNumber();
				label[5][5].setIcon(new ImageIcon(new Dice()
						.getRandomDice(value)));

				System.out.println(value);
			}

		}
	}

	private class Movement extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			
			if (e.getSource() == label[x][y]) {
				if (label[x][y].getBackground().equals(red)) {
					if (canPlayerExit(value)) {
						if (temp >= 40 && temp < 43) {
							
							// label[x][y].setBackground(new Color(247, 64, 86));
						} else if (temp == 43) {

						} else {
							label[x][y].setBackground(Color.WHITE);
							label[x][y].setIcon(null);
							label[4][0].setBackground(red);
						}
						System.out.println("Temp: " + temp + " Value: " + value);
						
						if (temp + value < 44) {
							x = RedPlayerMove.redmove[temp + value][0];
							y = RedPlayerMove.redmove[temp + value][1];
							temp += value;
							label[0][0].setIcon(null);
							label[x][y].setBackground(red);
							label[x][y].setIcon(new ImageIcon(
									new PlayerGraphics().getRed()));

						} else {
							label[x][y].setBackground(red);
							label[x][y].setIcon(new ImageIcon(
									new PlayerGraphics().getRed()));

						}
						
					}
				}
			}
		}

	}

	private boolean canPlayerExit(int number) {
		if (number == 6) {
			canExit = true;
		}
		return canExit;
	}

	public static void main(String[] args) {
		new Matrix();
	}

}

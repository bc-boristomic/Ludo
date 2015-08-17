package ba.bitcamp.ludogame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * Utility class used to setup all the game matrix used to move players and to
 * setup initial game look.
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class GameUtility {

	/**
	 * For inputed <code>Color</code> type value returns <code>int</code> type
	 * value of 2D array with allowed playable positions. Inputed color is used
	 * to get position of player with that color. Only four color are allowed in
	 * game since there are four player. Red, green, blue and yellow.
	 * 
	 * @param color
	 *            <code>Color</code> type value of player on board
	 * @return <code>int</code> type value of 2D array
	 */
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

	/**
	 * Private method used to setup initial look of board. <code>int</code> type
	 * value of 2D array is used to setup JLabel colors, borders and graphics.
	 * <p>
	 * 0 represents empty position with no movement at all.
	 * <p>
	 * 1 represents fields where every player can move.
	 * <p>
	 * 2 represents green player starting houses.
	 * <p>
	 * 3 represents red player starting houses.
	 * <p>
	 * 4 represents blue player starting houses.
	 * <p>
	 * 5 represents yellow player starting houses.
	 * <p>
	 * 6 represents dice graphics.
	 * <p>
	 * 7 represents red player finish houses.
	 * <p>
	 * 8 represents green player finish houses.
	 * <p>
	 * 9 represents blue player finish houses.
	 * <p>
	 * 11 represents yellow player finish houses.
	 * 
	 * @return
	 */
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

	/**
	 * Public method getGameLabels sets <code>JLabel</code> type value of 2D
	 * array using private method getGameMatrix. Depending on player position
	 * read from matrix color, border and <tt>ImageIcon</tt> is set.
	 * 
	 * @return <code>JLabel</code> 2D array type value set with graphical looks.
	 */
	public static JLabel[][] getGameLabels(/*int[][] setupMatrix*/) {
		try {
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
						//label[i][j].setIcon(new ImageIcon(ImageIO.read(new File("graphics/road.jpg"))));
					} else if (getGameMatrix()[i][j] == 4) {
						label[i][j].setBackground(Color.BLUE);
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					} else if (getGameMatrix()[i][j] == 5) {
						label[i][j].setBackground(Color.YELLOW);
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					} else if (getGameMatrix()[i][j] == 6) {
						label[i][j].setIcon(new ImageIcon(new Dice()
								.getRandomDice(6)));
					} else if (getGameMatrix()[i][j] == 7) {
						label[i][j].setBackground(new Color(247, 64, 86));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/home.png"))));
					} else if (getGameMatrix()[i][j] == 0) {
						label[i][j].setBackground(Color.LIGHT_GRAY);
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/caldram.jpg"))));
					} else if (getGameMatrix()[i][j] == 8) {
						label[i][j].setBackground(new Color(179, 255, 179));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/greenhome.png"))));
					} else if (getGameMatrix()[i][j] == 9) {
						label[i][j].setBackground(new Color(179, 217, 255));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/bluehome.png"))));
					} else if (getGameMatrix()[i][j] == 11) {
						label[i][j].setBackground(new Color(235, 255, 122));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/yellowhome.png"))));
					}
				}
			}
			return label;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	
	public static JLabel[][] getGameLabels(int[][] setupMatrix) {
		try {
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
						//label[i][j].setIcon(new ImageIcon(ImageIO.read(new File("graphics/road.jpg"))));
					} else if (getGameMatrix()[i][j] == 4) {
						label[i][j].setBackground(Color.BLUE);
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					} else if (getGameMatrix()[i][j] == 5) {
						label[i][j].setBackground(Color.YELLOW);
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					} else if (getGameMatrix()[i][j] == 6) {
						label[i][j].setIcon(new ImageIcon(new Dice()
								.getRandomDice(6)));
					} else if (getGameMatrix()[i][j] == 7) {
						label[i][j].setBackground(new Color(247, 64, 86));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/home.png"))));
					} else if (getGameMatrix()[i][j] == 0) {
						label[i][j].setBackground(Color.LIGHT_GRAY);
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/caldram.jpg"))));
					} else if (getGameMatrix()[i][j] == 8) {
						label[i][j].setBackground(new Color(179, 255, 179));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/greenhome.png"))));
					} else if (getGameMatrix()[i][j] == 9) {
						label[i][j].setBackground(new Color(179, 217, 255));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/bluehome.png"))));
					} else if (getGameMatrix()[i][j] == 11) {
						label[i][j].setBackground(new Color(235, 255, 122));
						label[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
						label[i][j].setIcon(new ImageIcon(ImageIO
								.read(new File("graphics/yellowhome.png"))));
					}
				}
			}
			return label;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}

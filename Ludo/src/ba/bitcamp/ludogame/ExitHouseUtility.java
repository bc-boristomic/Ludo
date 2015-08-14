package ba.bitcamp.ludogame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Utility class <tt>ExitHouseUtility</tt> used to call static methods that set
 * player exiting houses.
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class ExitHouseUtility {

	/**
	 * Static method used to setup RedPlayer exiting house. Checks position
	 * where player clicked on map and exits on that position to path entering
	 * position for RedPlayer. Houses are positioned from top down, left right
	 * as 1, 2, 3, 4.
	 * 
	 * @param option
	 *            <code>int</code> type value of house position
	 * @param label
	 *            <code>JLabel</code> type value of current player positions
	 * @return <code>JLabel</code> type value of return player positions
	 */
	public static JLabel[][] setRedPlayerHouse(int option, JLabel[][] label) {
		
		try{
		if (option == 1) {
			if (label[4][0].getBackground().equals(Color.WHITE)) {
				label[4][0].setBackground(Color.RED);
				label[4][0].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/red.png"))));
				label[0][0].setBackground(new Color(247, 64, 86));
			}
		} else if (option == 2) {
			if (label[4][0].getBackground().equals(Color.WHITE)) {
				label[4][0].setBackground(Color.RED);
				label[4][0].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/red.png"))));
				label[0][1].setBackground(new Color(247, 64, 86));
			}
		} else if (option == 3) {
			if (label[4][0].getBackground().equals(Color.WHITE)) {
				label[4][0].setBackground(Color.RED);
				label[4][0].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/red.png"))));
				label[1][0].setBackground(new Color(247, 64, 86));
			}
		} else if (option == 4) {
			if (label[4][0].getBackground().equals(Color.WHITE)) {
				label[4][0].setBackground(Color.RED);
				label[4][0].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/red.png"))));
				label[1][1].setBackground(new Color(247, 64, 86));
			}
		}
		return label;
		
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return label;
	}

	/**
	 * Static method used to setup GreenPlayer exiting house. Checks position
	 * where player clicked on map and exits on that position to path entering
	 * position for GreenPlayer. Houses are positioned from top down, left right
	 * as 1, 2, 3, 4.
	 * 
	 * @param option
	 *            <code>int</code> type value of house position
	 * @param label
	 *            <code>JLabel</code> type value of current player positions
	 * @return <code>JLabel</code> type value of return player positions
	 */
	public static JLabel[][] setGreenPlayer(int option, JLabel[][] label) {
		
		try{
		if (option == 1) {
			if (label[0][6].getBackground().equals(Color.WHITE)) {
				label[0][6].setBackground(Color.GREEN);
				label[0][6].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/green.png"))));
				label[0][9].setBackground(new Color(179, 255, 179));
			}
		} else if (option == 2) {
			if (label[0][6].getBackground().equals(Color.WHITE)) {
				label[0][6].setBackground(Color.GREEN);
				label[0][6].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/green.png"))));
				label[0][10].setBackground(new Color(179, 255, 179));
			}
		} else if (option == 3) {
			if (label[0][6].getBackground().equals(Color.WHITE)) {
				label[0][6].setBackground(Color.GREEN);
				label[0][6].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/green.png"))));
				label[1][9].setBackground(new Color(179, 255, 179));
			}
		} else if (option == 4) {
			if (label[0][6].getBackground().equals(Color.WHITE)) {
				label[0][6].setBackground(Color.GREEN);
				label[0][6].setIcon(new ImageIcon(ImageIO.read(new File(
						"graphics/green.png"))));
				label[1][10].setBackground(new Color(179, 255, 179));
			}
		}
		return label;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return label;
		
	}

	/**
	 * Static method used to setup BluePlayer exiting house. Checks position
	 * where player clicked on map and exits on that position to path entering
	 * position for BluePlayer. Houses are positioned from top down, left right
	 * as 1, 2, 3, 4.
	 * 
	 * @param option
	 *            <code>int</code> type value of house position
	 * @param label
	 *            <code>JLabel</code> type value of current player positions
	 * @return <code>JLabel</code> type value of return player positions
	 */
	public static JLabel[][] setBluePlayer(int option, JLabel[][] label) {

		try {
			if (option == 1) {
				if (label[6][10].getBackground().equals(Color.WHITE)) {
					label[6][10].setBackground(Color.BLUE);
					label[6][10].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/blue.png"))));
					label[9][9].setBackground(new Color(179, 217, 255));
				}
			} else if (option == 2) {
				if (label[6][10].getBackground().equals(Color.WHITE)) {
					label[6][10].setBackground(Color.BLUE);
					label[6][10].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/blue.png"))));
					label[9][10].setBackground(new Color(179, 217, 255));
				}
			} else if (option == 3) {
				if (label[6][10].getBackground().equals(Color.WHITE)) {
					label[6][10].setBackground(Color.BLUE);
					label[6][10].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/blue.png"))));
					label[10][9].setBackground(new Color(179, 217, 255));
				}
			} else if (option == 4) {
				if (label[6][10].getBackground().equals(Color.WHITE)) {
					label[6][10].setBackground(Color.BLUE);
					label[6][10].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/blue.png"))));
					label[10][10].setBackground(new Color(179, 217, 255));
				}
			}
			return label;

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return label;
	}

	/**
	 * Static method used to setup YellowPlayer exiting house. Checks position
	 * where player clicked on map and exits on that position to path entering
	 * position for YellowPlayer. Houses are positioned from top down, left
	 * right as 1, 2, 3, 4.
	 * 
	 * @param option
	 *            <code>int</code> type value of house position
	 * @param label
	 *            <code>JLabel</code> type value of current player positions
	 * @return <code>JLabel</code> type value of return player positions
	 */
	public static JLabel[][] setYellowPlayer(int option, JLabel[][] label) {
		try {
			if (option == 1) {
				if (label[10][4].getBackground().equals(Color.WHITE)) {
					label[10][4].setBackground(Color.YELLOW);
					label[10][4].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/yellow.png"))));
					label[9][0].setBackground(new Color(235, 255, 122));
				}
			} else if (option == 2) {
				if (label[10][4].getBackground().equals(Color.WHITE)) {
					label[10][4].setBackground(Color.YELLOW);
					label[10][4].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/yellow.png"))));
					label[9][1].setBackground(new Color(235, 255, 122));
				}
			} else if (option == 3) {
				if (label[10][4].getBackground().equals(Color.WHITE)) {
					label[10][4].setBackground(Color.YELLOW);
					label[10][4].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/yellow.png"))));
					label[10][0].setBackground(new Color(235, 255, 122));
				}
			} else if (option == 4) {
				if (label[10][4].getBackground().equals(Color.WHITE)) {
					label[10][4].setBackground(Color.YELLOW);
					label[10][4].setIcon(new ImageIcon(ImageIO.read(new File(
							"graphics/yellow.png"))));
					label[10][1].setBackground(new Color(235, 255, 122));
				}
			}
			return label;

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return label;
	}

}

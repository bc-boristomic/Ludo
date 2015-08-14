package ba.bitcamp.ludogame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Public class <tt>Dice</tt> represents object Dice in game of Ludo. Dice have
 * value that can be in range from 1 to 6, and images that are graphical
 * representation of that value.
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class Dice {

	private int value;

	private BufferedImage dice1;
	private BufferedImage dice2;
	private BufferedImage dice3;
	private BufferedImage dice4;
	private BufferedImage dice5;
	private BufferedImage dice6;

	/**
	 * Default constructor of Dice class used to initialize all the images.
	 */
	public Dice() {

		try {
			dice1 = ImageIO.read(new File("graphics/dice1.png"));
			dice2 = ImageIO.read(new File("graphics/dice2.png"));
			dice3 = ImageIO.read(new File("graphics/dice3.png"));
			dice4 = ImageIO.read(new File("graphics/dice4.png"));
			dice5 = ImageIO.read(new File("graphics/dice5.png"));
			dice6 = ImageIO.read(new File("graphics/dice6.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method used to get dice image with same number as inputed value. Inputed
	 * value is used from <tt>NumUtility</tt> class to get random number from 1
	 * to 6.
	 * 
	 * @param number
	 *            <code>int</code> type value from 1 to 6
	 * @return <code>BufferedImage</code> type value representing dice value
	 */
	public BufferedImage getRandomDice(int number) {

		switch (number) {
		case 1:
			setValue(1);
			return getDice1();
		case 2:
			setValue(2);
			return getDice2();
		case 3:
			setValue(3);
			return getDice3();
		case 4:
			setValue(4);
			return getDice4();
		case 5:
			setValue(5);
			return getDice5();
		case 6:
			setValue(6);
			return getDice6();
		default:
			return getDice1();
		}
	}

	/**
	 * Sets dice value by inputed <code>int</code> type value.
	 * 
	 * @param value
	 *            <code>int</code> type value that will set dice value
	 */
	private void setValue(int value) {
		this.value = value;
	}

	/**
	 * Returns value of dice, return value is <code>int</code> type
	 * 
	 * @return <code>int</code> type value of dice
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Getter for image if dice value is 1
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 1
	 */
	public BufferedImage getDice1() {
		return dice1;
	}

	/**
	 * Getter for image if dice value is 2
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 2
	 */
	public BufferedImage getDice2() {
		return dice2;
	}

	/**
	 * Getter for image if dice value is 3
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 3
	 */
	public BufferedImage getDice3() {
		return dice3;
	}

	/**
	 * Getter for image if dice value is 4
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 4
	 */
	public BufferedImage getDice4() {
		return dice4;
	}

	/**
	 * Getter for image if dice value is 5
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 5
	 */
	public BufferedImage getDice5() {
		return dice5;
	}

	/**
	 * Getter for image if dice value is 6
	 * 
	 * @return <code>BufferedImage</code> type value graphically representing
	 *         number 6
	 */
	public BufferedImage getDice6() {
		return dice6;
	}

}
package ba.bitcamp.ludogame;

import java.util.Random;

/**
 * Utility class <tt>NumUtility</tt> used to call static method that manipulate
 * number values.
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class NumUtility {

	/**
	 * Static method returns random number from 1 to 6 used to set dice value.
	 * 
	 * @return <code>int</code> type value from 1 to 6 randomly given
	 */
	public static int getRandomNumber() {
		Random rand = new Random();
		int option = rand.nextInt(6) + 1;
		return option;
	}

}

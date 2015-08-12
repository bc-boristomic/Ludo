package ba.bitcamp.ludogame;

import java.util.Random;

public class NumUtility {

	public static int getRandomNumber() {
		Random rand = new Random();
		int option = rand.nextInt(6) + 1;
		return option;
	}

}

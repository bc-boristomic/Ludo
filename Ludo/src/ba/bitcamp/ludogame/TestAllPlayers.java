package ba.bitcamp.ludogame;

import java.awt.Color;
import java.io.IOException;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class TestAllPlayers {
	
	public static void main(String[] args) {
		
		PlayerGraphics pg = new PlayerGraphics();
		try {
			Player blue = new Player(Color.BLUE, MyColors.BLUE_LIGHT, pg.getBlue(), pg.getBlueHouse());
			Player red = new Player(Color.RED, MyColors.RED_LIGHT, pg.getRed(), pg.getRedHouse());
			Player green = new Player(Color.GREEN, MyColors.GREEN_LIGHT, pg.getGreen(), pg.getGreenHouse());
			Player yellow = new Player(Color.YELLOW, MyColors.YELLOW_LIGHT, pg.getYellow(), pg.getYellowHouse());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

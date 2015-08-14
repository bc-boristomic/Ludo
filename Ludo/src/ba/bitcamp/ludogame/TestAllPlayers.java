package ba.bitcamp.ludogame;

import java.awt.Color;
import java.io.IOException;

public class TestAllPlayers {
	
	public static void main(String[] args) {
		
		PlayerGraphics pg = new PlayerGraphics();
		try {
			Player blue = new Player(Color.BLUE, MyColors.BLUE_LIGHT, pg.getBlue(), pg.getBlueHouse());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

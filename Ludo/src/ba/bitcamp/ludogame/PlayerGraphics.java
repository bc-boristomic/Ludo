package ba.bitcamp.ludogame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerGraphics {
	
	private BufferedImage blue;
	private BufferedImage green;
	private BufferedImage yellow;
	private BufferedImage red;

	
	public PlayerGraphics() {
		try {
			blue = ImageIO.read(new File("blue.png"));
			green = ImageIO.read(new File("green.png"));
			yellow = ImageIO.read(new File("yellow.png"));
			red = ImageIO.read(new File("red.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage getBlue() {
		return blue;
	}

	public BufferedImage getGreen() {
		return green;
	}
	
	public BufferedImage getYellow() {
		return yellow;
	}
	
	public BufferedImage getRed() {
		return red;
	}

}
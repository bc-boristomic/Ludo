package ba.bitcamp.ludogame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class PlayerGraphics {

	private BufferedImage blue;
	private BufferedImage green;
	private BufferedImage yellow;
	private BufferedImage red;
	private BufferedImage blueHouse;
	private BufferedImage greenHouse;
	private BufferedImage yellowHouse;
	private BufferedImage redHouse;

	public PlayerGraphics() {
		try {
			blue = ImageIO.read(new File("graphics/blue.png"));
			green = ImageIO.read(new File("graphics/green.png"));
			yellow = ImageIO.read(new File("graphics/yellow.png"));
			red = ImageIO.read(new File("graphics/red.png"));
			blueHouse = ImageIO.read(new File("graphics/bluehome.png"));
			greenHouse = ImageIO.read(new File("graphics/greenhome.png"));
			yellowHouse = ImageIO.read(new File("graphics/yellowhome.png"));
			redHouse = ImageIO.read(new File("graphics/home.png"));
		} catch (IOException e) {
			throw new NullPointerException("No image at given location");
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

	public BufferedImage getBlueHouse() {
		return blueHouse;
	}

	public BufferedImage getGreenHouse() {
		return greenHouse;
	}

	public BufferedImage getYellowHouse() {
		return yellowHouse;
	}

	public BufferedImage getRedHouse() {
		return redHouse;
	}

}
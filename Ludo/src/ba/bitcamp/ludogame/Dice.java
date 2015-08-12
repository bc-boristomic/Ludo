package ba.bitcamp.ludogame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dice {
	
	private int value;
	private BufferedImage dice1;
	private BufferedImage dice2;
	private BufferedImage dice3;
	private BufferedImage dice4;
	private BufferedImage dice5;
	private BufferedImage dice6;

	public Dice() {

		try {
			dice1 = ImageIO.read(new File("dice1.png"));
			dice2 = ImageIO.read(new File("dice2.png"));
			dice3 = ImageIO.read(new File("dice3.png"));
			dice4 = ImageIO.read(new File("dice4.png"));
			dice5 = ImageIO.read(new File("dice5.png"));
			dice6 = ImageIO.read(new File("dice6.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
			default: return getDice1();
		}
	}
	
	private void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public BufferedImage getDice1() {
		return dice1;
	}

	public BufferedImage getDice2() {
		return dice2;
	}

	public BufferedImage getDice3() {
		return dice3;
	}

	public BufferedImage getDice4() {
		return dice4;
	}

	public BufferedImage getDice5() {
		return dice5;
	}

	public BufferedImage getDice6() {
		return dice6;
	}

}
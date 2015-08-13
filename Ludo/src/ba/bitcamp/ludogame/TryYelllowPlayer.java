package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TryYelllowPlayer extends JFrame {
	private static final long serialVersionUID = 311184114665588161L;

	private static Pawn p1;
	private static Pawn p2;
	private static Pawn p3;
	private static Pawn p4;

	public int[][] matrix;
	public JLabel[][] label = new JLabel[11][11];

	private Dice dice = new Dice();
		
	public TryYelllowPlayer() throws IOException {

		setLayout(new GridLayout(11, 11));

		BufferedImage pawn = ImageIO.read(new File("graphics/yellow.png"));
		BufferedImage house = ImageIO.read(new File("graphics/yellowhome.png"));

		p1 = new Pawn(10, 4, Color.YELLOW, new Color(235, 255, 122), 0, pawn,
				house);
		p2 = new Pawn(10, 4, Color.YELLOW, new Color(235, 255, 122), 0, pawn,
				house);
		p3 = new Pawn(10, 4, Color.YELLOW, new Color(235, 255, 122), 0, pawn,
				house);
		p4 = new Pawn(10, 4, Color.YELLOW, new Color(235, 255, 122), 0, pawn,
				house);

		label = GameUtility.getGameLabels();
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				if (!label[i][j].equals(label[5][5])) {
					label[i][j].addMouseListener(new Action());
				}
				add(label[i][j]);
			}
		}
		label[5][5].addMouseListener(new DiceAction());


		label[10][0].setIcon(new ImageIcon(pawn));
		label[9][0].setIcon(new ImageIcon(pawn));
		label[9][1].setIcon(new ImageIcon(pawn));
		label[10][1].setIcon(new ImageIcon(pawn));

		p1.setLabel(label);
		p2.setLabel(label);
		p3.setLabel(label);
		p4.setLabel(label);

		setTitle("Yellow player");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class DiceAction extends MouseAdapter {
		@Override
 		public void mousePressed(MouseEvent e) {
 			if (e.getSource() == label[5][5]) {
 				label[5][5].setIcon(new ImageIcon(dice.getRandomDice(NumUtility
 						.getRandomNumber())));
 				p1.setDiceValue(dice.getValue());
 				p2.setDiceValue(dice.getValue());
 				p3.setDiceValue(dice.getValue());
 				p4.setDiceValue(dice.getValue());
 			}
		}
	}

	private class Action extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			
			setSamePlayerUneatable();

			if (e.getSource() == label[p1.getX()][p1.getY()]) {
				p1.movement();
			} else if (e.getSource() == label[p2.getX()][p2.getY()]) {
				p2.movement();
			} else if (e.getSource() == label[p3.getX()][p3.getY()]) {
				p3.movement();
			} else if (e.getSource() == label[p4.getX()][p4.getY()]) {
				p4.movement();
			}

			if (dice.getValue() == 6) {
				if (e.getSource() == label[10][0]
						&& label[10][0].getBackground().equals(Color.YELLOW)) {
					ExitHouseUtility.setYellowPlayer(3, label);
				} else if (e.getSource() == label[9][0]
						&& label[9][0].getBackground().equals(Color.YELLOW)) {
					ExitHouseUtility.setYellowPlayer(1, label);
				} else if (e.getSource() == label[10][1]
						&& label[10][1].getBackground().equals(Color.YELLOW)) {
					ExitHouseUtility.setYellowPlayer(4, label);
				} else if (e.getSource() == label[9][1]
						&& label[9][1].getBackground().equals(Color.YELLOW)) {
					ExitHouseUtility.setYellowPlayer(2, label);
				}
			}
		}

	}

	private void setSamePlayerUneatable() {
		p1.setTempMoveOther1(p2.getTempMove());
		p1.setTempMoveOther2(p3.getTempMove());
		p1.setTempMoveOther3(p4.getTempMove());

		p2.setTempMoveOther1(p1.getTempMove());
		p2.setTempMoveOther2(p3.getTempMove());
		p2.setTempMoveOther3(p4.getTempMove());

		p3.setTempMoveOther1(p1.getTempMove());
		p3.setTempMoveOther2(p2.getTempMove());
		p3.setTempMoveOther3(p4.getTempMove());

		p4.setTempMoveOther1(p1.getTempMove());
		p4.setTempMoveOther2(p2.getTempMove());
		p4.setTempMoveOther3(p3.getTempMove());
	}

	public static void main(String[] args) {

		try {
			new TryYelllowPlayer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

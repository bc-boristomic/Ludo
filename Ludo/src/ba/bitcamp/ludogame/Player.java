package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class Player extends JFrame {
	private static final long serialVersionUID = -1789540956904875170L;

	private Pawn p1;
	private Pawn p2;
	private Pawn p3;
	private Pawn p4;

	public int[][] matrix;
	public JLabel[][] label = new JLabel[11][11];

	private Dice dice = new Dice();

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private ObjectMapper mapper = new ObjectMapper();

	private Color main;
	private Color other;

	private BufferedImage pawn;
	private BufferedImage house;

	private int x;
	private int y;

	public Player(Color main, Color other, BufferedImage pawn,
			BufferedImage house) throws IOException {

		this.main = main;
		this.other = other;
		this.pawn = pawn;
		this.house = house;

		String name = JOptionPane.showInputDialog("Enter your name");
		setLayout(new GridLayout(11, 11));
		if (main == Color.BLUE) {
			x = 6;
			y = 10;
		} else if (main == Color.RED) {
			x = 4;
			y = 0;
		} else if (main == Color.GREEN) {
			x = 0;
			y = 6;
		} else if (main == Color.YELLOW) {
			x = 10;
			y = 4;
		}

		p1 = new Pawn(x, y, main, other, 0, pawn, house);
		p2 = new Pawn(x, y, main, other, 0, pawn, house);
		p3 = new Pawn(x, y, main, other, 0, pawn, house);
		p4 = new Pawn(x, y, main, other, 0, pawn, house);

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

		
		p1.setLabel(label);
		p2.setLabel(label);
		p3.setLabel(label);
		p4.setLabel(label);

		setTitle(name);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// String serverIp =
		// JOptionPane.showInputDialog("Enter server IP address");
		// try {
		// socket = new Socket("localhost", Server.PORT);
		// is = socket.getInputStream();
		// Message m = mapper.readValue(is, Message.class);
		// System.out.println(m.getX1() + " " + m.getY1());
		// label[m.getX1()][m.getY1()].setBackground(Color.BLUE);
		// } catch (IOException ex) {
		// // TODO exception handling
		// ex.printStackTrace();
		// }
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
				if (main == Color.RED) {
					if (e.getSource() == label[0][0]
							&& label[0][0].getBackground().equals(main)) {
						ExitHouseUtility.setRedPlayerHouse(1, label);
					} else if (e.getSource() == label[0][1]
							&& label[0][1].getBackground().equals(main)) {
						ExitHouseUtility.setRedPlayerHouse(2, label);
					} else if (e.getSource() == label[1][0]
							&& label[1][0].getBackground().equals(main)) {
						ExitHouseUtility.setRedPlayerHouse(3, label);
					} else if (e.getSource() == label[1][1]
							&& label[1][1].getBackground().equals(main)) {
						ExitHouseUtility.setRedPlayerHouse(4, label);
					}
				} else if (main == Color.BLUE) {
					if (e.getSource() == label[10][10]
							&& label[10][10].getBackground().equals(Color.BLUE)) {
						ExitHouseUtility.setBluePlayer(4, label);
					} else if (e.getSource() == label[10][9]
							&& label[10][9].getBackground().equals(Color.BLUE)) {
						ExitHouseUtility.setBluePlayer(3, label);
					} else if (e.getSource() == label[9][10]
							&& label[9][10].getBackground().equals(Color.BLUE)) {
						ExitHouseUtility.setBluePlayer(2, label);
					} else if (e.getSource() == label[9][9]
							&& label[9][9].getBackground().equals(Color.BLUE)) {
						ExitHouseUtility.setBluePlayer(1, label);
					}
				} else if (main == Color.GREEN) {
					if (e.getSource() == label[0][10]
							&& label[0][10].getBackground().equals(Color.GREEN)) {
						ExitHouseUtility.setGreenPlayer(2, label);
					} else if (e.getSource() == label[0][9]
							&& label[0][9].getBackground().equals(Color.GREEN)) {
						ExitHouseUtility.setGreenPlayer(1, label);
					} else if (e.getSource() == label[1][10]
							&& label[1][10].getBackground().equals(Color.GREEN)) {
						ExitHouseUtility.setGreenPlayer(4, label);
					} else if (e.getSource() == label[1][9]
							&& label[1][9].getBackground().equals(Color.GREEN)) {
						ExitHouseUtility.setGreenPlayer(3, label);
					}
				} else if (main == Color.YELLOW) {
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

	// public static void main(String[] args) {
	// PlayerGraphics pg = new PlayerGraphics();
	//
	//
	// try {
	// new Player(Color.RED, new Color(247, 64, 86), pg.getRed(),
	// pg.getRedHouse());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}

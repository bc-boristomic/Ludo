package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.codehaus.jackson.map.ObjectMapper;

public class TryRedPlayer extends JFrame {
	private static final long serialVersionUID = 311184114665588161L;

	private Socket socket;
	private Pawn p1 = new Pawn(4, 0, Color.RED, new Color(247, 64, 86), 0);
	private Pawn p2 = new Pawn(4, 0, Color.RED, new Color(247, 64, 86), 0);
	private Pawn p3 = new Pawn(4, 0, Color.RED, new Color(247, 64, 86), 0);
	private Pawn p4 = new Pawn(4, 0, Color.RED, new Color(247, 64, 86), 0);
	
	private InputStream is;
	private ObjectMapper mapper = new ObjectMapper();
	
	public int[][] matrix;
	public JLabel[][] label = new JLabel[11][11];

	private Dice dice = new Dice();

	public TryRedPlayer() {
		try {
		socket = new Socket("localhost", Server.PORT);
		is = socket.getInputStream();
		
		setLayout(new GridLayout(11, 11));
		
		label = GameUtility.getGameLabels();
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				label[i][j].addMouseListener(new Action());
				add(label[i][j]);
			}
		}
		
			Message m = mapper.readValue(is, Message.class);
			System.out.println(m);
			System.out.println(m.getX1() + " " + m.getY1());
			label[m.getX1()][m.getY1()].setBackground(Color.BLUE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		p1.setLabel(label);
		p2.setLabel(label);
		p3.setLabel(label);
		p4.setLabel(label);
		
		

		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}

	private class Action extends MouseAdapter {

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
				if (e.getSource() == label[0][0]
						&& label[0][0].getBackground().equals(Color.RED)) {
					ExitHouseUtility.setRedPlayerHouse(1, label);
				} else if (e.getSource() == label[0][1]
						&& label[0][1].getBackground().equals(Color.RED)) {
					ExitHouseUtility.setRedPlayerHouse(2, label);
				} else if (e.getSource() == label[1][0]
						&& label[1][0].getBackground().equals(Color.RED)) {
					ExitHouseUtility.setRedPlayerHouse(3, label);
				} else if (e.getSource() == label[1][1]
						&& label[1][1].getBackground().equals(Color.RED)) {
					ExitHouseUtility.setRedPlayerHouse(4, label);
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

		new TryRedPlayer();

	}

}

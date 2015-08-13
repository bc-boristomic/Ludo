package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

public class TryBluePlayer extends JFrame {
	private static final long serialVersionUID = 311184114665588161L;

	private Pawn p1 = new Pawn(6, 10, Color.BLUE, new Color(179, 217, 255), 0);
	private Pawn p2 = new Pawn(6, 10, Color.BLUE, new Color(179, 217, 255), 0);
	private Pawn p3 = new Pawn(6, 10, Color.BLUE, new Color(179, 217, 255), 0);
	private Pawn p4 = new Pawn(6, 10, Color.BLUE, new Color(179, 217, 255), 0);
	private Dice dice = new Dice();

	public JLabel[][] label = new JLabel[11][11];

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private ObjectMapper mapper = new ObjectMapper();

	public TryBluePlayer() {
//		String serverIp = JOptionPane.showInputDialog("Enter server IP address");
//		try {
//			socket = new Socket("localhost", Server.PORT);
//			os = socket.getOutputStream();
//		} catch (IOException e) {
//			// TODO exception handling 
//			e.printStackTrace();
//		}
		
		setLayout(new GridLayout(11, 11));
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

		setTitle("Blue player");
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
			}

//			Message m = new Message(p1.getX(), p2.getX(), p3.getX(), p4.getX(),
//					p1.getY(), p2.getY(), p3.getY(), p4.getY(), "blue");
//
//			ObjectMapper mapper = new ObjectMapper();
//
//			try {
//				mapper.writeValue(os, m);
//			} catch (IOException e2) {
//				e2.printStackTrace();
//			}

	
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

		new TryBluePlayer();
	}

}

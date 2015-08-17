package ba.bitcamp.ludogame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TryGreenPlayer extends JFrame {
	private static final long serialVersionUID = 311184114665588161L;

	private Pawn p1;
	private Pawn p2;
	private Pawn p3;
	private Pawn p4;

	private int[][] matrix;
	private static JLabel[][] label = new JLabel[11][11];

	private Dice dice = new Dice();

	private static BufferedReader reader;
	private BufferedWriter writer;

	private static ObjectMapper mapper;
	private Socket connectTo;

	public TryGreenPlayer() throws IOException {

		connectTo = new Socket("localhost", 8000);
		reader = new BufferedReader(new InputStreamReader(
				connectTo.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(
				connectTo.getOutputStream()));
		mapper = new ObjectMapper();

		setLayout(new GridLayout(11, 11));

		BufferedImage pawn = ImageIO.read(new File("graphics/green.png"));
		BufferedImage house = ImageIO.read(new File("graphics/greenhome.png"));

		p1 = new Pawn(0, 6, Color.GREEN, new Color(179, 255, 179), 0, pawn,
				house);
		p2 = new Pawn(0, 6, Color.GREEN, new Color(179, 255, 179), 0, pawn,
				house);
		p3 = new Pawn(0, 6, Color.GREEN, new Color(179, 255, 179), 0, pawn,
				house);
		p4 = new Pawn(0, 6, Color.GREEN, new Color(179, 255, 179), 0, pawn,
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

		label[0][10].setIcon(new ImageIcon(pawn));
		label[0][9].setIcon(new ImageIcon(pawn));
		label[1][10].setIcon(new ImageIcon(pawn));
		label[1][9].setIcon(new ImageIcon(pawn));

		p1.setLabel(label);
		p2.setLabel(label);
		p3.setLabel(label);
		p4.setLabel(label);

		setTitle("Green player");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		while (true) {
			try {
				String json = reader.readLine();
				Data temp = mapper.readValue(json, Data.class);
				System.out.println("green from server");
				System.out.println(temp.getGameData());
				System.out.println(temp);
				System.out.println("json string from server to green");
				System.out.println(json);
				label = GameUtility.getGameLabels(temp.getGameData());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
			}

			int[][] arr = new int[label.length][label.length];

			for (int i = 0; i < label.length; i++) {
				for (int j = 0; j < label[i].length; j++) {
					if (label[i][j].getBackground().equals(Color.RED)) {
						arr[i][j] = 3;
					} else if (label[i][j].getBackground().equals(Color.GREEN)) {
						arr[i][j] = 2;
					} else if (label[i][j].getBackground().equals(Color.WHITE)) {
						arr[i][j] = 1;
					} else if (label[i][j].getBackground().equals(Color.BLUE)) {
						arr[i][j] = 4;
					} else if (label[i][j].getBackground().equals(Color.YELLOW)) {
						arr[i][j] = 5;
					} else if (label[i][j].getBackground().equals(
							MyColors.RED_LIGHT)) {
						arr[i][j] = 7;
					} else if (label[i][j].getBackground().equals(
							Color.LIGHT_GRAY)) {
						arr[i][j] = 0;
					} else if (label[i][j].getBackground().equals(
							MyColors.GREEN_LIGHT)) {
						arr[i][j] = 8;
					} else if (label[i][j].getBackground().equals(
							MyColors.BLUE_LIGHT)) {
						arr[i][j] = 9;
					} else if (label[i][j].getBackground().equals(
							MyColors.YELLOW_LIGHT)) {
						arr[i][j] = 11;
					} else {
						arr[i][j] = 6;
					}
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			Data temp = new Data(arr, 1, false);
			try {
				String json = mapper.writeValueAsString(temp);
				System.out.println("data sent to server");
				System.out.println(json);
				writer.write(json);
				writer.newLine();
				writer.flush();

			} catch (JsonGenerationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

	private static class Listener extends Thread {

		@Override
		public void run() {
			while (true) {
				
			}
		}
	}

	public static void main(String[] args) {

		try {
			new TryGreenPlayer();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

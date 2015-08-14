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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

public class TryBluePlayer extends JFrame {
	private static final long serialVersionUID = 311184114665588161L;

	private static Pawn p1;
	private static Pawn p2;
	private static Pawn p3;
	private static Pawn p4;

	public int[][] matrix;
	public static JLabel[][] label = new JLabel[11][11];

	private Dice dice = new Dice();

	private Socket socket;
	private static BufferedReader reader;
	private BufferedWriter writer;
	private ObjectMapper mapper = new ObjectMapper();

	public TryBluePlayer() throws IOException {


//		try {
			socket = new Socket("localhost", Server.PORT);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			os = socket.getOutputStream();
//		} catch (IOException e) {
//			// TODO exception handling
//			e.printStackTrace();
//		}

		BufferedImage pawn = ImageIO.read(new File("graphics/blue.png"));
		BufferedImage house = ImageIO.read(new File("graphics/bluehome.png"));

		p1 = new Pawn(6, 10, Color.BLUE, MyColors.BLUE_LIGHT, 0, pawn,
				house);
		p2 = new Pawn(6, 10, Color.BLUE, MyColors.BLUE_LIGHT, 0, pawn,
				house);
		p3 = new Pawn(6, 10, Color.BLUE, MyColors.BLUE_LIGHT, 0, pawn,
				house);
		p4 = new Pawn(6, 10, Color.BLUE, MyColors.BLUE_LIGHT, 0, pawn,
				house);

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
		
		
		label[9][9].setIcon(new ImageIcon(pawn));
		label[9][10].setIcon(new ImageIcon(pawn));
		label[10][10].setIcon(new ImageIcon(pawn));
		label[10][9].setIcon(new ImageIcon(pawn));

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
			
			

			String msg = p1.getX() + " " + p1.getY() + " " + p2.getX() + " " + p2.getY() + " " + p3.getX() + " "
					 + p3.getY() + " " +  p4.getX() + " " + p4.getY() + " " + "blue";
			try {
				writer.write(msg);
				writer.newLine();
				writer.flush();
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

	public static void main(String[] args) {

		try {
			new TryBluePlayer();
			new Listener().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class Listener extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					
					String msg = reader.readLine();
					String[] splitedmsg = msg.split(" ");
					int[] parsesplit = new int[splitedmsg.length-1];
					for(int i = 0; i < splitedmsg.length - 1; i++){
						parsesplit[i] = Integer.parseInt(splitedmsg[i]);
					}
					switch(splitedmsg[8]){
					 	case "blue":
					 		label[parsesplit[0]][parsesplit[1]].setBackground(Color.BLUE);
					 		label[parsesplit[2]][parsesplit[3]].setBackground(Color.BLUE);
					 		label[parsesplit[4]][parsesplit[5]].setBackground(Color.BLUE);
					 		label[parsesplit[6]][parsesplit[7]].setBackground(Color.BLUE);
					 		break;
					 	case "red":
					 		label[parsesplit[0]][parsesplit[1]].setBackground(Color.RED);
					 		label[parsesplit[2]][parsesplit[3]].setBackground(Color.RED);
					 		label[parsesplit[4]][parsesplit[5]].setBackground(Color.RED);
					 		label[parsesplit[6]][parsesplit[7]].setBackground(Color.RED);
					 		break;
					 	case "green":
					 		label[parsesplit[0]][parsesplit[1]].setBackground(Color.GREEN);
					 		label[parsesplit[2]][parsesplit[3]].setBackground(Color.GREEN);
					 		label[parsesplit[4]][parsesplit[5]].setBackground(Color.GREEN);
					 		label[parsesplit[6]][parsesplit[7]].setBackground(Color.GREEN);
					 		break;
					 	case "yellow":
					 		label[parsesplit[0]][parsesplit[1]].setBackground(Color.YELLOW);
					 		label[parsesplit[2]][parsesplit[3]].setBackground(Color.YELLOW);
					 		label[parsesplit[4]][parsesplit[5]].setBackground(Color.YELLOW);
					 		label[parsesplit[6]][parsesplit[7]].setBackground(Color.YELLOW);
					 		break;
					 		
					}
					
				} catch (NullPointerException | IOException e) {
					
				}
				
			}
		}
	}

}

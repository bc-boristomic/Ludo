package ba.bitcamp.ludogame;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.codehaus.jackson.map.ObjectMapper;

public class Server {

	protected static final int PORT = 8000;

	private ServerSocket server;

	private Socket client1;
	private Socket client2;
	private Socket client3;
	private Socket client4;
	
	private InputStream is;
	private OutputStream os;
	private ObjectMapper mapper = new ObjectMapper();

	// private LinkedBlockingQueue<Message> queue = new
	// LinkedBlockingQueue<Message>(4);

	private Pawn[] players = new Pawn[4];

	public Server() {
		try {
		server = new ServerSocket(PORT);
		System.out.println("Server started");
		while (true) {
				client1 = server.accept();
				os = client1.getOutputStream();
		//		client2 = server.accept();
				System.out.println("Connected");
				while (true) {
					Message m = new Message(8, 6, 6, 6, 4, 10, 10, 10, "blue");
					System.out.println(m);
					mapper.writeValue(os, m);
				client1.close();
//				mapper.writeValue(client3.getOutputStream(), m);
//				mapper.writeValue(client4.getOutputStream(), m);
			}

		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}

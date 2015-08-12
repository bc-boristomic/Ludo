package ba.bitcamp.ludogame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.codehaus.jackson.map.ObjectMapper;

public class Server {

	protected static final int PORT = 8000;

	private ServerSocket server;

	private Socket client1;
	private Socket client2;
	private Socket client3;
	private Socket client4;
	
	private BufferedReader reader;
	private BufferedWriter writer;
	private ObjectMapper mapper = new ObjectMapper();

	// private LinkedBlockingQueue<Message> queue = new
	// LinkedBlockingQueue<Message>(4);

	private Pawn[] players = new Pawn[4];

	public Server() {
		try {
			server = new ServerSocket(PORT);
				client1 = server.accept();
		//		client2 = server.accept();
				System.out.println("Connected");
				while (true) {
				reader = new BufferedReader(new InputStreamReader(client1.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(client1.getOutputStream()));
				Message m = mapper.readValue(client1.getInputStream(), Message.class);
				mapper.writeValue(client1.getOutputStream(), m);
//				mapper.writeValue(client3.getOutputStream(), m);
//				mapper.writeValue(client4.getOutputStream(), m);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}

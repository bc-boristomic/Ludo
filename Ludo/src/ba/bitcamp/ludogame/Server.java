package ba.bitcamp.ludogame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	protected static final int PORT = 8000;
	
	private ServerSocket server;
	private Socket client;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	private Pawn[] players = new Pawn[4];
	
	public Server() {
		 try {
			server = new ServerSocket(PORT);
			client = server.accept();
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}

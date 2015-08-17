package ba.bitcamp.ludogame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NewServer {

	private BufferedReader reader;
	private BufferedWriter writer;
	private ServerSocket server;
	private Socket client;

	public NewServer() {
		try {
			server = new ServerSocket(8000);
			System.out.println("server started");
			while (true) {
				client = server.accept();
				System.out.println("client connected");

				reader = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(
						client.getOutputStream()));

				String data = reader.readLine();
				System.out.println("data recieved \n" + data);
				writer.write(data);
				writer.newLine();
				writer.flush();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new NewServer();
	}
}

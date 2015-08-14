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
import java.util.concurrent.LinkedBlockingQueue;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class Server {

	protected static final int PORT = 8000;

	private ServerSocket server;

	private Socket client1;
	private Socket client2;
	private Socket client3;
	private Socket client4;

	private BufferedWriter writer1;
	private BufferedWriter writer2;
	private BufferedWriter writer3;
	private BufferedWriter writer4;
	private BufferedReader reader1;
	private BufferedReader reader2;
	private BufferedReader reader3;
	private BufferedReader reader4;
	private ObjectMapper mapper = new ObjectMapper();

	private LinkedBlockingQueue<BufferedWriter> clients;
	private LinkedBlockingQueue<BufferedReader> readers;

	private Pawn[] players = new Pawn[4];

	public Server() {

		try {
			server = new ServerSocket(PORT);
			System.out.println("Server started");
			clients = new LinkedBlockingQueue<>();
			readers = new LinkedBlockingQueue<>();
			client1 = server.accept();
			client2 = server.accept();
			// client3 = server.accept();
			// client4 = server.accept();
			writer1 = new BufferedWriter(new OutputStreamWriter(
					client1.getOutputStream()));
			writer2 = new BufferedWriter(new OutputStreamWriter(
					client2.getOutputStream()));
			// writer3 = new BufferedWriter(new
			// OutputStreamWriter(client3.getOutputStream()));
			// writer4 = new BufferedWriter(new
			// OutputStreamWriter(client4.getOutputStream()));
			clients.add(writer1);
			clients.add(writer2);
			// clients.add(writer3);
			// clients.add(writer4);
			reader1 = new BufferedReader(new InputStreamReader(
					client1.getInputStream()));
			reader2 = new BufferedReader(new InputStreamReader(
					client2.getInputStream()));
			// reader3 = new BufferedReader(new
			// InputStreamReader(client3.getInputStream()));
			// reader4 = new BufferedReader(new
			// InputStreamReader(client4.getInputStream()));
			readers.add(reader1);
			readers.add(reader2);
			// readers.add(reader3);
			// readers.add(reader4);
			new Client().start();
		

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	private class Client extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					BufferedReader r = readers.take();

					String msg = r.readLine();
					for (int i = 0; i < 2; i++) {
						BufferedWriter w = clients.take();
						w.write(msg);
						w.newLine();
						w.flush();
						clients.add(w);
					}

					readers.add(r);
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

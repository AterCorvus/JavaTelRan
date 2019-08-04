package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

import config.ServerConfig;

public class ClientSocket {
	private Socket socket;

	private static ClientSocket socketInst = null;

	private ClientSocket() throws Exception {
		this.socket = new Socket(ServerConfig.HOST, ServerConfig.PORT);
	}

	public static ClientSocket getSocket() throws Exception {
		if (socketInst == null)
			socketInst = new ClientSocket();
		return socketInst;
	}

	public String sendSetRequest(String r, Object o) throws IOException {
		try (BufferedReader readerTCP = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream writerTCP = new PrintStream(socket.getOutputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());) {
			writerTCP.println("Set/" + r);
			oos.writeObject(o);
			return readerTCP.readLine();
		}
	}

	public Object sendGetRequest(String r) throws IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				PrintStream writerTCP = new PrintStream(socket.getOutputStream());) {
			writerTCP.println("GET/" + r);
			return ois.readObject();
		}
	}
	
	public String sendRemoveRequest(String r) throws IOException {
		try (BufferedReader readerTCP = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream writerTCP = new PrintStream(socket.getOutputStream())) {
			writerTCP.println("REMOVE/" + r);
			return readerTCP.readLine();
		}
	}

}

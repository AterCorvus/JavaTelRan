package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCP_One_Client_Thread implements Runnable{
	
	private String name;
	private String host;
	private int port;

	public TCP_One_Client_Thread(String name, String host, int port) {
		super();
		this.name = name;
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		try(
				Socket clientConnection=new Socket(host, port);
				BufferedReader readerTCP = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
				PrintStream writerTCP = new PrintStream(clientConnection.getOutputStream())
			){
				for (int i = 0; i < 3; i++) {
					writerTCP.println(name+" msg."+i);
					System.out.println("Response for "+ readerTCP.readLine() +" received");
				}
				clientConnection.close();
			}
			catch(IOException e) {}
	}

}

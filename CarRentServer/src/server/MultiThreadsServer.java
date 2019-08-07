package server;

import java.net.ServerSocket;

import response.Protocol;

public class MultiThreadsServer {

	private int port;
	private String protocolName; 

	public MultiThreadsServer(int port, String protocol) {
		super();
		this.port = port;
		this.protocolName =protocol;
	}

	public void go() throws Exception {
	
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server is listening on port "+port);

		while (true) {			
			(new Thread(new SocketThread(serverSocket.accept(), (Protocol)Class.forName(protocolName).newInstance()))).start();
		}
	}

}

package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import config.Config;
import response.Protocol;

public class MultiThreadServer {
	
	private int port;
	Protocol protocol;

	
	public MultiThreadServer(int port, Protocol protocol) {
		super();
		this.port = port;
		this.protocol = protocol;
	}


	public void go() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server is listening on port "+port);
		ExecutorService executor = Executors.newFixedThreadPool(Config.POOL_NUM_THREADS);
		while(true) {
			executor.execute(new SocketThread(serverSocket.accept(), protocol));
		}
	}
	
}

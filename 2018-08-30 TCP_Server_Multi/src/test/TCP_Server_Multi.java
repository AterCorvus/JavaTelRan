package test;

import server.MultiThreadsServer;

public class TCP_Server_Multi {
	
	static final int PORT = 2000;
	static final String MULTI_THREADS_PROTOCOL = "response.MirrorServerResponse";
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Dont forget to launch the client side");
		(new MultiThreadsServer(PORT, MULTI_THREADS_PROTOCOL)).go();
	}
	
}

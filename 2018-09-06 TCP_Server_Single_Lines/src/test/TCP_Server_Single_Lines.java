package test;

import java.io.IOException;

import config.Config;
import server.SingleThreadServer;

public class TCP_Server_Single_Lines {	

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Dont forget to launch the client side");
		SingleThreadServer sTS = new SingleThreadServer(Config.PORT, Config.ONE_THREAD_PROTOCOL);
		sTS.go();
	}

}

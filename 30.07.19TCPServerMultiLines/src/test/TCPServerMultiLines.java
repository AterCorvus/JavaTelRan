package test;

import java.io.IOException;

import config.Config;
import server.MultiThreadServer;

public class TCPServerMultiLines {	

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Dont forget to launch the client side");
		MultiThreadServer sTS = new MultiThreadServer(Config.PORT, Config.ONE_THREAD_PROTOCOL);
		sTS.go();
	}

}

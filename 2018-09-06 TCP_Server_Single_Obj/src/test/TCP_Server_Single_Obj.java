package test;

import java.io.IOException;
import response.ObjectEchoResponse;
import response.Protocol;
import server.SingleThreadServer;

public class TCP_Server_Single_Obj {

	static final int PORT = 2000;
	static final Protocol ONE_THREAD_PROTOCOL = new ObjectEchoResponse();
	

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		System.out.println("Dont forget to launch the client side");
		(new SingleThreadServer(PORT, ONE_THREAD_PROTOCOL)).go();
	}

}

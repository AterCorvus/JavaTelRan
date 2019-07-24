package application;

public class TCP_Multi_Client_Appl {
	
	static final int NUMBER_OF_CLIENTS = 5;

	public static void main(String[] args) throws Exception{
		for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
			(new Thread(new TCP_One_Client_Thread("Client#"+i, Config.HOST, Config.PORT))).start();
		}

	}

}

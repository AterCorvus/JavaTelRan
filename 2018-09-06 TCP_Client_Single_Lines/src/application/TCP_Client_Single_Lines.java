package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCP_Client_Single_Lines {

	public static void main(String[] args) throws Exception {
		Socket client = null;
		BufferedReader readerTCP = null;
		BufferedReader readerKeyboard = null;
		PrintStream writerTCP = null;
		try{
			client = new Socket(Config.HOST, Config.PORT);
			readerTCP = new BufferedReader(new InputStreamReader(client.getInputStream()));
			readerKeyboard = new BufferedReader(new InputStreamReader(System.in));
			writerTCP = new PrintStream(client.getOutputStream());
		
			String line = null;
			while(true) {
				System.out.println("Enter any text or '" +Config.EXIT+"' to exit");
				line = readerKeyboard.readLine();
				if (line.equalsIgnoreCase(Config.EXIT)) break;
				writerTCP.println(line);
				System.out.println(readerTCP.readLine());	
			}	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(client != null)client.close();
			if(readerTCP != null)readerTCP.close();
			if(readerKeyboard != null)readerKeyboard.close();
			if(writerTCP != null)writerTCP.close();
		}
	}

}

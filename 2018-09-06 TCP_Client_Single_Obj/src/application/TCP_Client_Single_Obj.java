
package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import dto.Person;

public class TCP_Client_Single_Obj {
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		ArrayList<Person> alp= new ArrayList<>();
	
		try(
				BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));		
		){		
			String line = null;
			Person person = null;
			while(true) {
				System.out.println("\n"
						+ "Press enter to add the person to the data for server, or "+Config.EXIT+" to finish data creation.\n"+
			              "You had already added to the data "+alp.size()+" persons");
				line =keyBoard.readLine();
				if (line.equalsIgnoreCase(Config.EXIT)) break;
				if (line.equals("")) {
					person = Person.getRandomPerson();
					alp.add(person);
					System.out.println(person);
				}
			}
		}
		
		if (alp.size() > 0) {
			try(
				Socket socket = new Socket(Config.HOST, Config.PORT);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			){
				oos.writeObject(alp);
				String response = ois.readObject().toString();
				System.out.println(response);
			}
		}	
	}
}

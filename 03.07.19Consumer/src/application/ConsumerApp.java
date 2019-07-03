package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class ConsumerApp {
	private static final int NUM_CHINESES = 10;
	
	private static Consumer<Chinese> renameToMao = (c) -> c.setName("Mao");
	//private static Consumer<Chinese> giveSecondName = (c) -> c.setName(c.getName() + " " + "Tung");
	
	public static void main(String[] args) {
		
		String secondName = "Zhu";
		
		ArrayList<Chinese> china =new ArrayList<>();
		for (int i = 0; i < NUM_CHINESES; i++)
			china.add(new Chinese("Lee"));
		
		System.out.println(china);
		
		chinaTransform(china, renameToMao);
		
		System.out.println(china);
		
		secondName = "Zhu";
		//chinaTransform(china, (c) -> c.setName(c.getName() + " " + secondName1));
		chinaTransform(china, new SecondName(secondName));
		System.out.println(china);
	}
	
	public static void chinaTransform(Collection<Chinese> china,
			Consumer<Chinese> consumer){
		for (Chinese chinese : china)
			consumer.accept(chinese);
	}
}

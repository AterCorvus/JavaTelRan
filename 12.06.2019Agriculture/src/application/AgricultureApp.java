package application;

import model.Kolkhoz;

public class AgricultureApp {
	public static void main(String[] args){
		Kolkhoz[] village = new Kolkhoz[3];
		
		for (int i = 0; i < village.length; ++i) {
			village[i] = new Kolkhoz();
			village[i].harvest();
		}
		
		for (int i = 0; i < village.length; ++i) {
			System.out.println(village[i].getZakroma());
		}
	}
}

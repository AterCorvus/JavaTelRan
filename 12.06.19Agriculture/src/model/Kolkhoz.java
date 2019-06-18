package model;

public class Kolkhoz {
	
	private static int zakroma = 0;
	
	public void harvest() {
		zakroma += 1000000;
	}
	
	public int getZakroma() {
		return zakroma;
	}
}

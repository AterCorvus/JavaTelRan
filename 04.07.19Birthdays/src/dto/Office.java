package dto;

import java.util.ArrayList;

public class Office {
	private static final int PERSONS_IS_ROOM = 30;
	private ArrayList<Room> office = new ArrayList<>();

	public Office (int roomsNumb) {
		super();
		for (int i = 0; i < roomsNumb; i++)
			office.add(new Room(PERSONS_IS_ROOM));
	}
	
	public int countPairBirthdRooms (){
		int pairBirthdRooms = 0;
		for(Room room : office)
			if (room.hasPairBirthdays())
				pairBirthdRooms++;
		return pairBirthdRooms;
	}
}

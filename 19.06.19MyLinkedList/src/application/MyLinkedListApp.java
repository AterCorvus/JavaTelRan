package application;

import model.MtUDLinkedList;
import model.MyLinkedList;

public class MyLinkedListApp {

	public static void main(String[] args) {
		
		MtUDLinkedList<Integer> mlli = new MtUDLinkedList<>();
		
		mlli.add(3);
		mlli.add(11);
		mlli.addLast(-8);
		mlli.addFirst(4);
		mlli.addFirst(-2);
		mlli.addFirst(6);
		
		
		mlli.addByIndex(3, 111);
		
		System.out.println(mlli);
		System.out.println(mlli.indexOf(-2));
		
		mlli.removeFirst();
		System.out.println(mlli);
		mlli.removeLast();
		System.out.println(mlli);
		mlli.remove(3);
		System.out.println(mlli);
		mlli.remove(new Integer(-2));
		System.out.println(mlli);
		mlli.add(3);
		System.out.println(mlli);
		mlli.eliminateAll();
		System.out.println(mlli);
		mlli.add(7);
		System.out.println(mlli);
		mlli.add(8);
		System.out.println(mlli);
	}
	
}
package application;

import model.MyLinkedList;

public class MyLinkedListApp {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> mlli = new MyLinkedList<>();
		
		mlli.add(3);
		mlli.add(11);
		mlli.addLast(-8);
		mlli.addFirst(4);
		mlli.addFirst(-2);
		mlli.addFirst(6);
		
		mlli.addByIndex(3, 111);
		
		System.out.println(mlli);
		System.out.println(mlli.indexOf(-2));
		
	}
	
}
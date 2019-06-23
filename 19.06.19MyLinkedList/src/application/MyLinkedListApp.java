package application;

import java.util.Iterator;

import model.MyLinkedList;

public class MyLinkedListApp {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> mlli = new MyLinkedList<>();
		
		mlli.add(3);
		mlli.add(11);
		mlli.add(-8);
		mlli.add(4);
		mlli.add(-2);
		mlli.add(6);
		
		System.out.println(mlli);
		System.out.println(mlli);
		mlli.add(9);
		System.out.println(mlli);
		mlli.eliminateAll();
		System.out.println(mlli);
		mlli.add(9);
		
		Iterator<Integer> it = mlli.listIterator();
		while(it.hasNext())
			System.out.print(it.next() + "  ");
	}
}
package application;

import java.util.Iterator;

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
		mlli.add(9);
		System.out.println(mlli);
		mlli.eliminateAll();
		System.out.println(mlli);
		mlli.add(9);
		
		Iterator<Integer> it = mlli.butterflyIterator();
		while(it.hasNext())
			System.out.print(it.next() + "  ");
	}
	
}
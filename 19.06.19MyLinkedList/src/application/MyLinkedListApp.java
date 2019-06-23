package application;

import model.MyLinkedStack;

public class MyLinkedListApp {

	public static void main(String[] args) {
		
		MyLinkedStack<Integer> mlli = new MyLinkedStack<>();
		
		mlli.push(3);
		mlli.push(11);
		mlli.push(-8);
		mlli.push(4);
		mlli.push(-2);
		mlli.push(6);
		
		
		System.out.println(mlli);
		
		System.out.println(mlli.peek());
		mlli.poll();
		System.out.println(mlli);
		mlli.poll();
		System.out.println(mlli);
		mlli.poll();
		System.out.println(mlli);
		mlli.push(3);
		System.out.println(mlli);
		mlli.poll();
		System.out.println(mlli);
		mlli.poll();
		System.out.println(mlli);
		mlli.poll();
		mlli.poll();
		System.out.println(mlli);
		mlli.push(6);
		System.out.println(mlli);
	}
	
}
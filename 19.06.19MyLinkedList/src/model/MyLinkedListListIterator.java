package model;

import java.util.ListIterator;

public class MyLinkedListListIterator<T> implements ListIterator<T> {
	
	MyLinkedList<T> mll;
	Node<T> current;
	
	public MyLinkedListListIterator(MyLinkedList<T> mll, Node<T> head) {
		super();
		this.mll = mll;
		current = head;
	}

	@Override
	public void add(T e) {
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(T e) {
		// TODO Auto-generated method stub
		
	}

}

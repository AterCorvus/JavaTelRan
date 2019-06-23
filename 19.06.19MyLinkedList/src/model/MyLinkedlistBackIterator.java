package model;

import java.util.Iterator;

public class MyLinkedlistBackIterator<T> implements Iterator<T>{

	NodeDUO<T> current;
	
	public MyLinkedlistBackIterator(NodeDUO<T> tail) {
		super();
		 this.current = tail;
	}

	public boolean hasNext() {
		return current != null;
	}

	public T next() {
		T result = current.getData();
		current = current.getPrev();
		return result;
	}
	
}

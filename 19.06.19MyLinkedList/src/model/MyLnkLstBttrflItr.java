package model;

import java.util.Iterator;

public class MyLnkLstBttrflItr<T> implements Iterator<T> {

	private NodeDUO<T> current;
	private boolean backwards = false;
	private boolean good = true;
	
	public MyLnkLstBttrflItr(NodeDUO<T> head) {
		super();
		this.current = head;
	}

	@Override
	public boolean hasNext() {
		if(current == null)
			return false;
		else
			return true;
	}

	@Override
	public T next() {
		T data = null;
		if ((current.getNext() == null) && (backwards == false)) {
			data = current.getData();
			current = current.getPrev();
			if ((current != null) && (current.getPrev() != null) && (good == false))
				current = current.getPrev();
			
			backwards = true;
			return data;
		}
		else if ((current.getNext().getNext() == null) && (backwards == false)) {
			data = current.getData();
			current = current.getNext();
			good = false;
			return data;
		}
		else if(backwards == false){
			data = current.getData();
			current = current.getNext();
			if(current != null)
				current = current.getNext();
			
			return data;
		}
		else {
			data = current.getData();
			current = current.getPrev().getPrev();
			return data;
		} 
	}

}

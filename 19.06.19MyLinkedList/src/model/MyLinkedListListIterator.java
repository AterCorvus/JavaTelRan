package model;

import java.util.ListIterator;

public class MyLinkedListListIterator<T> extends MyLinkedList<T> implements ListIterator<T> {
	
	private NodeDUO<T> current = (NodeDUO<T>) super.head;
	private boolean wasPrev = false;
	private boolean wasNext = false;

	public MyLinkedListListIterator(MyLinkedList<T> list) {
		super(list);
	}

	@Override
	public void add(T e) {
		if (current.getNext() == null) {
			add(e);
		} else if (current.getPrev() == null) {
			addFirst(e);
		} else {
			NodeDUO<T> node = new NodeDUO<T>(e);
			NodeDUO<T> prev = current.getPrev();

			node.setNext(current);
			node.setPrev(prev);
			prev.setNext(node);
			current.setPrev(node);

			size++;
		}
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public boolean hasPrevious() {
		return current.getPrev() != null;
	}

	@Override
	public T next() {
		T result = current.getData();
		current = current.getNext();
		wasNext = true;
		return result;
	}

	@Override
	public int nextIndex() {
		NodeDUO<T> next = current.getNext();
		if (next != null)
			return indexOf(next.getData());
		else
			return -1;
	}

	@Override
	public T previous() {
		T result = current.getData();
		current = current.getPrev();
		wasPrev = true;
		return result;
	}

	@Override
	public int previousIndex() {
		NodeDUO<T> prev = current.getPrev();
		if (prev != null)
			return indexOf(prev.getData());
		else
			return -1;
	}

	@Override
	public void remove() {
		if(wasPrev) {
			super.remove(current.getNext());
		}
		else if(wasNext) {
			super.remove(current.getPrev());
		}
	}

	@Override
	public void set(T e) {
		if(wasPrev) {
			current.getNext().setData(e);;
		}
		else if(wasNext) {
			current.getPrev().setData(e);;
		}
	}

}

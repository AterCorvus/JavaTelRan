package model;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T> extends AbstractList<T> implements Iterable<T> {

	
	
	public MyLinkedList() {
		super();
	}

	public MyLinkedList(AbstractList<T> list) {
		super(list);
	}

	@Override
	public void add(T data) {
		NodeDUO<T> node = new NodeDUO<T>(data);

		if (head == null) {
			head = node;
		} else {
			node.setPrev((NodeDUO) super.tail);
			tail.setNext(node);
		}

		tail = node;
		size++;
	}

	@Override
	public void addFirst(T data) {
		NodeDUO<T> node = new NodeDUO<T>(data);
		NodeDUO<T> locHead = (NodeDUO<T>) head;

		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
			locHead.setPrev(node);
		}

		head = node;
		size++;
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index < 0 || index > size)
			return false;
		if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			add(data);
		} else {
			NodeDUO<T> node = new NodeDUO<T>(data);
			NodeDUO<T> target = getNodeByIndex(index);
			NodeDUO<T> prev = target.getPrev();

			node.setNext(target);
			node.setPrev(prev);
			prev.setNext(node);
			target.setPrev(node);

			size++;
		}

		return true;
	}

	protected NodeDUO<T> getNodeByIndex(int index) {
		if (index < 0 || index > size)
			return null;
		
		NodeDUO<T> result = null;
		if (index < (size / 2)) {
			NodeDUO<T> locHead = (NodeDUO<T>) head;
			result = locHead;
			int counter = 0;

			while (counter < index) {
				result = result.getNext();
				counter++;
			}
		} else {
			NodeDUO<T> locTail = (NodeDUO<T>) tail;
			result = locTail;
			int counter = size - 1;

			while (counter > index) {
				result = result.getPrev();
				counter--;
			}
		}

		return result;
	}

	protected void eliminate(Node<T> node){
		NodeDUO<T> duoNode = (NodeDUO<T>) node;
		if (node == null)
			return;
		
		duoNode.setPrev(null);
		node.setNext(null);
		node.setData(null);
	}
	
	@Override
	public T removeFirst() {
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne();
		} else {
			NodeDUO<T> locHead = (NodeDUO<T>) head;
			NodeDUO<T> node = locHead;
			head = node.getNext();
			locHead.setPrev(null);
			size--;
			
			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	@Override
	public T removeLast() {
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne();
		} else {
			NodeDUO<T> locTail = (NodeDUO<T>) tail;
			NodeDUO<T> node = locTail;
			tail = node.getPrev();
			tail.setNext(null);
			size--;
			
			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	protected T remove(Node<T> node) {
		NodeDUO<T> duoNode = (NodeDUO<T>) node;
		if (node == null) {
			return null;
		} else if (head == tail) {
			return removeLastOne();
		} else {
			NodeDUO<T> prev = duoNode.getPrev();
			NodeDUO<T> next = duoNode.getNext();

			if (next == null)
				return removeLast();
			else
				next.setPrev(prev);

			if (prev == null)
				return removeFirst();
			else
				prev.setNext(next);

			size--;

			T data = node.getData();
			eliminate(duoNode);
			return data;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator(head);
	}
	
	public Iterator<T> backIterator() {
		return new MyLinkedlistBackIterator((NodeDUO<T>) tail);
	}
	
	public Iterator<T> butterflyIterator() {
		return new MyLnkLstBttrflItr((NodeDUO<T>) head);
	}
	
	public ListIterator<T> listIterator(){
		MyLinkedListListIterator<T> iter = new MyLinkedListListIterator<T>(this);
		return iter;
	}

}

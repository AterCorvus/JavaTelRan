package model;

public class MyLinkedList<T> implements MyList<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	@Override
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null) {
			head = node;
		}
		else {
			node.setPrev(tail);
			tail.setNext(node);
		}
		
		tail = node;
		size++;
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null) {
			tail = node;
		}
		else {
			node.setNext(head);
			head.setPrev(node);
		}
		
		head = node;
		size++;
	}

	@Override
	public void addLast(T data) {
		add(data);
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if(index < 0 || index > size)
			return false;
		if (index == 0) { 
			addFirst(data);
		}
		else if(index == size) {
			add(data);
		}
		else {
			Node<T> node = new Node<T>(data);
			Node<T> target = getNodeByIndex(index);
			Node<T> prev = target.getPrev();
			
			node.setNext(target);
			node.setPrev(prev);
			prev.setNext(node);
			target.setPrev(node);
			
			size++;
		}
		
		return true;
	}

	private Node<T> getNodeByIndex(int index) {
		Node<T> result = head;
		int counter = 0;
		
		while(counter < index) {
			result = result.getNext();
			counter++;
		}
		return result;
	}

	@Override
	public int indexOf(T data) {
		if(head == null) 
			return -1;
		
		int counter = 0;
		for (Node<T> node = head; node != null; node = node.getNext(), counter++) {
			if (node.getData().equals(data))
				return counter;
		}
		
		return -1;
	}

	@Override
	public boolean contains(T data) {
		if (indexOf(data) != -1)
			return true;
		else
			return false;
	}

	@Override
	public T get(int index) {
		return (index < 0 || index >= size) ? null : getNodeByIndex(index).getData();
	}

	@Override
	public T getFirst() {
		return head == null ? null : head.getData();
	}

	@Override
	public T getLast() {
		return tail == null ? null : tail.getData();
	}

	@Override
	public boolean set(int index, T data) {
		if (index < 0 || index >= size)
			return false;
		
		getNodeByIndex(index).setData(data);
		return true;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminateAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> temp = head;
		while (temp != null){
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}
	

}

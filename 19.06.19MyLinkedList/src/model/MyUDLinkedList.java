package model;

public class MtUDLinkedList<T> extends AbstractList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	@Override
	public void add(T data) {
		Node<T> node = new Node<T>(data);

		if (head == null)
			head = node;
		else
			tail.setNext(node);

		tail = node;
		size++;
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null)
			tail = node;
		else
			node.setNext(head);

		head = node;
		size++;
	}

	@Override
	public void addLast(T data) {
		add(data);
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index < 0 || index > size)
			return false;

		if (index == 0)
			addFirst(data);
		else if (index == size)
			add(data);
		else {
			Node<T> node = new Node<T>(data);
			Node<T> prev = getNodeByIndex(index - 1);

			node.setNext(prev.getNext());
			prev.setNext(node);
			size++;
		}

		return true;
	}

	private Node<T> getNodeByIndex(int index) {
		if (index < 0 || index >= size)
			return null;

		Node<T> current = head;
		int counter = 0;
		while (counter < index) {
			current = current.getNext();
			counter++;
		}
		return current;
	}

	@Override
	public int indexOf(T data) {
		if (head == null)
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
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne();
		} else {
			Node<T> node = head;
			head = node.getNext();
			size--;

			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	private void eliminate(Node<T> node){
		if (node == null)
			return;
		
		node.setNext(null);
		node.setData(null);
	}
	
	@Override
	public T removeLast() {
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne();
		} else {
			Node<T> node = tail;
			tail = getPrev(node);
			tail.setNext(null);
			size--;
			
			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size)
			return null;
		else if (index == 0) {
			return removeFirst();
		} else if (index == size) {
			return removeLast();
		}

		Node<T> target = getNodeByIndex(index);
		if (target == null)
			return null;

		return remove(target);
	}

	@Override
	public T remove(T data) {
		if (head == null)
			return null;

		for (Node<T> node = head; node != null; node = node.getNext()) {
			if (node.getData().equals(data)) {
				return remove(node);
			}
		}

		return null;
	}

	private T removeLastOne() {
		if (head == null)
			return null;

		T data = head.getData();
		eliminate(head);
		
		head = null;
		tail = null;
		size = 0;
		
		return data;
	}

	private Node<T> getPrev(Node<T> node) {
		if (node == null) {
			return null;
		} else if (node == head) {
			return null;
		} else {
			for (Node<T> prev = head; prev != null; prev = prev.getNext()) {
				if (prev.getNext() == node)
					return prev;
			}
		}
		return null;
	}

	protected T remove(Node<T> node) {
		if (node == null) {
			return null;
		} else if (head == tail) {
			return removeLastOne();
		} else {
			Node<T> prev = getPrev(node);
			Node<T> next = node.getNext();

			if (next == null)
				return removeLast();

			if (prev == null)
				return removeFirst();
			else
				prev.setNext(next);

			size--;

			T data = node.getData();
			eliminate(node);
			return data;
		}
	}
	
	public void eliminateAll() {
		if (head == null)
			return;

		for (Node<T> node = head; node != null; node = node.getNext()) {
			node.setData(null);
			remove(node);
		}
	}

}

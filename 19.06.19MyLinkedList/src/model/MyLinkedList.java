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
		} else {
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
		} else {
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
		if (index < 0 || index > size)
			return false;
		if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			add(data);
		} else {
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
		if (index < 0 || index > size)
			return null;
		
		Node<T> result = null;
		if (index < (size / 2)) {
			result = head;
			int counter = 0;

			while (counter < index) {
				result = result.getNext();
				counter++;
			}
		} else {
			result = tail;
			int counter = size - 1;

			while (counter > index) {
				result = result.getPrev();
				counter--;
			}
		}

		return result;
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

	private T removeLastOne(Node<T> node) {
		if (node == null)
			return null;

		head = null;
		tail = null;
		size = 0;
		return node.getData();
	}

	@Override
	public T removeFirst() {
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne(head);
		} else {
			Node<T> node = head;
			head = node.getNext();
			head.setPrev(null);
			size--;
			return node.getData();
		}
	}

	@Override
	public T removeLast() {
		if (head == null)
			return null;
		else if (head == tail) {
			return removeLastOne(head);
		} else {
			Node<T> node = tail;
			tail = node.getPrev();
			tail.setNext(null);
			size--;
			return node.getData();
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

	private T remove(Node<T> node) {
		if (node == null) {
			return null;
		} else if (head == tail) {
			return removeLastOne(head);
		} else {
			Node<T> prev = node.getPrev();
			Node<T> next = node.getNext();

			if (next == null)
				return removeLast();
			else
				next.setPrev(prev);

			if (prev == null)
				return removeFirst();
			else
				prev.setNext(next);

			size--;

			return node.getData();
		}
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

	@Override
	public void eliminateAll() {
		if (head == null)
			return;

		for (Node<T> node = head; node != null; node = node.getNext()) {
			node.setData(null);
			remove(node);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> temp = head;
		while (temp != null) {
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}

}

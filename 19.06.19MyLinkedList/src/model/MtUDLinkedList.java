package model;

public class MtUDLinkedList<T> implements MyList<T> {

	private NodeUD<T> head;
	private NodeUD<T> tail;
	private int size = 0;

	@Override
	public void add(T data) {
		NodeUD<T> node = new NodeUD<T>(data);

		if (head == null)
			head = node;
		else
			tail.setNext(node);

		tail = node;
		size++;
	}

	@Override
	public void addFirst(T data) {
		NodeUD<T> node = new NodeUD<T>(data);
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
			NodeUD<T> node = new NodeUD<T>(data);
			NodeUD<T> prev = getNodeByIndex(index - 1);

			node.setNext(prev.getNext());
			prev.setNext(node);
			size++;
		}

		return true;
	}

	private NodeUD<T> getNodeByIndex(int index) {
		if (index < 0 || index >= size)
			return null;

		NodeUD<T> current = head;
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
		for (NodeUD<T> node = head; node != null; node = node.getNext(), counter++) {
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
			NodeUD<T> node = head;
			head = node.getNext();
			size--;

			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	private void eliminate(NodeUD<T> node){
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
			NodeUD<T> node = tail;
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

		NodeUD<T> target = getNodeByIndex(index);
		if (target == null)
			return null;

		return remove(target);
	}

	@Override
	public T remove(T data) {
		if (head == null)
			return null;

		for (NodeUD<T> node = head; node != null; node = node.getNext()) {
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

	private NodeUD<T> getPrev(NodeUD<T> node) {
		if (node == null) {
			return null;
		} else if (node == head) {
			return null;
		} else {
			for (NodeUD<T> prev = head; prev != null; prev = prev.getNext()) {
				if (prev.getNext() == node)
					return prev;
			}
		}
		return null;
	}

	private T remove(NodeUD<T> node) {
		if (node == null) {
			return null;
		} else if (head == tail) {
			return removeLastOne();
		} else {
			NodeUD<T> prev = getPrev(node);
			NodeUD<T> next = node.getNext();

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

	@Override
	public void eliminateAll() {
		if (head == null)
			return;

		for (NodeUD<T> node = head; node != null; node = node.getNext()) {
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
		NodeUD<T> temp = head;
		while (temp != null) {
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}

}

package model;

public class MyLinkedList<T> extends AbstractList<T> {

	private NodeDUO<T> head = null;
	private NodeDUO<T> tail = null;
	private int size = 0;

	@Override
	public void add(T data) {
		NodeDUO<T> node = new NodeDUO<T>(data);

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
		NodeDUO<T> node = new NodeDUO<T>(data);

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

	private NodeDUO<T> getNodeByIndex(int index) {
		if (index < 0 || index > size)
			return null;
		
		NodeDUO<T> result = null;
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
		for (NodeDUO<T> node = head; node != null; node = node.getNext(), counter++) {
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

	private void eliminate(NodeDUO<T> node){
		if (node == null)
			return;
		
		node.setPrev(null);
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
			NodeDUO<T> node = head;
			head = node.getNext();
			head.setPrev(null);
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
			NodeDUO<T> node = tail;
			tail = node.getPrev();
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

		NodeDUO<T> target = getNodeByIndex(index);
		if (target == null)
			return null;

		return remove(target);
	}

	protected T remove(NodeDUO<T> node) {
		if (node == null) {
			return null;
		} else if (head == tail) {
			return removeLastOne();
		} else {
			NodeDUO<T> prev = node.getPrev();
			NodeDUO<T> next = node.getNext();

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
			eliminate(node);
			return data;
		}
	}

	@Override
	public T remove(T data) {
		if (head == null)
			return null;

		for (NodeDUO<T> node = head; node != null; node = node.getNext()) {
			if (node.getData().equals(data)) {
				return remove(node);
			}
		}

		return null;
	}
	
	public void eliminateAll() {
		if (head == null)
			return;

		for (NodeDUO<T> node = head; node != null; node = node.getNext()) {
			node.setData(null);
			remove(node);
		}
	}

}

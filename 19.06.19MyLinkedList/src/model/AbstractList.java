package model;

abstract class AbstractList<T> implements MyList<T>{
	protected Node<T> head;
	protected Node<T> tail;
	protected int size = 0;
	
	public AbstractList() {
		super();
	}

	public AbstractList(AbstractList<T> list) {
		super();
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	
	public abstract void add(T data);
	
	public abstract void addFirst(T data);
	
	public void addLast(T data) {
		add(data);
	}

	public abstract boolean addByIndex(int index, T data);
	
	protected abstract Node<T> getNodeByIndex(int index);
	
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
	
	public boolean contains(T data) {
		if (indexOf(data) != -1)
			return true;
		else
			return false;
	}
	
	public T get(int index) {
		return (index < 0 || index >= size) ? null : getNodeByIndex(index).getData();
	}
	
	public T getFirst() {
		return head == null ? null : head.getData();
	}
	
	public T getLast() {
		return tail == null ? null : tail.getData();
	}
	
	public boolean set(int index, T data) {
		if (index < 0 || index >= size)
			return false;

		getNodeByIndex(index).setData(data);
		return true;
	}
	
	protected T removeLastOne() {
		if (head == null)
			return null;
		
		T data = head.getData();
		eliminate(head);
		
		head = null;
		tail = null;
		size = 0;
		
		return data;
	}
	
	public abstract T removeFirst();
	
	public abstract T removeLast();
	
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
	
	public int size() {
		return size;
	}
	
	protected abstract void eliminate(Node<T> node);
	
	protected abstract T remove(Node<T> node);
	
	public void eliminateAll() {
		if (head == null)
			return;

		for (Node<T> node = head; node != null; node = node.getNext()) {
			node.setData(null);
			remove(node);
		}
	}
	
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

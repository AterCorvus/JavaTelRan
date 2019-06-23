package model;

abstract class AbstractList<T> implements MyList<T>{
	private Node<T> head = null;
	private int size = 0;
	
	public void add(T data) {
		
	}
	
	public void addFirst(T data) {
		
	}
	
	public void addLast(T data) {
		
	}
	
	public boolean addByIndex(int index, T data) {
		
	}
	
	public int indexOf(T data) {
		
	}
	
	public boolean contains(T data) {
		
	}
	
	public T get(int index) {
		
	}
	
	public T getFirst() {
		
	}
	
	public T getLast() {
		
	}
	
	public boolean set(int index, T data) {
		
	}
	
	public T removeFirst() {
		
	}
	
	public T removeLast() {
		
	}
	
	public T remove(int index) {
		
	}
	
	public T remove(T data) {
		
	}
	
	public int size() {
		return size;
	}
	
	public abstract void eliminateAll();
	
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

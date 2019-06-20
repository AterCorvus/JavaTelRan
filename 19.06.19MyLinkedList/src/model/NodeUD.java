package model;

public class NodeUD<T> {
	
	private T data;
	private NodeUD<T> next;
	
	public NodeUD(T data) {
		super();
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public NodeUD<T> getNext() {
		return next;
	}

	public void setNext(NodeUD<T> next) {
		this.next = next;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

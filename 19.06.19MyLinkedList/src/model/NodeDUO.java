package model;

public class NodeDUO<T> extends Node<T> {
	
	private NodeDUO<T> prev = null;
	
	public NodeDUO (T data){
		super(data);
	}

	public NodeDUO<T> getNext() {
		return (NodeDUO<T>) super.getNext();
	}

	public void setNext(NodeDUO<T> next) {
		super.setNext(next);;
	}
	
	public NodeDUO<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeDUO<T> prev) {
		this.prev = prev;
	}
	
	
}

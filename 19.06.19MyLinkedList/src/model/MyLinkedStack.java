package model;

public class MyLinkedStack<T> implements MyStack<T> {
	
	private Node<T> last;
	private int size = 0;

	private void eliminate(Node<T> node){
		if (node == null)
			return;
		
		node.setNext(null);
		node.setData(null);
	}
	
	@Override
	public void push(T data) {
		Node<T> node = new Node<T>(data);

		if (last == null)
			last = node;
		else
			node.setNext(last);

		last = node;
		size++;
	}

	@Override
	public T peek() {
		return last == null ? null : last.getData();
	}

	@Override
	public T poll() {
		if (last == null)
			return null;
		else {
			Node<T> node = last;
			last = node.getNext();
			size--;
			
			T data = node.getData();
			eliminate(node);
			return data;
		}
	}

	@Override
	public int deep(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> temp = last;
		while (temp != null) {
			sb.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}

}

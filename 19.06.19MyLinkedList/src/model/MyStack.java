package model;

public interface MyStack<T> {

	void push(T data);

	T peek();

	T poll();

	int deep(T data); // 1-based

	int size();

}

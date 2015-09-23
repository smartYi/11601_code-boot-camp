package chapter3;
import java.util.*;

/**
 * This java file is to create a generic stack class with argument style T.
 * Stack is a data structure that supports FILO (First-in-last-out) operation ordering.
 * A regular Stack data structure usually includes these four operations:
 * pop(): Return and remove the top item from the stack;
 * push(item): Push the item to the top of the stack;
 * peek(): Return the item of the stack but do not remove it;
 * isEmpty(): Return true if and only if the Stack is empty.
 * 
 * @author qiuyi
 * @since Sep/19/2015
 * @version 1.0
 * @param <T>
 */
public class MyStack<T> {
	/**
	 * In each Stack, there is a StackNode data structure like in the linked list
	 */
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	//Each stack should have a top Stack node.
	private StackNode<T> top;
	
	/**
	 * This method is to get an item from the top of the stack and remove it;
	 * If there is no item, throw exception. 
	 */
	public T pop() {
		//If the stack is empty, throw an exception.
		if(top == null) throw new EmptyStackException();
		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	/**
	 * This method is to push an item to the top of the stack.
	 */
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}
	
	/**
	 * This method is to return the top item from the stack but do not remove the top.
	 * Throw an exception if the stack is empty.
	 */
	public T peek() {
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	/**
	 * This method is to check the stack is empty or not.
	 * Return true if and only if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
}

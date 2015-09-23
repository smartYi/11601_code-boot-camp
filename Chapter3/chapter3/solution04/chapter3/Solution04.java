package chapter3;


/**
 * This java file is to create a generic queue class with argument style T.
 * Stack is data structure that supports FIFO (First-in-last-out) operation ordering.
 * A regular Stack data structure usually includes these four operations:
 * remove(): Return and remove the first item from the queue;
 * add(item): Push the item to the end of the queue;
 * peek(): Return the first item of the queue but do not remove it;
 * isEmpty(): Return true if and only if the queue is empty.
 * <p>
 * This class file implements a queue structure using two stacks, one is for store and 
 * another one is for pop buffer.
 * <p>
 * The idea is when we try to push an element into the queue, we push it to the store stack;
 * and if we want to pop or peek the first element of the queue, we firstly check the buffer stack 
 * is empty or not. If the buffer stack is empty, we empty the store stack and transfer all elements
 * to the buffer stack and then pop the top one; and if the buffer stack is not empty, we just pop its 
 * top element. For check the queue is empty or not, we have to make sure that both store stack and 
 * buffer stack is empty.
 * 
 * @author qiuyi
 * @since Sep/19/2015
 * @version 1.0
 * @param <T>
 */

public class Solution04 {
	public static class Myqueue<T> {
		
		MyStack<T> store = new MyStack<>();
		MyStack<T> buffer = new MyStack<>();
		
		/**
		 * This method is to add an element to the end of the queue.
		 * @param data
		 */
		public void add(T data) {
			store.push(data);
		}
		
		/**
		 * This method is to remove the first element of the queue.
		 * @return
		 */
		public T remove() {
			if(isEmpty()) {
				System.out.println("The queue is empty");
				System.exit(1);
			}
			if(!buffer.isEmpty()) return buffer.pop();
			
			while(!store.isEmpty()) {
				buffer.push(store.pop());
			}
			return buffer.pop();
		}
		
		/**
		 * This method is to return the first element of the queue.
		 * @return
		 */
		public T peek() {
			if(isEmpty()) {
				System.out.println("The queue is empty");
				System.exit(1);
			}
			if(!buffer.isEmpty()) return buffer.peek();
			
			while(!store.isEmpty()) {
				buffer.push(store.pop());
			}
			return buffer.peek();
		}
		/**
		 * This method is to check the queue is empty or not.
		 * @return
		 */
		public boolean isEmpty() {
			return (store.isEmpty() && buffer.isEmpty());
		}
		
		public void print() {
			if(isEmpty()) return;
			
			while(!isEmpty()) {
				System.out.print(remove() + "-->");
			}
			return;
		}
		
		
	}
	
	//Main function
	public static void main(String[] args) {
		
		Myqueue<Integer> queue = new Myqueue<Integer>();
		
		//Test
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		
		//Before test
		System.out.println("Before operations: ");
		System.out.println("0-->1-->2-->3");
		queue.remove();
		System.out.println("After remove the first element of the queue:");
		queue.print();
	}
}

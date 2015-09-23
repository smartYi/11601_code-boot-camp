package chapter3;
import java.util.EmptyStackException;

/**
 * This java file is to create a generic stack class with argument style Integer.
 * Stack is a data structure that supports FILO (First-in-last-out) operation ordering.
 * A regular Stack data structure usually includes these four operations:
 * pop(): Return and remove the top item from the stack;
 * push(item): Push the item to the top of the stack;
 * peek(): Return the item of the stack but do not remove it;
 * isEmpty(): Return true if and only if the Stack is empty.
 * <p>
 * In this well designed stack, the smallest item of this stack is always the top of the 
 * stack, which means that this stack is a sorted stack.
 * 
 * @author qiuyi
 * @since Sep/19/2015
 * @version 1.0
 */

public class Solution05 {
	
	public static class MyStack {
		
		/**
		 * In each Stack, there is a StackNode data structure like in the linked list
		 */
		private static class StackNode {
			private int data;
			private StackNode next;
			
			public StackNode(int data) {
				this.data = data;
			}
		}
		
		//Each stack should have a top Stack node.
		private StackNode top;
		
		/**
		 * This method is to get an item from the top of the stack and remove it;
		 * If there is no item, throw exception. 
		 */
		public int pop() {
			//If the stack is empty, throw an exception.
			if(top == null) throw new EmptyStackException();
			
			int item = top.data;
			top = top.next;
			return item;
		}
		
		/**
		 * This method is to push an item to the top of the stack.
		 * But we have to make sure that the smallest element so far must 
		 * be the top of the stack.
		 */
		public void push(int item) {
			StackNode t = new StackNode(item);
			if(top == null || item<peek()) {
				t.next = top;
				top = t;
			}else {
				t.next = top;
				top = t;
				sort();
			}
				}
		
		/**
		 * This method is to return the top item from the stack but do not remove the top.
		 * Throw an exception if the stack is empty.
		 */
		public int peek() {
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
		
		/**
		 * This method is to get the certain node data
		 * @param node true
		 * @return true
		 */
		public int getData(StackNode node) {
			if(node == null) throw new EmptyStackException();
			return node.data;
		}
		
		/**
		 * This method is to sort the stack to make sure that the 
		 * minimum element is always the top of the stack.
		 */
		public void sort() {
			MyStack buffer = new MyStack();
			int target = pop();
			
			//Add the data to the proper position
			while(true) {
				if(target > peek()) {
					buffer.transfer(pop());
					if(top == null) {
						transfer(target);
						break;
					}
				}else {
					transfer(target);
					break;
				}
			}
			
			//Empty the buffer stack
			while(!buffer.isEmpty()) {
				transfer(buffer.pop());
			}
		}
		
		/**
		 * This method is to transfer elements from one stack to another one.
		 * @param data
		 */
		public void transfer(int data) {
			StackNode node = new StackNode(data);
			node.next = top;
			top = node;
		}
		
		/**
		 * This method is to print out the stack information.
		 */
		public void printInfo() {
			StackNode temp = top;
			while(temp != null) {
				if(temp.next != null) {
					System.out.print(temp.data + "-->");
				}else {
					System.out.println(temp.data );
				}
				temp = temp.next;
			}
		}
		
	}

	
	//Main function
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		//Push random elements into the stack and make sure the element is always sorted.
		System.out.println("----------------------------------------");
		System.out.println("Element 8 is pushed into the stack: ");
		stack.push(8);
		stack.printInfo();
		System.out.println("----------------------------------------");
		System.out.println("Element 2 is pushed into the stack: ");
		stack.push(2);
		stack.printInfo();
		System.out.println("----------------------------------------");
		System.out.println("Element 4 is pushed into the stack: ");
		stack.push(4);
		stack.printInfo();
		System.out.println("----------------------------------------");
		System.out.println("Element 5 is pushed into the stack: ");
		stack.push(5);
		stack.printInfo();
		System.out.println("----------------------------------------");
		System.out.println("Test successfully completed!");
	}

}

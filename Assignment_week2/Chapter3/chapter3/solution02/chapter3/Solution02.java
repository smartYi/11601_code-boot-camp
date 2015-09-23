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
 * Besides that, another operation is designed:
 * min(): This method is to return the minimum value of the stack.
 * 
 * @author qiuyi
 * @since Sep/19/2015
 * @version 1.0
 * 
 */
public class Solution02 {
	
	public static class MyStack {
		/**
		 * In each Stack, there is a StackNode data structure like in the linked list
		 */
		private static class StackNode {
			private int data;
			private StackNode next;
			//Add another element in the node design to store the ever minimum value to this node.
			private int minimum;
			
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
		 */
		public void push(int item) {
			StackNode t = new StackNode(item);
			if(top !=null) {
				int temp = top.minimum;
				t.next = top;
				top = t;
				if(item < temp) {
					top.minimum = item;
				}else {
					top.minimum = temp;
				}
				}else {
					t.next = top;
					top = t;
					top.minimum  = item;
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
		 * This method is to return the minimum of the current stack and the runtime is O(1).
		 */
		public int min() {
			if(top == null) throw new EmptyStackException();
			
			return top.minimum;
		}
		
		/**
		 * This method is to print out the data information of this stack.
		 */
		public void printInfo() {
			StackNode temp = top;
			while(temp != null){
				if(temp.next == null) {
					System.out.println(temp.data);
				}else {
					System.out.print(temp.data + "-->");
				}
				temp = temp.next;
			}
		}
		
		/**
		 * This method is to print out the minimum of each node.
		 */
		public void printMin() {
			StackNode temp = top;
			while(temp != null){
				if(temp.next == null) {
					System.out.println(temp.minimum);
				}else {
					System.out.print(temp.minimum + "-->");
				}
				temp = temp.next;
			}
		}
	}
	
	//Main function
	public static void main(String[] args) {
		
		//Test
		MyStack myStack = new MyStack();
		myStack.push(3);
		myStack.push(1);
		myStack.push(5);
		myStack.push(0);
		myStack.push(9);
		
		//Call function
		System.out.println("The original stack: ");
		myStack.printInfo();
		myStack.printMin();
		
		//When we pop and return the minimum
		System.out.println("------------------------------------------------");
		System.out.println("After pop() and min()");
		System.out.println("The so far minimum in the stack is: " + myStack.min());
		System.out.println("The first pop data is:" + myStack.pop());
		System.out.println("The so far minimum in the stack is: " + myStack.min());
		System.out.println("The second pop data is:" + myStack.pop());
		System.out.println("The so far minimum in the stack is: " + myStack.min());
		System.out.println("The third pop data is:" + myStack.pop());
		System.out.println("------------------------------------------------");
		System.out.println("Test successfully completed!");
		
	}

}

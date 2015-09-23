package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This java file is to create a generic stack class with argument style T.
 * Stack is a data structure that supports FILO (First-in-last-out) operation ordering.
 * A regular Stack data structure usually includes these four operations:
 * pop(): Return and remove the top item from the stack;
 * push(item): Push the item to the top of the stack;
 * peek(): Return the item of the stack but do not remove it;
 * isEmpty(): Return true if and only if the Stack is empty.
 * In this well-designed stack, each sub-stack has a limitation capacity and if the sub-stack size
 * exceeds the limitation, another new sub-stack is created. 
 * 
 * @author qiuyi
 * @since Sep/19/2015
 * @version 1.0
 * @param <T>
 */

public class Solution03 {
	public static class SetOfStacks<T> {
		//Each sub-stack limitation capacity
		private int capacity;
		
		//Create a arraylist of MyStacks.
		
		ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
		
		//Constructor 
		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}
		
		/**
		 * Push an element into the stack
		 * @param data true
		 */
		public void push(T data) {
			Stack<T> lastStack = getLastStack();
			
			if(lastStack != null && !lastStack.isFull()) {
				lastStack.push(data);
			}else {
				Stack<T> newStack = new Stack<>(capacity);
				newStack.push(data);
				stacks.add(newStack);
			}
		}
		
		/**
		 * Pop an element from the stack
		 * @return true
		 */
		public T pop() {
			Stack<T> last = getLastStack();
			if(last == null) throw new EmptyStackException();
			T data = last.pop();
			if(last.size == 0) stacks.remove(stacks.size()-1);
			return data;
		}
		
		/**
		 * This method is to check the stacks is empty or not
		 */
		public boolean isEmpty() {
			Stack<T> last = getLastStack();
			return (last == null || last.size == 0);
		}
		
		/**
		 * This method is to get the sub-stack top data.
		 * @param index true
		 * @return T true
		 */
		public T popAt(int index) {
			if(index<0 || index>stacks.size()) {
				System.out.println("Out of bounds!");
				System.exit(1);
			}
			
			return leftShift(index, true);
		}
		
		/**
		 * This method is to left shift the next stack bottom data to the previous stack top.
		 * @param index true
		 * @param removeTop true
		 * @return T true
		 */
		public T leftShift(int index, boolean removeTop) {
			Stack<T> stack = stacks.get(index);
			T data;
			if(removeTop) data = stack.pop();
			else data = stack.removeBottom();
			
			if(stack.isEmpty()) {
				stacks.remove(index);
			}else if(stacks.size()>index+1) {
				T v = leftShift(index+1, false);
				stack.push(v);
			}
			return data;
		}
		
		/**
		 * This method is to get the last stack in the stack arraylist
		 */
		public Stack<T> getLastStack() {
			if(stacks.size() == 0) return null;
			return stacks.get(stacks.size()-1);
		} 
		
		public void printInfo() {
			for(int i=0;i<stacks.size();i++){
				stacks.get(i).print();
			}
		}
	}
	
	//Main function 
	public static void main(String args[]) {
		
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
		setOfStacks.push(0);
		setOfStacks.push(1);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		
		//Test
		System.out.println("----------------------------------");
		System.out.println("Before any operations: ");
		System.out.println("The set of stack size is: " + setOfStacks.stacks.size());
		setOfStacks.printInfo();
		System.out.println("----------------------------------");
		System.out.println("After operations: ");
		setOfStacks.popAt(1);
		setOfStacks.printInfo();
	}
}

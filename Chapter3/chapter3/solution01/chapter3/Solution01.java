package chapter3;
import java.util.*;

/**
 * This java file implements three stacks using only one array.
 * Each stack has the same size and the stack can not extends its length.
 * A regular stack usually includes four operations:
 * pop(), peek(), push() and isEmpty().
 * 
 * @author qiuyi
 * @since sep/19/2015
 * @version 1.0
 */
public class Solution01 {
	
	private static int[] values;
	private static int[] sizes;
	private static int stackSize;
	private static int numberOfStack;
	
	public static void threeInOne(int stackSize, int numberOfStack) {
		values = new int[stackSize * numberOfStack];
		sizes = new int[numberOfStack];
	}
	
	/**
	 * This method is to push an item to the top of one stack, which is indexed with the stack order.
	 * @param index true
	 */
	public static void push(int index, int data) throws FullStackException{
		//Check whether the stack is full or not
		if(sizes[index] == stackSize) throw new FullStackException();
		
		sizes[index]++;
		values[topOfIndex(index)] = data;
	}
	
	/**
	 * This method is to remove an item from the top of a stack with its stack index.
	 * @param index true
	 */
	public static int pop(int index) {
		//Check whether the stack is empty or not
		if(isEmpty(index)) throw new EmptyStackException();
		
		int data = values[topOfIndex(index)];
		values[topOfIndex(index)] = 0;
		sizes[index]--;
		return data;
	}
	
	/**
	 * This method is to return the top data but not remove top.
	 * @param index true
	 */
	public static int peek(int index) {
		if(isEmpty(index)) throw new EmptyStackException();
		
		return values[topOfIndex(index)];
	}
	
	/**
	 * This method is t check the stack, which is indexed with its order, is empty or not.
	 * @param index true
	 */
	public static boolean isEmpty(int index) {
		return sizes[index] == 0;
	}
	/**
	 * This method is to return the exact location of top for each stack.
	 * @param index true
	 * @return
	 */
	public static int topOfIndex(int index) {
		int base = index * stackSize;
		int offset = sizes[index];
		return base + offset -1;
	}
	
	/**
	 * This method is to print out the stack information.
	 * @param index true
	 */
	public static void printInfo(int index) {
		if(isEmpty(index)) System.out.println("The stack is empty!");
		
		while(!isEmpty(index)) {
			if(sizes[index] != 1) {
				System.out.print(values[topOfIndex(index)] + "-->");
			}else{
				System.out.println(values[topOfIndex(index)]);
			}
			pop(index);
		}
	}
	
	/**
	 * Main function
	 */
	public static void main(String[] args) {
		
		//For each stack, size is 10 and there are in total 3 stacks
		stackSize = 10;
		numberOfStack = 3;
		threeInOne(stackSize, numberOfStack);
		
		//For Stack 1, I test pop() and isEmpty()
		//For Stack 2, I test peek() and isEmpty();
		//For Stack 3, without input and test isEmpty() and pop();
		try{
		push(0, 1);
		push(0, 2);
		push(0, 3);
		push(0, 4);
		push(1, 5);
		push(1, 6);
		push(1, 7);
		push(1, 8);
		}catch(FullStackException e){
			e.printStackTrace();
		}
		
	
		
		//Operations
		System.out.println("------------------------------");
		System.out.println("Before pop, stack 1 size is: " + sizes[0]);
		System.out.println("Stack 1 size is 0? " + isEmpty(0));
		System.out.println("After pop, stack 1 size is: " + sizes[0]);
		System.out.println("------------------------------");
		int data = peek(1);
		System.out.println("The top data is " + data +" and the stack 2 size is 0 ?" + isEmpty(1));
		System.out.println("------------------------------");
		System.out.println("The stack 3 size is 0? " + isEmpty(2));
	}
	
}

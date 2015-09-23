package chapter3;


public class FullStackException extends Exception{
	
	static final long serialVersionUID = 1;
	
	public FullStackException() {
		System.out.println("Your stack is full size and can not add any new elements!");
	};
}

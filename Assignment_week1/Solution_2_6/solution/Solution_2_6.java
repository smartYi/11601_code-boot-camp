package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/15/2015
*/

public class Solution_2_6 {
	
	//This method is to determine a linked list is palindrome or not
	//Use runner techniques
	public static boolean isPalindrome(LinkedListNode head){
		
		//If head is null or head.next is null. return true.
		if(head == null || head.next == null) return true;
		
		//Slow and fast pointer
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//After runner, slow point to the half way of linked list
		slow = slow.next;
		
		//Reverse the later part and return the new head
		LinkedListNode newHead = reverseList(slow);
		
		//Compare new head and original head
		while(newHead!=null){
			if(newHead.val!=head.val) return false;
			else{
				head = head.next;
				newHead = newHead.next;
			}
		}
		return true;
	}
	
	//This method is to reverse a linked list
	public static LinkedListNode reverseList(LinkedListNode head){
		
		//Use iterative way to reverse a linked list
		LinkedListNode prev = null;
		LinkedListNode last = head;
		
		while(last!=null){
			
			//Store the next node
			LinkedListNode next = last.next;
			last.next = prev;
			prev = last;
			last = next;
		}
		return prev;
	}
	
	//This method is to print out linked list information
	public static void  printLinkedList(LinkedListNode head){
		
		//While head is not null ,print out val.
		while(head!=null){
			if(head.next!=null){
			System.out.print(head.val + "-->");
			}else{
				System.out.print(head.val);
			}
			head = head.next;
		}
		System.out.println();
	}
	
	//Main function
	public static void main(String[] args){
		
		//Here I set two linked list with duplicates
		
		//Case 1: 2-->4-->1-->1-->4-->2
		LinkedListNode head1 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(4);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(1);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(2);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		//Case 2: 2-->4-->1-->5-->2
		LinkedListNode head2 = new LinkedListNode(2);
		LinkedListNode node6 = new LinkedListNode(4);
		LinkedListNode node7 = new LinkedListNode(1);
		LinkedListNode node8 = new LinkedListNode(5);
		LinkedListNode node9 = new LinkedListNode(2);
		head2.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = null;
	
		
		//Printout information
		System.out.println("Before call function: ");
		printLinkedList(head1);
		printLinkedList(head2);
		
		//After function call 
		System.out.println("After calling function: ");
		//Call function
		boolean result1 = isPalindrome(head1);
		boolean result2 = isPalindrome(head2);
		System.out.println(result1);
		System.out.println(result2);
	}
}

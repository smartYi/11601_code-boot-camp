package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/15/2015
*/

public class Solution_2_8 {
	//This method is to detect a loop in a corrupted linked list
	public static LinkedListNode isLoop(LinkedListNode head){
		//If head is null, return null
		if(head == null) return null;
		
		//Using tag 
		LinkedListNode prev = null;
		while(head!=null){
			if(head.tag){
				return prev;
			}
			else{
				prev = head;
			}
			head.tag = true;
			head = head.next;
		}
		
		return null;
	}
	
	//This method is to print out linked list information
	public static void  printLinkedList(LinkedListNode head){
		
		//While head is not null ,print out val.
		while(head!=null){
			if(head.tag) break;
			head.tag = true;
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
		
		//Case 1: 2-->4-->1-->4
		LinkedListNode head1 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(4);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(4);
		
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node2;
		
		//Case 2: 2-->4-->1-->3-->6
		LinkedListNode head2 = new LinkedListNode(2);
		LinkedListNode node6 = new LinkedListNode(4);
		LinkedListNode node7 = new LinkedListNode(1);
		LinkedListNode node8 = new LinkedListNode(3);
		LinkedListNode node9 = new LinkedListNode(6);
		head2.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = null;
	
		
		//Printout information
		//After function call 
		System.out.println("After calling function: ");
		
		//Call function
		LinkedListNode result1 = isLoop(head1);
		LinkedListNode result2 = isLoop(head2);
		
		System.out.println("The first list loop node is :"+(result1==null?"null":result1.val));
		System.out.println("The second list loop node is :"+(result2==null?"null":result2.val));
	}
}

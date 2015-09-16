package solution;
import java.util.HashSet;

/*
@Author--Yi
@Version--1.0
@Date--Sep/15/2015
*/

public class Solution_2_1 {
	
	//This method is to remove duplicates in a unsorted linked list
	public static LinkedListNode removeDuplicates(LinkedListNode head){
		//If linked list does not exist, return null.
		if(head == null) return null;
		
		//If head.next = null, return head
		if(head.next == null) return head;
		
		//Create a hashset to store linked list
		HashSet<Integer> set = new HashSet<>();
		
		LinkedListNode cur = head;
		LinkedListNode prev = null;
		while(cur!=null){
			boolean flag = set.add(cur.val);
			if(flag){
				prev = cur;
				cur = cur.next;
			}else{
				prev.next = cur.next;
				cur = cur.next;
			}
			
		}
		
		return head;
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
		
		//Case 1: 2-->4-->1-->3-->2-->4
		LinkedListNode head1 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(4);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(2);
		LinkedListNode node5 = new LinkedListNode(4);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
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
		System.out.println("Before remove duplicates: ");
		printLinkedList(head1);
		printLinkedList(head2);
		
		//Call function
		LinkedListNode result1 = removeDuplicates(head1);
		LinkedListNode result2 = removeDuplicates(head2);
		
		//After function call 
		System.out.println("After removing duplicates: ");
		printLinkedList(result1);
		printLinkedList(result2);
	}
}

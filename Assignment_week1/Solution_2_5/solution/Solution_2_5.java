package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/15/2015
*/

public class Solution_2_5{
	
	//This method is to add two linked lists
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2,int carry ){
		//Termination condition
		if ( l1 == null && l2 == null && carry == 0){
			return null;
		}
		
		
		int value = carry;
		if (l1 != null){
			value += l1.val;		
		}
		
		if (l2 != null){
			value += l2.val;		
		}
		
		LinkedListNode result = new LinkedListNode();
		result.val = value % 10;
		
		if(l1 != null || l2 != null){
			LinkedListNode more = addLists(l1 == null ? null: l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
			result.next = more;
		}
		
		
		return result ;
	}
	
	//This method is to reverse linked list
	public static LinkedListNode reverseList(LinkedListNode head) {
		
		//If head is null, return null.
		if(head == null) return null;
		
		//Two pointers techniques
		LinkedListNode last = null;
		LinkedListNode cur = head;
		while(cur!=null){
			LinkedListNode next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
		}
		return last;
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
		
		//list 1: 7-->2-->6
		LinkedListNode n1 = new LinkedListNode(7);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		
		//list 2: 5-->9-->2
		LinkedListNode n4 = new LinkedListNode(5);	
		LinkedListNode n5 = new LinkedListNode(9);
		LinkedListNode n6 = new LinkedListNode(2);
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		//list 3: 6-->2-->7
		LinkedListNode head1 = new LinkedListNode(6);
		LinkedListNode node1 = new LinkedListNode(2);
		LinkedListNode node2 = new LinkedListNode(7);
		head1.next = node1;
		node1.next = node2;
		node2.next = null;
				
				
		//list 4: 2-->9-->5
		LinkedListNode head2 = new LinkedListNode(2);	
		LinkedListNode node3 = new LinkedListNode(9);
		LinkedListNode node4 = new LinkedListNode(5);
		head2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		//Print out information
		System.out.println("----------------------------");
		System.out.println("Backward order:");
		System.out.println("Before add list: ");
		printLinkedList(n1);
		printLinkedList(n4);
		
		//Call function
		LinkedListNode result1 = addLists(n1, n4, 0);
		System.out.println("After functon call: ");
		printLinkedList(result1);
		
		
		//Reverse list3 and list4
		System.out.println("----------------------------");
		System.out.println("Backward order:");
		System.out.println("Before reverse list: ");
		printLinkedList(head1);
		printLinkedList(head2);
		
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		System.out.println("After reverse lists:");
		printLinkedList(head1);
		printLinkedList(head2);
		
		//Call function
		LinkedListNode result2 = addLists(head1, head2, 0);
		result2 = reverseList(result2);
		
		//Print out information
		System.out.println("After functon call: ");
		printLinkedList(result2);
		
	}

}



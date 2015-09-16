package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/15/2015
*/

public class Solution_2_7 {
	
	//This method is to determine whether two linked lists are intersected
	public static LinkedListNode isIntersected(LinkedListNode h1, LinkedListNode h2){
		//If any one of these two heads is null, return null
		if(h1 == null || h2 == null) return null;
		
		//Get tails and sizes
		Result result1 = getTailAndSize(h1);
		Result result2 = getTailAndSize(h2);
		
		if(result1.tail!=result2.tail) return null;
		
		LinkedListNode shorter = result1.size<result2.size?h1:h2;
		LinkedListNode longer = result1.size<result2.size?h2:h1;
		
		longer = getKthNode(longer, Math.abs(result1.size-result2.size));
		
		while(shorter!=longer){
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return shorter;
	}
	
	//This method is to get the list tail node and the list size
	public static Result getTailAndSize(LinkedListNode list) {
		if(list == null) return null;
		
		int size = 1;
		LinkedListNode cur = list;
		while(cur.next !=null){
			size++;
			cur = cur.next;
		}
		return new Result(cur,size);
	}
	
	//This method is to get to the Kth node in a list
	public static LinkedListNode getKthNode(LinkedListNode head, int k){
		LinkedListNode cur = head;
		while(k>0 && cur!=null){
			k--;
			cur = cur.next;
		}
		return cur;
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
		
		//List 1: 2-->4-->5-->6--7-->9
		LinkedListNode head1 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(4);
		LinkedListNode node2 = new LinkedListNode(5);
		LinkedListNode node3 = new LinkedListNode(8);
		LinkedListNode node4 = new LinkedListNode(7);
		LinkedListNode node5 = new LinkedListNode(9);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		//List 2: 10-->5-->8-->7-->9
		LinkedListNode head2 = new LinkedListNode(10);
		LinkedListNode node6 = new LinkedListNode(5);
		LinkedListNode node7 = new LinkedListNode(8);
		head2.next = node6;
		node6.next = node7;
		node7.next = node4;
	
		
		//Printout information
		System.out.println("Before call function: ");
		printLinkedList(head1);
		printLinkedList(head2);
		
		//After function call 
		System.out.println("After calling function: ");
		
		//Call function
		LinkedListNode result = isIntersected(head1, head2);
		System.out.println("The intersection node value is: "+ result.val);
	}
}

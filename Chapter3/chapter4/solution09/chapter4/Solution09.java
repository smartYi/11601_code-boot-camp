package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution09 {
	public ArrayList<LinkedList<Integer>> BSTSequence(BSTreeNode root) {
		 ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		 
		 if(root == null) {
			 result.add(new LinkedList<Integer>());
			 return result;
		 }
		 
		 LinkedList<Integer> prefix = new LinkedList<Integer>();
		 prefix.add(root.getValue());
		 
		 ArrayList<LinkedList<Integer>> leftSeq = BSTSequence(root.getLeftChild());
		 ArrayList<LinkedList<Integer>> rightSeq = BSTSequence(root.getRightChild());
		 
		 for (LinkedList<Integer> left : leftSeq) {
			 for (LinkedList<Integer> right : rightSeq) {
				 ArrayList<LinkedList<Integer>> weaved = 
						 new ArrayList<LinkedList<Integer>>();
				 weavelists(left,right,weaved,prefix);
				 result.addAll(weaved);
			 }
		 }
		 return result;
	}
	
	public void weavelists(LinkedList<Integer> first, LinkedList<Integer> second,
			               ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weavelists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int secondHead = second.removeFirst();
		prefix.addLast(secondHead);
		weavelists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(secondHead);
	}
}

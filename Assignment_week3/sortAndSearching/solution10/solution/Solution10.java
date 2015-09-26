package solution;

import java.util.LinkedList;

/**
 * This class file is to design an algorithm to get the rank of a given number 
 * in an array.
 * @author qiuyi
 *
 */
public class Solution10 {
	private static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	/**
	 * This method is to insertion an element into a sorted linkedlist.
	 * Insertion sort is used here.
	 * @param x
	 */
	public static void track(int x) {
		if(linkedList.isEmpty()) {
			linkedList.add(x);
			return;
		}else {
			linkedList.addLast(x);
			int size = linkedList.size()-1;
		    for(int index = size; index>0;index--) {
				if(linkedList.get(index) < linkedList.get(index-1)) {
					int exc = linkedList.get(index);
					linkedList.set(index, linkedList.get(index-1));
					linkedList.set(index-1, exc);
				}
			}
		}	
	}
	
	/**
	 * This method is to get the rank of number in the array
	 * @param x
	 * @return
	 */
	public int getRankOfNumber(int x) {
		return binarySearch(linkedList,x,0,linkedList.size()-1);
	}
	
	/**
	 * We use binary search to get the rank of numbers.
	 * But some modifications are made to handle duplicates.
	 * @param list
	 * @param element
	 * @param low
	 * @param high
	 * @return
	 */
	public int binarySearch(LinkedList<Integer> list, int element, int low, int high) {
		if(low > high) return -1;
		
		int mid = (low + high) / 2;
		if(element == list.get(mid)) {
			//When we find the element, we have to make sure that this element 
			//is at the most top position in this array.
			while(element == list.get(mid)) mid++;
			return mid-1;
		}
		else if(element < list.get(mid)) {
			return binarySearch(list, element, low, mid-1);
		}else {
			return binarySearch(list, element, mid+1, high);
		}
	}
}

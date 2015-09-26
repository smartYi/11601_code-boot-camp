package solution;

/**
 * This method is to get an element index in a data structure called listy.
 * Class Listy can not return its size, so we must fisrt determine its size and 
 * then use binary search. 
 * @author qiuyi
 *
 */
public class Solution04 {
	
	public static int findIndex(Listy list, int item) {
		int length = 0;
		//Get its length by iteration.
		while(list.elementAt(length) != -1) length++;
		
		return binarySearch(list, 0, length-1, item);
	}
	
	//Binary search.
	public static int binarySearch(Listy list, int low, int high, int item) {
		//If not found, return -1 as an error.
		if(low > high) return -1;
		int mid = (low + high) / 2;
		if(item < list.elementAt(mid)) {
			return binarySearch(list, low, mid-1, item);
		}else if(item > list.elementAt(mid)) {
			return binarySearch(list, mid+1, high, item);
		}else return mid;
		
	}
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6};
		Listy listy = new Listy(array);
		System.out.println(findIndex(listy, 6));
	}
	
}

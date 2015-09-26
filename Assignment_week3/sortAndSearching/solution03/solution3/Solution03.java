package solution3;


/**
 * This method is to find an element in a rotated sorted array.
 * And the array is originally sorted in increasing order.
 * Trick: No matter how many times the array is rotated, the array is 
 * divided into two increasing parts, except that the array is rotated back to its
 * original form, where there is only one increasing part that is the whole array.
 * Idea: The main idea is very likely the binary searching. 
 * @author qiuyi
 *
 */
public class Solution03 {
	public static int searchInRotatedArray(int[] array, int low, int high, int item) {
		
		//We first check which increasing part the item belongs to.
		int mid = (low + high) / 2;
		if(array[low] < array[mid]) {
			if(item == array[low]) return low;
			//If item belongs to the left increasing part, we recursively search in that part
			else if(item > array[low] && item <= array[mid]) {
				return searchInRotatedArray(array, low, mid, item);
			}else {
				//Item does not belong to that part, search in another part. 
				return searchInRotatedArray(array, mid+1, high, item);
			}
		}//If array[low]>array[mid], the increasing part is in the right.
		else if(array[low] > array[mid]) {
			if(item == array[high]) return high;
			//If item belongs to the increasing part, search recursively.
			else if(item < array[high] && item >= array[mid]) {
				return searchInRotatedArray(array, mid, high, item);
			}else {
				return searchInRotatedArray(array, low, mid-1, item);
			}
		}else {
			if(item == array[low]) return low;
			else {
				return searchInRotatedArray(array, mid+1, high, item);
			}
		}	
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[]{1,3,4,5,7,10,14,15,16,18,19,20,25};
		System.out.println(searchInRotatedArray(array, 0, array.length-1, 1));
	}
}

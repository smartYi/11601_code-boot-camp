package solution;

/**
 * This class file is to sort a big file with limited memory.
 * Merge sorting is used here.
 * The main idea is to firstly sort a limited memory of strings and 
 * then merge them together.
 * For different problems, different memory is used, so here I just write down 
 * the merge sort code.
 * @author qiuyi
 *
 */
public class Solution06 {
	
	/**
	 * This method is to divide arrays into two parts and then sort them.
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] array, int low, int high) {
		if(low >= high) return;
		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid+1, high);
		merge(array,low,high,mid);
	}
	
	/**
	 * This method is to merge two sorted arrays into one sorted array.
	 * @param array
	 * @param low
	 * @param high
	 * @param mid
	 */
	public static void merge(int[] array, int low, int high, int mid) {
		if(low > high) return;
		
		int[] aux = new int[array.length];
		for(int i=low; i <= high; i++) {
			aux[i] = array[i];
		}
		
		int left = low;
		int right = mid+1;
		for(int i=low ; i <= high ; i++) {
			if(left > mid) array[i] = aux[right++];
			else if(right > high) array[i] = aux[left++];
			else if(aux[left] < aux[right]) {
				array[i] = aux[left++];
			}else {
				array[i] = aux[right++];
			}
		}
	}
}

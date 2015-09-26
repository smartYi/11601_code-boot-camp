package solution;

/**
 * This class file is to sort an array into an alternating sequence of peaks and valleys.
 * The main idea is firstly sort this array and then iterate the array by swaping two
 * adjacent elements.
 * Quick sort is used here.
 * @author qiuyi
 *
 */
public class Solution11 {
	public static void quickSort(int[] array, int low, int high) {
		if(array.length == 1) return;
		int index = partition(array, low, high);
		if(index-1 > low) {
			quickSort(array, low, index-1);
		}
		if(index < high) {
			quickSort(array, index, high);
		}
	}
	
	public static int partition(int[] array, int low, int high) {
		int pivot = array[(low + high) / 2];
		while(low <= high) {
			while(array[low] < pivot) low++;
			while(array[high] > pivot) high--;
			
			if(low <= high) {
				int exc = array[low];
				array[low] = array[high];
				array[high] = exc;
				high--;
				low++;
			}
		}
		return low;
	}
	
	public static void peaksAndValleys(int[] array) {
		quickSort(array, 0, array.length-1);
		for(int i=0;i<array.length && (i+1)<array.length;) {
			int exc = array[i];
			array[i] = array[i+1];
			array[i+1] = exc;
			i+=2;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{2,3,1,5,9,0,6,8};
		peaksAndValleys(array);
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

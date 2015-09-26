package solution;

/**
 * This class is to find an element in a sorted matrix, given M*N.
 * The main idea is to locate row index and column index.
 * The element is found at the intersection of these two array.
 * @author qiuyi
 *
 */
public class Solution09 {
	public boolean findInSortedArray(int[][] array, int element) {
		int rowLength = array.length;
		int columnLength = array[0].length;
		int rowIndex = 0;
		int columnIndex = columnLength-1;
		while(rowIndex<rowLength && columnIndex>=0) {
			if(array[rowIndex][columnIndex] == element) {
				return true;
			}
			if(element < array[rowIndex][columnIndex]) {
				columnIndex--;
			}else {
				rowIndex++;
			}
		}
		return false;
	}
}

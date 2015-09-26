package solution;

/**
 * This method is to search a string in a given string array.
 * We must omit all empty string since any string is bigger than an empty string
 * when we use compareTo method and it will always return 1.
 * The main idea is to find the new middle position which is not an empty string.
 * This is a modified binary search.
 * @author qiuyi
 *
 */
public class Solution05 {
	public static int searchString(String[] strings, String str, int low, int high) {
		if(low > high) return -1;
		
		int mid = (low + high) / 2;
		
		//Determine the new mid position
		if(strings[mid].isEmpty()) {
			int leftIndex = mid - 1;
			int rightIndex = mid + 1;
			while(true) {
				if(leftIndex < low && rightIndex > high) return -1;
				else if(rightIndex <= high && !strings[high].isEmpty()) {
					mid = rightIndex;
					break;
				}else if(leftIndex >= low && !strings[leftIndex].isEmpty()) {
					mid = leftIndex;
					break;
				}
				rightIndex++;
				leftIndex--;
			}
		}
		
		//Binary search
		if(strings[mid].equals(str)) return mid;
		else if(strings[mid].compareTo(str) < 0) {
			return searchString(strings, str, mid+1, high);
		}else {
			return searchString(strings, str, low, mid-1);
		}
	} 
}

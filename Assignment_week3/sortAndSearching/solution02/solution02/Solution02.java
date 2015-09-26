package solution02;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution02 {
	/**
	 * This method is to transfer string to its sorted format.
	 * @param str
	 * @return
	 */
	public String sortsString(String str) {
		
		char[] array = str.toCharArray();
		
		Arrays.sort(array);
		
		return new String(array);
		
	}
	
	/**
	 * This method is to group all strings with the same anagrams.
	 * @param array
	 */
	public void groupAnagrams(String[] array) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();
		
		for (String s : array) {
			String key = sortsString(s);
			mapList.put(key, s);
		}
		
		int index = 0;
		
		for(String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for(String s : list) {
				array[index] = s;
				index++;
			}
		}
	}
}

package solution;

import java.util.Arrays;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_2 {
	
	//Determine one string is permutation of another
	
	public static boolean compare(String str1, String str2){
		
		    //If theirs lengths are not equal, return false
			if(str1.length()!=str2.length()) return false;
			
			//Cast string to char array
			char[] aStr1 = str1.toCharArray();
			char[] bStr2 = str2.toCharArray();
			
			//Sort these two char arrays
			Arrays.sort(aStr1);
			Arrays.sort(bStr2);
			
			//Cast these two sorted char array to string
			String newStr1 = new String(aStr1);
			String newStr2 = new String(bStr2);
			
			//Compares these two strings
			return (newStr1.equals(newStr2));
			
		}
	public static void main(String[] args){
		//Case 1
		boolean result1 = compare("mylove", "lovemy");
		
		//Case 2
		boolean result2 = compare("abcd", "abc");
		
		//Case 3
		boolean result3 = compare("abcd", "dcer");
		
		//Print out results
		System.out.println("After function call: ");
    	System.out.println("Test of String \"mylove\" and \"lovemy\"is = "+ result1);
    	System.out.println("Test of String \"abcd\" and \"abc\"is = "+ result2);
    	System.out.println("Test of String \"abcd\" and \"dcer\"is = "+ result3);
	}
}

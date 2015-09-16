package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

import java.util.*;

public class Solution_1_1 {
	//String1: test 
	private static String str1 = "test";
	
	//String2 : abcd.
	private static String str2 = "abcd";
	
	//To determine whether this string is unique.
	
	public static boolean isUnique(String str){
		
		//Create a hash set 
		HashSet<Character>set = new HashSet<Character>();
		
		for(int i=0;i<str.length();i++){
			
			//If there is already a value in this set, return false.
			if(!set.add(str.charAt(i))) return false;		
		}
		//If not, ths string is unique, return true
	return true;
	}
	
    public static void main(String[] args){
    	//This is for 1.1
    	//Test 1
    	boolean result1 = isUnique(str1);
    	
    	//Test 2
    	boolean result2 = isUnique(str2);
    	
    	//Print out results
    	System.out.println("After function call: ");
    	System.out.println("Test of String \"test\" is = "+ result1);
    	System.out.println("Test of String \"abcd\" is = "+ result2);
}
}

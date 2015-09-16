package solution;


/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/


public class Solution_1_9 {
	
	//This function is to check whether a string is a rotation of another
	public static boolean isRotation(String str1,String str2){
		
		//If two strings are the same, return true
		if(str1.equals(str2)) return true;
		
		//Add one string to itself and check another string is its substring or not
		String str22 = str2 + str2;
		if(str22.contains(str1)) return true;
		return false;
	}
	
	//Main function
	public static void main(String[] args){
		
		//Case 1: waterbottle and erbottlewat
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		
		//Case 2: codebootcamp and bootcampcdoe
		String str3 = "codebootcamp";
		String str4 = "bootcampcdoe";
		
		//Call function
		boolean result1 = isRotation(str1, str2);
		boolean result2 = isRotation(str3, str4);
		
		//Print out results
		System.out.println("After function call: ");
		System.out.println("Test of String \"waterbottle\" and \"erbottlewat\" is = "+ result1);
		System.out.println("Test of String \"codebootcamp\" and \"codebootcdoe\" is = "+ result2);
				
	}
}

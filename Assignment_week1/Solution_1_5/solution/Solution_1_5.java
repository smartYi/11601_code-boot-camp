package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_5 {
	
	//Function to determine the number of edit operations
	
	public static boolean oneWay(String str1, String str2) {
		
		//Calculate the length difference
		
		int lengthDifference = Math.abs(str1.length()-str2.length());
		
		//If the length difference is bigger than 1, return false
		
		if(lengthDifference>1) return false;
		
		//If length difference is 0, so replace a character is permitted

		if(lengthDifference == 0){
			int replace = 0;
			for(int i=0;i<str1.length();i++){
				
				//If there is a different character, replace increments
				
				if(str1.charAt(i)!=str2.charAt(i)) replace++;
			}
			//If replacement is less than 1, return true.
			return replace<=1;
		}
		
		//If length difference equals to 1, so remove or insert is permitted.
		
		if(lengthDifference == 1){
			//If str1 length is less than str2 length
			if(str1.length()<str2.length()) return oneEditOps(str1,str2);
			
			//If str1 length more than str2 length
			else return oneEditOps(str2,str1);
		}
		return true;
	}
	
	
	//If the length difference is 1, call this function
	
	public static boolean oneEditOps(String str1, String str2){
		
		//Two indexes to indicate the compare progress
		
		int index1 = 0;
		int index2 = 0;
		
		//To determine the operations between str1 and str2
		
		while(index1<str1.length() && index2<str2.length()){
			//If the character is not the same
			if(str1.charAt(index1)!=str2.charAt(index2)){
				if(index1!=index2) return false;
				else index2++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	
	//Main function
	public static void main(String[] args){
		
		//Case 1:
		String str1 = "pale";
		String str2 = "ple";
		
		//Case 2:
		String str3 = "pales";
		String str4 = "pale";
		
		//Case 3:
		String str5 = "pale";
		String str6 = "bale";
		
		//Case 4:
		String str7 = "pale";
		String str8 = "bake";
		
		//Call function
		boolean result1 = oneWay(str1, str2);
		boolean result2 = oneWay(str3, str4);
		boolean result3 = oneWay(str5, str6);
		boolean result4 = oneWay(str7, str8);
		
		//Print out results
		System.out.println("After function call: ");
		System.out.println("Test of String \"pale\" and \"ple\" is = "+ result1);
		System.out.println("Test of String \"pales\" and \"pale\" is = "+ result2);
		System.out.println("Test of String \"pale\" and \"bale\" is = "+ result3);
		System.out.println("Test of String \"pale\" and \"bake\" is = "+ result4);
	}
}

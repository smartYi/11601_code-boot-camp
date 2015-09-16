package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/


public class Solution_1_6 {
	
	//Function to compress string 
	
	public static String stringCompress(String str){
		
		//If string length is 0, return string
		if(str.length() == 0) return str;
		
		//If string length is not 0
		
		int length = str.length();
		
		//Cast string to character array
		char[] array = str.toCharArray();
		
		//To store the result string
		String result = String.valueOf(array[0]);
		
		//Loop to compress the string
		
		//Number count of current character
		int count = 1;
		
		for(int i=0;i<length-1;i++){
			
			//If two characters are the same, number increments
			if(array[i] == array[i+1]){
				count++;
			}else{
				
				//If not the same, add to the result string and reset the number
				result = result+String.valueOf(count) + String.valueOf(array[i+1]);
				count = 1;
			}
		}
		//Add the last character's number
		result = result+String.valueOf(count);
		
		//If original string length is less than result length, return original length
		
		return (str.length()<result.length())?str:result;
	}
	
	//Main function
	public static void main(String[] args){
		
		//Case 1: This case original string length is more than result string length 
		String str1 = "aabcccccaaa";
		
		//Case 2: This case original string length is less than result string length 
		String str2 = "AbcdD";
		
		//Call function 
		String result1 = stringCompress(str1);
		String result2 = stringCompress(str2);
		
		//Print out results
		System.out.println("After function call: ");
		System.out.println("Test of String \"aabcccccaaa\" is = "+ result1);
		System.out.println("Test of String \"AbcdD\" is = "+ result2);
	}
}

package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_4 {
	
	//Get the according number of character c 
	public static int getCharNumber(char c){
		
		//Get the boundary number of letters
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		
		//Get the the number of input character c 
		int val = Character.getNumericValue(c);
		
		//To determine its according number regardless its form, capital or lower case
		if(val>=a && val<=z){
			return val-a;
		}else if(val>=A && val<=Z){
			return val-A;
		}
		return -1;
	}
	
	public static boolean isPermutationPalindrome(String str){
		//To store the number of odds in the string
		int countOdd = 0;
		
		//Cast the string to char array
		char[] array = str.toCharArray();
		
		int[] table = new int[Character.getNumericValue('z')-
		                      Character.getNumericValue('a')+1];
		
		//Go through the character array
		for(char c:array){
			
			//To calculate the number of input character x
			
			int x = getCharNumber(c);
			if(x!=-1){
				
				//If x is a alphabet, calculate its appearance number
				table[x]++;
				
				//If the appearance number is an odd number, countOdd increments
				if(table[x]%2 == 1) {
					countOdd++;
				}
				//Else countOdd decrements
				else{
					countOdd--;
				}
			}
		}
		if(countOdd<=1) return true;
		else return false;
	}
	
	//Main function 
	public static void main(String[] args){
		
		//Test case 1
		String str1 = "Tact coa";
		
		//Test case 2
		String str2 = "cda swdx";
		
		//Call function
		boolean result1 = isPermutationPalindrome(str1);
		boolean result2 = isPermutationPalindrome(str2);
		
		//Print out results
		System.out.println("After function call: ");
		System.out.println("Test of String \"Tact coa\" is = "+ result1);
		System.out.println("Test of String \"cda swdx\" is = "+ result2);
	}
}

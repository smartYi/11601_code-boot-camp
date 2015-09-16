package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_3 {
	
	public static char[] cutSpace(char[] str,int length){
		int count = 0;
		int newLength = 0;
		//First calculate the number of spaces
		for(int i=0;i<length;i++){
			if(str[i]==' ') count++;
		}
		newLength = count*2+length;
		char[] result  = new char[newLength];
		for(int i=length-1;i>=0;i--){
			//If there is a space
			if(str[i]==' '){
				result[newLength-1] = '0';
				result[newLength-2] = '2';
				result[newLength-3] = '%';
				newLength-=3;
			}else{
				//If there is not a space
				result[newLength-1] = str[i];
				newLength-=1;
			}
		}
		return result;
	}
	
	//Main function
	public static void main(String[] args){
		//Test case 1
	String str1 = "Mr John Smith  ";
	str1 = str1.trim();
	int length1 = str1.length();
	//Cast string to array
	char[] temp1 = str1.toCharArray();
	char[] result1 = cutSpace(temp1, length1);
	String output1 = new String(result1);
	
	//Test case 2
	String str2 = "Have a happy day !  ";
	str2 = str2.trim();
	int length2 = str2.length();
	//Cast string to char array
	char[] temp2 = str2.toCharArray();
	char[] result2 = cutSpace(temp2, length2);
	String output2 = new String(result2);
	
	//Print out results
	System.out.println("After function call: ");
	System.out.println("Test of String \"Mr John Smith   \"is = "+ output1);
	System.out.println("Test of String \"Have a happy day ! \" is = "+ output2);
	}
}

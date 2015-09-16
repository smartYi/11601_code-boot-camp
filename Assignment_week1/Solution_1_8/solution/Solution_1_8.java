package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_8 {
	//These matrixes is going to be rotated
	
	private static int[][] matrix1 = {{1,2,3,4},
		                              {5,0,7,8},
						              {3,6,4,9},
						              {1,3,0,9}};
		
	private static int[][] matrix2 = {{0,12,32,12},
						              {45,27,19,41},
						              {29,37,51,73},
						              {36,23,57,0}};
	
	//This function is to nullify a matrix
	
	public static void zeroMatrix(int[][] matrix){
		
		//Store the number row and number of column
		int row = matrix.length;
		int column = matrix[0].length;
		
		//Create two boolean arrays to ID zero location
		boolean[] rowID = new boolean[row];
		boolean[] columnID = new boolean[column];
		
		//Loop to go through the whole matrix and set zero locations
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(matrix[i][j] == 0){
					rowID[i] = true;
					columnID[j] = true;
				}
			}
		}
		
		//To nullify matrix row by row
		for(int i=0;i<row;i++){
			if(rowID[i]) nullifyMatrixRow(matrix,i);
		}
		
		//To nullify matrix column by column
		for(int j=0;j<column;j++){
			if(columnID[j]) nullifyMatrixColumn(matrix,j);
		}
	}
	
	//Function to set all numbers in the same row to zero
	public static void nullifyMatrixRow(int[][] matrix,int row){
		for(int i=0;i<matrix[0].length;i++){
			matrix[row][i] = 0;
		}
	}
	
	//Function to set all numbers in the same column to zero
	public static void nullifyMatrixColumn(int[][] matrix,int column){
		for(int i=0;i<matrix.length;i++){
			matrix[i][column] = 0;
		}
	}
	
	//Function to print out matrix
	public  static void  printMatrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Main function
	public static void main(String[] args){
		        //Before set zero
				printMatrix(matrix1);
				printMatrix(matrix2);
				
				//Case 1: matrix1
				zeroMatrix(matrix1);
				
				//Case 2: Matrix2
				zeroMatrix(matrix2);
				
				//Print out results
				System.out.println("After function call: ");
				printMatrix(matrix1);
				printMatrix(matrix2);
	}
}

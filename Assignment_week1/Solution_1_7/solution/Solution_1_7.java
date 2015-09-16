package solution;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Solution_1_7 {
	//These matrixes is going to be rotated
	
	private static int[][] matrix1 = {{1,2,3,4},
	                   {5,6,7,8},
					   {3,6,4,9},
					   {1,5,9,3}};
	
	private static int[][] matrix2 = {{20,12,32,12},
					   {45,27,19,41},
					   {29,37,51,73},
					   {36,23,57,81}};
	
	//This function is to rotate N*N matrix by 90 degrees
	
	public static void matrixRotate(int[][] matrix, int n){
		//We can rotate this matrix layer by layer
		for(int layer = 0;layer<n/2;layer++){
			int first = layer;
			int last  = n - 1 -layer;
			for(int i = first;i<last;i++){
				int offset = i-first;
				
				//save top
				int top = matrix[first][i];
				
				//left --> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom --> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				//right --> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top -->right
				matrix[i][last] = top;
			}
		}
	}
	
	public  static void  printMatrix(int[][] matrix,int n) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Main function 
	public static void main(String[] args){
		//Before rotation
		printMatrix(matrix1, 4);
		printMatrix(matrix2, 4);
		
		//Case 1: matrix1
		matrixRotate(matrix1, 4);
		
		//Case 2: Matrix2
		matrixRotate(matrix2, 4);
		
		//Print out results
		System.out.println("After function call: ");
		printMatrix(matrix1, 4);
		printMatrix(matrix2, 4);
	}
}

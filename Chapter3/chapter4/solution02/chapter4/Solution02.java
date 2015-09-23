package chapter4;

/**
 * This method is to create a minimal BST based on a sorted array.
 * From the algebraic derivation, we can conclude that the total nodes
 * for a perfect BST is 2^n-1, where n is the depth of the tree.
 * <p>
 * Since our aim is to create a BST, our idea is to first store the middle array 
 * data as the root and recursively create the sub-left BST and sub-right BST.
 * 
 * @author qiuyi
 * @since sep/19/2015
 */

public class Solution02 {
	
	public BSTreeNode createMinimal(int[] array) {
		
		//Get the array size
		int size = array.length;
		
		//If the array size is zero, this is a null node.
		if(size == 0) return null;
		
		//Create a BSTNode for the middle array data
		BSTreeNode root = new BSTreeNode();
		root.setValue(array[size/2]);
		
		//Create the left part array and right part array.
		int[] leftArray = new int[size/2];
		int[] rightArray = new int[size-(size/2)-1];
		
		//Copy from array to two sub-arrays.
		for(int i=0;i<size/2;i++){
			leftArray[i] = array[i];
		}
		for(int i=size/2+1;i<size;i++){
			rightArray[i-size/2-1] = array[i];
		}
		
		//Create sub-tree for both left array and right array.
		BSTreeNode left = createMinimal(leftArray);
		BSTreeNode right = createMinimal(rightArray);
		
		//Join the left sub-tree and right sub-tree with the root.
		join(root,left,right);
		
		return root;
	}
	
	/**
	 * This method is to join the left node and right node with the root node.
	 * @param root
	 * @param left
	 * @param right
	 */
	public void join(BSTreeNode root, BSTreeNode left, BSTreeNode right) {
		root.setLeftChild(left);
		root.setRightChild(right);
	}
}

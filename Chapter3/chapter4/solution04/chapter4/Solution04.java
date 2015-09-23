package chapter4;

/**
 * This java file is to check whether a tree is a balanced tree.
 * Our idea is to adopt recursion way to check the left sub-tree and 
 * the right sub-tree.
 *  
 * @author qiuyi
 * @since sep/19/2015
 */
public class Solution04 {
	
	public boolean isBalanced(BSTreeNode root) {
		
		if(root == null) return true;
		
		//Get left tree and right tree height
		int leftHeight = getDepth(root.getLeftChild());
		int rightDepth = getDepth(root.getRightChild());
		
		//Two different situations
		if((Math.abs(leftHeight)-rightDepth)>1) {
			return false;
		}else {
			return (isBalanced(root.getLeftChild()) && isBalanced(root.getRightChild()));	
		}
	}
	
	/**
	 * This method is to get the height of a tree.
	 * The height of a tree is determined by its height of left sub-tree
	 * and the height of right sub-tree.
	 * 
	 * @param root
	 * @return
	 */
	public int getDepth(BSTreeNode root) {
		if(root == null) return 0;
		return Math.max(getDepth(root.getLeftChild()), getDepth(root.getRightChild()))+1;
	}
}

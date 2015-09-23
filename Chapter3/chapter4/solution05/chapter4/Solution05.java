package chapter4;

/**
 * This java file is to check whether a tree is a BST or not.
 * According to the definition of a BST, we can divide this problem into 
 * two sub-problems, which is also recursion here.
 * We subsequently check left sub-tree and right sub-tree.
 * 
 * @author qiuyi
 * @since sep/19/2015
 */
public class Solution05 {
	
	public boolean isBST(BSTreeNode root) {
		if(root == null || 
		  (root.getLeftChild() == null && root.getRightChild() == null)) {
			return true;
		}
		int rootValue = root.getValue();
		
		if(root.getLeftChild() == null){
			int rightValue = root.getRightChild().getValue();
			if(rightValue < rootValue) return false;
			else return isBST(root.getRightChild());
		}else if(root.getRightChild() == null) {
			int leftVlaue = root.getLeftChild().getValue();
			if(leftVlaue > rootValue) return false;
			else return isBST(root.getLeftChild());
		}else {
			int rightValue = root.getRightChild().getValue();
			int leftVlaue = root.getLeftChild().getValue();
			if(leftVlaue < rootValue && rootValue < rightValue) {
				return (isBST(root.getLeftChild()) && isBST(root.getRightChild()));
			}
			else return false;
		}
		
	}
}

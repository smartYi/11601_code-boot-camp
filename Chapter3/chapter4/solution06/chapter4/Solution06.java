package chapter4;

/**
 * This java file is to find the next node of a given node.
 * We assume this is in-order traversal.
 * 
 * @author qiuyi
 * @since sep/19/2015
 */
public class Solution06 {
	
	public BSTreeNode inOrderSucc(BSTreeNode root) {
		if(root == null) return null;
		
		if(root.getRightChild() != null) {
			return leftMost(root.getRightChild());
		}else {
			BSTreeNode node = root;
			BSTreeNode parent = root.parent;
			
			while(parent != null && parent.getLeftChild()!=node) { 
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	public BSTreeNode leftMost(BSTreeNode node) {
		if(node == null) return null;
		while(node.getLeftChild()!=null) {
			node = node.getLeftChild();
		}
		return node;
	}
}

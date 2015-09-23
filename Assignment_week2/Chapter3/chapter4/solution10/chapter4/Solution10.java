package chapter4;

public class Solution10 {
	public boolean containsTree(BSTreeNode t1, BSTreeNode t2) {
		if(t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	
	public boolean subTree(BSTreeNode t1, BSTreeNode t2) {
		if(t1 == null) {
			return false;
		}else if(t1.getValue() == t2.getValue() && matchTree(t1, t2)) {
			return true;
		}
		return subTree(t1.getLeftChild(), t2) || subTree(t1.getRightChild(), t2);
	}
	
	public boolean matchTree(BSTreeNode t1, BSTreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}else if(t1 == null || t2 == null) {
			return false;
		}else if(t1.getValue() != t2.getValue()) {
			return false;
		}else {
			return (matchTree(t1.getLeftChild(), t2.getLeftChild()) && matchTree(t1.getRightChild(), t2.getRightChild()));
		}
	}
}

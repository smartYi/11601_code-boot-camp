package chapter4;

public class Solution08 {
	public BSTreeNode findCommonAncestor(BSTreeNode root, BSTreeNode p, BSTreeNode q) {
		if(!covers(root,p) || !covers(root,q)) {
			return null;
		}
		
		return ancesterHelper(root,p,q);
		
	}
	
	public boolean covers(BSTreeNode root, BSTreeNode p) {
		if(root == null) return false;
		if(root == p) return true;
		return covers(root.getLeftChild(), p) || covers(root.getRightChild(), p);
	}
	
	public 	BSTreeNode ancesterHelper(BSTreeNode root, BSTreeNode p, BSTreeNode q) {
		if(root == null) {
			return null;
		}else if(root == p){
			return p;
		}else if(root == q) {
			return q;
		}
		
		boolean isLeft = covers(root.getLeftChild(), p);
		boolean isRight = covers(root.getRightChild(), q);
		if(isLeft != isRight) {
			return root;
		}
		BSTreeNode next = isLeft?root.getLeftChild():root.getRightChild();
		return ancesterHelper(next, p, q);
	}
}

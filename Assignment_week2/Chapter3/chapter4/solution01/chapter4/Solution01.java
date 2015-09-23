package chapter4;

/**
 * This java file creates a method to determine whether two nodes are connected or not.
 * This method should be called by a graph and with input the source node and destination node.
 * Both DFS and BFS work. 
 * In DFS, I use recursive way to find the destination node.
 * While in BFS, a queue is used to check the two nodes, which is a iterative way.
 * In this class, only DFS is implemented. BFS can be a follow-up.
 * 
 * @author qiuyi
 * @since sep/19/2015
 * 
 */

public class Solution01 {
	
	public static boolean isConnected(GraphNode a, GraphNode b) {
		
		if(a == null || b == null) return false;
		return search(a,b);
	}
	
	public static boolean search(GraphNode root, GraphNode target) {
		if(root == null) return false;
		int temp = visit(root);
		root.setFlag(true);
	    if( temp == visit(target)) {
	    	return true;
	    }
	    
	    for (GraphNode n : root.getChildren()) {
			if(n.isFlag() == false) {
				search(n, target);
			}
	    }
	    return false;
	}
	
	public static int visit(GraphNode node) {
		return node.getData();
	}
	
}

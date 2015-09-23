package chapter4;

public class Solution12 {
	public int countPathWithSum(BSTreeNode root, int targetSum) {
		if(root == null) return 0;
		
		int pathsFromRoot = countPathWithSumFromNode(root, targetSum,0);
		
		int pathsOnLeft = countPathWithSum(root.getLeftChild(), targetSum);
		int pathsOnRight = countPathWithSum(root.getRightChild(), targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	public int countPathWithSumFromNode(BSTreeNode node, int targetSum, int currentSum) {
		if(node == null) return 0;
		currentSum += node.getValue();
		
		int totalPaths = 0;
		if (currentSum == targetSum) {
			totalPaths++;
		}
		
		totalPaths += countPathWithSumFromNode(node.getLeftChild(), targetSum, currentSum);
		totalPaths += countPathWithSumFromNode(node.getRightChild(), targetSum, currentSum);
		
		return totalPaths;
	}
}

package chapter4;

import java.util.LinkedList;

/**
 * This java file is to create several linked lists to store a binary tree data.
 * A linked list should store these tree data at the same depth, which means if you have 
 * a tree with depth D, then you have D linked lists.
 * 
 * @author qiuyi
 * @since sep/19/2015
 */
public class Solution03 {
	
	public LinkedList<LinkedList<BSTreeNode>>listDepths(BSTreeNode root) {
		
		if(root == null) return null;
		
		LinkedList<LinkedList<BSTreeNode>> list = new LinkedList<>();
		
		//First a rootList is created to add the root.
		LinkedList<BSTreeNode> rootList = new LinkedList<>();
		rootList.add(root);
		list.addLast(rootList);
		
		//Then we do level-order traversal, which is also referred to the BFS. 
			while(rootList.size()!=0){
				list.addLast(rootList);
				LinkedList<BSTreeNode> parent = rootList;
				rootList = new LinkedList<>();
				
				for (BSTreeNode node: parent) {
					if(node.getLeftChild()!=null) {
						rootList.addLast(node.getLeftChild());
					}
					if(node.getRightChild()!=null) {
						rootList.addLast(node.getRightChild());
						}
					}
				}
		return list;
		}
	}

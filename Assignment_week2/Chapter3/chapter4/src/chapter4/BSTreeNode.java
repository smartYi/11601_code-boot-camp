package chapter4;


/**
 * This java class file defines a base data structure BST tree node, which is a basis for implementing a BST.
 * A regular BST node often includes its value and the pointer to its two children.
 * A regular tree often has than two children, left child, whose value is less or equal to the node value and
 * the right child, whose value is bigger than the node value.
 *  
 * @author qiuyi
 * @since sep/19/2015
 * 
 */
public class BSTreeNode {
	private int value;
	private BSTreeNode leftChild;
	private BSTreeNode rightChild;
	public BSTreeNode parent;
	private int size = 0;
	
	public BSTreeNode(int d) {
		// TODO Auto-generated constructor stub
		value = d;
		size = 1;
	}
	public BSTreeNode(){}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSize() {
		return size;
	}
	public BSTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BSTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BSTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BSTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}

package chapter4;

public class GraphNode {
	private int data;
	private GraphNode[] children;
	private boolean flag = false;
	
	
	public GraphNode[] getChildren() {
		return children;
	}
	public void setChildren(GraphNode[] children) {
		this.children = children;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
}

package solution;

public class Listy {
	private int[] array;
	
	public Listy(int[] array) {
		this.array = array;
	}
	
	public int  elementAt(int i) {
		if(i<array.length) return array[i];
		else return -1;
	}
}

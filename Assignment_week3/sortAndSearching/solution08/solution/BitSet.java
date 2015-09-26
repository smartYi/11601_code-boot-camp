package solution;


public class BitSet {
	private int[] bitset;
	
	public BitSet(int size) {
		bitset = new int[(size >> 5) + 1];
	}
	
	public boolean get(int index) {
		int wordIndex = (index>>5);
		int bitIndex = index%32;
		return (bitset[wordIndex] & (1<<bitIndex)) !=0;
	}
	
	public void set(int index) {
		int wordIndex = (index>>5);
		int bitIndex = index%32;
		bitset[wordIndex] |= (1<<bitIndex);
	}
}

package solution;


public class Solution08 {
	public void findDuplicates(int[] array) {
		BitSet bitSet = new BitSet(32000);
		for(int i=0;i<array.length;i++) {
			int num = array[i];
			if(bitSet.get(num-1)) {
				System.out.println(num);
			}else {
				bitSet.set(num-1);
			}
		}
	}
}

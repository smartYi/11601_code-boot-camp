package solotion01;

/**
 * This class file is to merge two sorted array into one.
 * Assume that one array has the enough capacity to hold the new array.
 * @author qiuyi
 *
 */
public class Soloution01 {
	
	/**
	 * This method is to merge two sorted array.
	 * Array des is the destination array and array src is the source array.
	 * Assume that array des has the enough capacity to hold the array src.
	 * Parameter length is the size, 
	 * which means the number of elements contained in the array.
	 * @param des
	 * @param src
	 * @param length
	 */
	public void sortedMerge(int[] des, int[] src, int length) {
		int newLength = length - 1;
		int size = des.length -1;
		int index = src.length - 1;
		while(index>=0) {
			if(src[index] > des[newLength]) {
				des[size] = src[index];
				index--;
				size--;
			}else {
				des[size] = des[newLength];	
				newLength--;
				size--;
			}
		}
		return;
	}
}

package solution;

/**
 * This class file is to solve the 100 lockers problem.
 * Actually this problem is about modified prime decomposition.
 * We already know that the man toggles the locker each time when he passes the hallway.
 * and at the very first the locker is closed. So in this way we know that if the given number
 * has odd number of divisions (1 and itself included), 
 * we can conclude that the locker is open after 100 passes.
 * @author qiuyi
 *
 */
public class Solution09 {
	
	/**
	 * This method is to print out the locker number.
	 * @param n
	 */
	public static void printOpenLocker(int n) {
		boolean[] isOpen = isOpen(n);
		for(int i=1;i<=n;i++) {
			if(isOpen[i]) System.out.println(i + " ");
		}
	}
	
	/**
	 * This method is to determine which locker is open.
	 * @param n
	 * @return
	 */
	public static boolean[] isOpen(int n) {
		boolean[] isopen = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			isopen[i] = isOpenHelper(i);
		}
		return isopen;
	}
	
	/**
	 * This method is to check the number of divisions of each number, 1 and itself included.
	 * @param x
	 * @return
	 */
	public static boolean isOpenHelper(int x) {
		
		int numberOfDivision = 0;
		if(x == 1) return true;
		for(int i=2;i<=Math.sqrt(x);i++) {
			if(x % i == 0) {
				if(i == Math.sqrt(x)) numberOfDivision++;
				else numberOfDivision+=2;
			}
		}
		
		//Add itself and 1.
		numberOfDivision+=2;
		
		//If the number of divisions is even, the locker is closed.
		if(numberOfDivision % 2 == 0) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Test begins");
		printOpenLocker(100);
	}
}

package solution;

/**
 * This class file is to solve the poison problem.
 * The main idea for this problem is to use binary representation.
 * Since we have 10 test stripes, we can formulate a binary string as XXXXXXXXXX.
 * In the binary string, I assume 0 means no poison test in this stripe and 1 means
 * do poison test in this stripe. For example, 0000000110 means we do poison test 
 * in test stripe #2 and #3.
 * Then we need to set another meaning of XXXXXXXXXX. Since we have 1000 bottles, it's 
 * enough to represent with 10 binary digits. So in this case, the binary representation 
 * of 0000000110 also means that we select #6 bottle to do test in test stripe #2 and #3.
 * Finally we can conclude that:
 * For bottle #1, we only use it to do test in stripe #1, the binary representation is 0000000001;
 * For bottle #2, we only use it to do test in stripe #2, the binary representation is 0000000010;
 * For bottle #3, we use it to do tests in stripe #1 and #2, the binary representation is 0000000011;
 * .....
 * For bottle #1000, we use it to do test in stripe #1.., the binary representation is 1111101000;
 * Since there is only one bottle contains poison, we can deduce the poisonous bottle with 
 * the positive status.
 * If only the third stripe shows positive, it means the binary representation is 0000000100,
 * so the poisonous bottle is #4.
 * If all 1, 4, 7, 9 stripes shows positive, it means the binary representation is 0101001001,
 * so the poisonous bottle is 1+8+64+256=329.
 * </p>
 * The following code is a simulation for this process.
 * @author qiuyi
 *
 */
public class Solution10 {
	
	/**
	 * This method is to determine which bottle is poisonous.
	 * Since the idea is clearly demonstrated above, I only give the 
	 * simulation for each stripe test result, in which I set the poisonous probability is 0.3.
	 * But in such case, there exists possibility that the bottle number is larger than 1000
	 * since 2^10 = 1024. If this is happening, I do this simulation again until 
	 * I get a number no more than 1000.
	 * The code is very simple and to some content useless, because I think the analysis 
	 * of this problem should be the focus.
	 * @param stripe
	 * @return
	 */
	public static void isPoison(int stripe) {
		boolean[] test = new boolean[stripe];
		int number = 0;
		for(int i=0;i<stripe;i++) {
			if(Math.random() <= 0.3) test[i] = true;
		}
		
		System.out.println("The stripes shows positive are:");
		for(int i=0;i<stripe;i++) {
			if(test[i]) {
				number+=(Math.pow(2, i));
				System.out.println(i+1);
			}
		}
		System.out.println("The binary representation is: " + Integer.toBinaryString(number));
		System.out.println("The poisonous bottle is: " + number);
	}
	
	public static void main(String[] args) {
		isPoison(10);
	}
}

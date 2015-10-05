package solution;

/**
 * This class file is to solve a probability problem.
 * Idea is very simple, if the probability of making one shot is p,
 * the probability of making two shots out of 3 shots belongs to 
 * binomial distribution. 
 * p(2 out of 3) = C(3,2)*p^2*(1-p) = 3p^2(1-p) = 3p^2 - 3p^3;
 * p(3 out of 3) = C(3,3)8p^3*(1-p)^0 = p^3;
 * The we can derive inequality that 3p^2-2p^3 > p;
 * we can get if 0.5 < p < 1, choose game 2; if p<0.5 or p=1, choose game 1.
 * if p=0.5,either one is fine.  
 * @author qiuyi
 *
 */
public class Solution02 {
	public static void main(String[] args) {
		System.out.print("Read documentation");
	}
}

package solution;

/**
 * This class file is to sovle the ant collision problem.
 * For three ants is different angles in a triangle, there are only two cases that 
 * these three ants never meet, that are they all proceed in the same direction, either
 * clockwise or counterclockwise. So the probability that they meet is very simple and 
 * Subtract these two probabilities from one can get the result.
 * p(clockwise) = 0.5*0.5*0.5 = 0.125;
 * p(counterclockwise) = 0.5*0.5*0.5 = 0.125;
 * So p(collision) = 1- p(clockwise)-p(counterclockwise) = 0.75.
 * For n-vertex polygon, the idea is the same, we just tune the parameters and can get 
 * the p(collision) = 1-(0.5)^(n-1).
 * @author qiuyi
 *
 */
public class Solution04 {
	public static void main(String[] args) {
		System.out.print("Read documentation");
	}
}

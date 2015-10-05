package solution;

/**
 * This class file is to solve the egg drop problem.
 * Actually this is a DP problem. Assume that we have k eggs and the building is n floor,
 * we set dp(n,k) to be the minimum drops of determine which floor is the boarding floor.
 * So the main idea is that if we drop the first egg at the pth floor, two cases may happen:
 * 1): The egg breaks: In this case, we already lose one egg, and also know the boarding 
 * floor must be no more than p, so the problem becomes dp(p-1,k-1);
 * 2): The egg is intact: We still have k eggs, but also we know the boarding floor must 
 * be no less than p,so the problem becomes dp(n-p,k);
 * So we can get the dp(n,k) = min{max{dp(n-p,k),dp(p-1,k-1)}+1};
 * Also the boundary condition is dp(n,1) = n since if we only have one egg, the worst case is
 * that we test n times to determine the boarding floor.
 * And dp(1,k) = 1, since if there is only one floor we only test one time to determine 
 * the boarding floor.
 * @author qiuyi
 *
 */
public class Solution08 {
	public static int getDropOption(int floor, int egg) {
		int[][] dp = new int[floor+1][egg+1];
		
		//Boundary condition
		for(int i=1;i<=egg;i++) dp[1][i] = 1;
		for(int i=1;i<=floor;i++) dp[i][1] = i;
		
		//DP process
		for(int i=2;i<=floor;i++) {
			for(int j=2;j<=egg;j++) {
				int minimum = Integer.MAX_VALUE;
				for(int k=1;k<=i;k++) {
					int temp = Math.max(dp[k-1][j-1], dp[i-k][j])+1;
					if(temp < minimum) minimum = temp;
				}
				dp[i][j] = minimum;
			}
		}
		return dp[floor][egg];
	}
	
	public static void main(String[] args) {
		System.out.println("Test begins!");
		System.out.print(getDropOption(100, 2));
	}
}

package solution;

/**
 * This class file is to solve the gender ratio of next generation given family number n.
 * The main idea is to consider all the families as a unity since when we calculate the 
 * gender ratio, only the number of girls and boys matter and which family they come from
 * doesn't matter.
 * So we only need to count the number of girls and boys in all families. But also country
 * policy must be satisfied that is if there is one girl in a family and the parents can no
 * longer have another child (*^*).
 * @author qiuyi
 *
 */
public class Solution07 {
	/**
	 * This method is to return the gender ratio in the whole country.
	 * @param n
	 * @return
	 */
	public static double getGenderRatio(int n) {
		int boys = 0;
		int girls = 0;
		
		for(int i=0;i<n;i++) {
			int[] oneFamily = getOneFamily();
			boys+=oneFamily[0];
			girls+=oneFamily[1];
		}
		return girls*(1.0) / (boys+girls);
	}
	
	/**
	 * This method is to get the number of boys and girls in one family.
	 * @return
	 */
	public static int[] getOneFamily() {
		int boys = 0;
		int girls = 0;
		
		while( girls == 0 ) {
			double prob = Math.random();
			if(prob>=0.5) girls++;
			else boys++;
		}
		int[] gender = {boys,girls};
		return gender;
	}
	
	public static void main(String[] args) {
		System.out.print(getGenderRatio(200));
	}
}

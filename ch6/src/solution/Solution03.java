package solution;

/**
 * This class file is to solve the dominos problem.
 * Given the condition that a 8*8 chessboard is cut off two 
 * lattice at the diagonally opposite corners.
 * Let's say that the 8*8 chessboard is tagged with color, white and dark,
 * and their position is alternating. That means a white lattice is surrounded
 * by dark lattices and vice versa.
 * And now we remove two lattice that has the same color, which means
 * there are only 30 white(dark) lattices and 32 dark(white) lattices left,
 * And we already know that each domino occupys two adjacent lattices,
 * that must be a dark one and a white one. So 31 dominos will consume
 * 31 dark lattices and 31 white lattices, which is not gonna happen.
 * So it's impossible to put 3 dominos into the incompleted chessboard.
 * @author qiuyi
 *
 */
public class Solution03 {
	public static void main(String[] args) {
		System.out.print("Read documentation");
	}
}

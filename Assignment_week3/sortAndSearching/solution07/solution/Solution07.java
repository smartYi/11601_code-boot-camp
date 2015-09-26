package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution07 {
	private static long numberOfInts = ((long)Integer.MAX_VALUE)+1;
	private static byte[] bitSet = new byte[(int)(numberOfInts / 8)];
	
	public void findOpenNumber(String filename) throws FileNotFoundException, IOException {
		BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
										new FileInputStream(filename)));
		String s;
		while((s = bufferedReader.readLine()) != null) {
			int element = Integer.parseInt(s);
			bitSet [element / 8] |= 1 << (element % 8); 
		}
		
		bufferedReader.close();
		
		for(int i=0;i<bitSet.length;i++) {
			for(int j=0;j<8;j++) {
				if((bitSet[i] & (1<<j)) == 0) {
					System.out.println(i*8+j);
					return;
				}
			}
		}
	}
}

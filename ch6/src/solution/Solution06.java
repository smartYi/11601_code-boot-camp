package solution;

/**
 * This class file is to solve the problem of blue-eyed.
 * Since at least one blue-eyed person exists. We can analyze this problem step by step:
 * 1: Only one blue-eyes person. The only one will find that everyone else is not 
 * blue-eyed, so he will conclude that he is the one and he will escape away at the first night.
 * 2: Two blue-eyed persons. When the two see each other, they know that there exists at least
 * one person with blue-eyes, and if there is only one person with blue eyes, he will escape 
 * away at the first night as above case indicated. 
 * and if they see the other person with blue-eyes is still on island, and they will 
 * conclude that there are two persons with blue eyes and they will escape at the second night.
 * 3: Three blue-eyed persons. Each person with blue eyes will see two persons with blue eyes
 * and from above case indicated that if there are two persons with blue eyes, they will escape
 * at the second night. And if they find other two persons with blue eyes are still on island,
 * they know that there are three persons with blue eyes and they will escape together at the
 * third night.
 * 4:From the above case, we can conclude that if there are n persons with blue eyes, it will 
 * take n nights to escape away and the n persons will escape together.   
 * @author qiuyi
 *
 */
public class Solution06 {
	public static void main(String[] args) {
		System.out.print("Read documentation");
	}
}

import java.math.BigInteger;
import java.util.Scanner;

class Solution{

   	public static void main(String []args){ 
        	Scanner stdin = new Scanner(System.in);
    		BigInteger bigInteger1 = new BigInteger(String.valueOf(stdin.next()));
        	BigInteger bigInteger2 = new BigInteger(String.valueOf(stdin.next()));
        	System.out.println(bigInteger1.add(bigInteger2));
        	System.out.println(bigInteger1.multiply(bigInteger2));
	}
}

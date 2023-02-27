import java.util.*;

public class DigtSum4 
{
	DigtSum4(Scanner s){
		Main.dis(this);
		System.out.println("Enter num :");
		getSum(s.nextInt());
	}

	private void getSum(int nextInt) {
		int rev = 0;
		while(nextInt != 0){
			rev += nextInt%10;
			nextInt/=10;
		}
		System.out.println(rev);
	}
}

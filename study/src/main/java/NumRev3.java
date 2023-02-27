import java.util.*;

public class NumRev3 
{
	NumRev3(Scanner s){
		Main.dis(this);
		System.out.println("Enter num :");
		getRev(s.nextInt());
	}

	private void getRev(int nextInt) {
		int rev = 0;
		while(nextInt != 0){
			rev*=10;
			rev += nextInt%10;
			nextInt/=10;
		}
		System.out.println(rev);
	}
}

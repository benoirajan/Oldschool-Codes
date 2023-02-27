import java.util.*;

public class Fibonancy {
	public static void getFibo(int n){
		int f=0,s=1,t;
		System.out.println(f);
		System.out.println(s);
		for(int i=2;i<n;i++){
			System.out.println(t=f+s);
			f=s;s=t;
		}
	}
	
	Fibonancy(Scanner s){
		Main.dis(this);
		System.out.println("Enter num :");
		getFibo(s.nextInt());
	}
}

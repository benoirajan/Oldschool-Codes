
import java.nio.channels.*;
import java.util.*;public class Fact1  
{
	public static void getFact(int num){
		for(int i=num-1;i>1;i--)
			num*=i;
		System.out.println(num>0?num:1);
	}
	
	Fact1(Scanner s){
		Main.dis(this);
		System.out.println("Enter Number");
		getFact(s.nextInt());
	}
}


import java.net.*;
import java.util.*;public class MultTab2  
{
	void getMult(int num){
		for(int i=1;i<=10;i++)
			System.out.println(String.format("%d * %d = %d",i,num,i*num));
	}
	MultTab2(Scanner s){
		Main.dis(this);
		System.out.println("Enter num");
		getMult(s.nextInt());
	}
}

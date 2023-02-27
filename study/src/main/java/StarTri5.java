
import java.util.*;public class StarTri5 {
	public static void pStar(int l) {
		for (int i=1;i <= l;i++) {
			for (int j=0;j < i;j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	StarTri5(Scanner s){
		Main.dis(this);
		System.out.println("Enter no. of lines");
		pStar(s.nextInt());
	}
}

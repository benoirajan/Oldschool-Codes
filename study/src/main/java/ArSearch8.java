import java.util.*;

public class ArSearch8 
{
	ArSearch8(Scanner s){
		Main.dis(this);
		System.out.println("Enter num of elements");
		large(s.nextInt(),s);
	}

	private void large(int size,Scanner s) {
		int a[] = new int[size];
		System.out.println("Enter the values");
		for(int i=0;i<a.length;i++)
			a[i] = s.nextInt();
		System.out.println("Search for");
		int search = s.nextInt();
		for (int i = 0;i<a.length;i++)
			if(a[i]==search){
				System.out.println("Loc="+i);
				return;
			}
		System.out.println("Not found");
	}
}

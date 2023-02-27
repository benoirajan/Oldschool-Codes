import java.util.*;

public class ArrayLarge7 
{
	ArrayLarge7(Scanner s){
		Main.dis(this);
		System.out.println("Enter num of elements");
		large(s.nextInt(),s);
	}

	private void large(int size,Scanner s) {
		int a[] = new int[size];
		System.out.println("Enter the values");
		for(int i=0;i<a.length;i++)
			a[i] = s.nextInt();
		int big = 0;
		for (int i:a)
			big = big > i ? big: i;
		System.out.println("Large :"+big);
	}
}

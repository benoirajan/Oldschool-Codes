import java.util.*;

public class ArrayDis6 
{
	ArrayDis6(Scanner s){
		Main.dis(this);
		System.out.println("Enter num of elements");
		display(s.nextInt(),s);
	}

	private void display(int size,Scanner s) {
		int a[] = new int[size];
		System.out.println("Enter the values");
		for(int i=0;i<a.length;i++)
			a[i] = s.nextInt();
		System.out.println("Elements");
		for(int i:a)
			System.out.print(i+"   ");
	}
}

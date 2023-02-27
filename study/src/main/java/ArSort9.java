import java.util.*;

public class ArSort9 
{
	ArSort9(Scanner s){
		Main.dis(this);
		System.out.println("Enter num of elements");
		sort(s.nextInt(),s);
	}

	private void sort(int size,Scanner s) {
		int a[] = new int[size];
		System.out.println("Enter the values");
		for(int i=0;i<a.length;i++)
			a[i] = s.nextInt();
		for(int i=0;i<a.length-1;i++)
			for(int j=i+1;j<a.length;j++)
				if(a[i]>a[j]){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
		System.out.println("Sorted array");
		for(int i:a)
			System.out.print(i+"  ");
	}
}

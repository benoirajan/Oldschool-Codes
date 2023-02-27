
import java.util.*;
public class OverrideP {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter a no.");
		new B().show(s.nextInt());
	}
}

class A {
	void show(int a) {
		for (int i=1;i <= 10;i++)
			System.out.println(i + "*" + a + "=" + i * a);
	}
}

class B extends A {

	void show(int a) {
		System.out.println("Multiplication Table of " + a);
		super.show(a);
		System.out.println("Thanks");
	}
}

package p12;
import Main;
import java.util.*;

public class ShapeVolume12
{
	public ShapeVolume12(Scanner s){
		Main.dis(this);
		System.out.println("Enter side of cube");
		float n = s.nextFloat();
		System.out.println("Volume");
		new Volume(n);
		System.out.println("Enter sides of cube");
		float a[] = new float[]{s.nextFloat(),s.nextFloat(),s.nextFloat()};
		System.out.println("Volume");
		new Volume(a[0],a[1],a[2]);
		new Volume(a[0],a[1]);
	}
	
	public static void main(String[] a){
		new ShapeVolume12(new Scanner(System.in));
	}
}

package p12;

public class Volume
{
	Volume(float a){
		System.out.println(Math.pow(a,3));
	}
	
	Volume(float a, float b, float h){
		System.out.println(a*b*h);
	}
	
	Volume(double r, double h){
		System.out.println(Math.PI*r*r*h);
		System.out.println("con");
		System.out.println(r*r*h*(1f/3f));
	}
}

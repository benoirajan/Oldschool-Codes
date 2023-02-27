public class Overload10
{
	Overload10(){
		Main.dis(this);
		add(10,9);
		add(4.4f,5);
	}
	
	Overload10(int a, int b){
		System.out.println("\n**Constructer overload**");
		add(a,b);
	}

	private void add(float p0, float p1) {
		System.out.println(p0+p1);
	}

	private void add(int p0, int p1) {
		System.out.println(p0+p1);
	}
}

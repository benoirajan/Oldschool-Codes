public class Runnab {
	public static void main(String[] a){
		new Thread(new Myt("A")).start();
		new Thread(new Myt("B")).start();
		new Thread(new Myt("C")).start();
	}
}
class Myt implements Runnable {

	private String name;

	@Override
	public void run() {
		for (int i = 1; i < 5;i++)
			System.out.println(name + " : " + i);
	}

	Myt(String n) {
		name = n;
	}
}

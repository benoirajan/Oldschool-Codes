public class ThreadSample {
	public static void main(String[] arh) {
		Thread fibo = new Fibo(),
			naturalno=new NaturalNo(),
			prime = new Primes();

		fibo.setPriority(Thread.NORM_PRIORITY);
		naturalno.setPriority(Thread.MIN_PRIORITY);
		prime.setPriority(Thread.MAX_PRIORITY);

		fibo.start();
		naturalno.start();
		prime.start();
	}
}

class Fibo extends Thread {

	@Override
	public void run() {
		getFibo(20);
		super.run();
	}

	public static void getFibo(int n) {
		int f=0,s=1,t;
		String fi = "Fibo ";
		System.out.println(fi + f);
		System.out.println(fi + s);
		for (int i=2;i < n;i++) {
			System.out.println(fi + (t = f + s));
			f = s;s = t;
		}
	}
}

class NaturalNo extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i=1;i <= 20;i++)
			System.out.println("Natural " + i);
	}
}

class Primes extends Thread {

	@Override
	public void run() {
		// TODO: Implement this method
		super.run();
		for (int i=	1;i < 20;i++)
			if (isPrime(i))
				System.out.println("Prime " + i);
	}

	private boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		if (n == 1) 
			return false;
		return true;
	}
}

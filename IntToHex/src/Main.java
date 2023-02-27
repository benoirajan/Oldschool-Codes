import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		Scanner input = new Scanner(System.in);

		System.out.print("RGB with space (int): ");
		int r = 203;
		int g = 249;
		int b = 253;
		String product = toHex(r)+toHex(g)+toHex(b);
		System.out.println(product);
	}

	private static String toHex(int r) {
		String pro = Integer.toHexString(r);
		pro = pro.length()>1?pro:"0"+pro;
		return pro;
	}
}

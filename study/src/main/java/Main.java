
import java.util.*;
import p12.*;
public class Main {

	public static void dis(Object p0) {
		System.out.println("\n**"+p0.getClass().getName()+"**");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Fact1(sc);
		new MultTab2(sc);
		new NumRev3(sc);
		new DigtSum4(sc);
		new StarTri5(sc);
		new ArrayDis6(sc);
		new ArrayLarge7(sc);
		new ArSearch8(sc);
		new ArSort9(sc);
		//method overlo
		new Overload10();
		//constructer
		new Overload10(2,7);
		new ShapeVolume12(sc);
		new SingleIn13();
		new MultInher14(sc);
		new Hierar15();
	}
}

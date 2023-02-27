
import p12.*;
import java.util.*;
class Base{
	protected void display(int n){
		System.out.println(n);
	}
}
class Child extends Base{
	public void show(){
		System.out.println("Playing");
	}
}
//main
public class SingleIn13
{
	SingleIn13(){
		Main.dis(this);
		Child c = new Child();
		//Base method
		c.display(4);
		c.show();
	}
}


import java.util.*;
class
Player extends Child {
	protected void play(int num) {
		System.out.println("Song");
		display(num);
		show();
	}
	
}
public class MultInher14
{
	MultInher14(Scanner s){
		Main.dis(this);
		System.out.println("Enter n");
		Player p = new Player();
		p.play(s.nextInt());
	}
}

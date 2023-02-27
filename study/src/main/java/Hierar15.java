abstract class P{
	public void play(){
		System.out.println(getClass().getName());
	}
}
class Audio extends P {
	@Override
	public void play() {
		super.play();
		System.out.println("is playing");
	}
}
class Video extends P {

	@Override
	public void play() {
		// TODO: Implement this method
		super.play();
		System.out.println("is playing");
	}
	
}
public class Hierar15
{
	Hierar15(){
		Main.dis(this);
		new Audio().play();
		new Video().play();
	}
}

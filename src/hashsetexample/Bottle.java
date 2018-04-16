package hashsetexample;

import java.util.HashSet;

public class Bottle {

	private int volume;
	
	public Bottle(int volume)
	{
		this.volume=volume;
		HashSet s=new HashSet<>();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Bottle [volume=" + volume + "]";
	}
	
	
	
	
	
	
	
}

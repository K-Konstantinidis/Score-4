import java.util.Scanner;

public class Player {
	private String name;
	private String chip1;
	private String chip2;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Player()
	{
		setName(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setChip(String c) {
		this.chip1 = c;
	}
	
	public void setChip2(String c) {
		this.chip2 = c;
	}
	
	public String getChip1() {
		return chip1;
	}
	
	public String getChip2() {
		return chip2;
	}

}
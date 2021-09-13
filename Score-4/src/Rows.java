import java.util.Scanner;

public class Rows {
	private int rows;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Rows()
	{
		rows = 0;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		rows = keyboard.nextInt();
		while(true){ //Rows have to be between 4 and 15
			if(rows < 4 || rows > 15)
			{
				System.out.print("Incorrect input. Please enter the number of rows: ");
				rows = keyboard.nextInt();
			}else {
				this.rows = rows;
				break;
			}	
		}
	}
}

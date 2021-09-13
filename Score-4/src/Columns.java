import java.util.Scanner;

public class Columns {
	private int columns;
	
	Scanner keyboard = new Scanner(System.in);
		
	public Columns()
	{
		columns = 0;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		columns = keyboard.nextInt();
		while(true){ //Columns have to be between 4 and 15
			if(columns < 4 || columns > 15)
			{
				System.out.print("Incorrect input. Please enter the number of columns: ");
				columns = keyboard.nextInt();
			}else {
				this.columns = columns;
				break;
			}	
		}
	}	
}

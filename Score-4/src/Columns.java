/*************************************************************************
	Copyright © 2021 Konstantinidis Konstantinos
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at 
	
		http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software 
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and 
	limitations under the License.
*************************************************************************/
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

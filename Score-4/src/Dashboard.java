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
import java.lang.Integer;

public class Dashboard {
	private int i;
	private int j;
	private int t;
	private int t1;
	private int das;
	private int rows; //Dashboard rows
	private int columns; //Dashboard columns
	private String[][] dashb = new String[15][15]; //Array for the places a chip can be placed
	private String arrayRows[] = new String[15]; //Array to "close" the dashboard left & right
	private Player p1; //Player 1
	private Player p2; //Player 2
	private boolean stop;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Dashboard()
	{
		setDas(0);
	}
	//set the "|" to the left and right of the dashboard
	public void setMyArray()
	{
		for(i = 0; i < rows; i++)
		{
			arrayRows[i] = "|"; //Set dashborad start and end to "|"
		}
	}
	//Set the "-" symbol
	public void setMyDashboard()
	{
		for(i = 0; i < rows; i++)
		{
			for(j = 0; j < columns; j++)
			{//Set the "-" symbol to the places where the user can place their chip
				dashb[i][j] = "-";
			}
		}
	}
	//Print the board
	public void printDashboard()
	{
		System.out.print("\n");
		
		for(i = 0; i < rows; i++)
		{
			System.out.print(arrayRows[i] + " "); //Print the left "|" and then " " after it
			for(j = 0; j < columns; j++)
			{
				System.out.print(dashb[i][j] + " "); //Print the "-" for the chip places and a " " between them
			}
			System.out.println(arrayRows[i]); //Print the right "|"
		}
		//Print the "-" underneath the board
		for(i = 0; i < 2*(columns+2)-1; i++)
		{//Columns (+ 2) beacuse of the 2 "|" and then (*2) because of the " " between them and then -1 to be precise
			System.out.print("-");
		}
		
		System.out.print("\n");
		System.out.print("  "); // Add "  " to make number 1 appear underneath the 1st column
		//Print the numbers of the columns
		j = 1;
		for(i = 0; i < columns; i++)
		{
			
			System.out.print(j+" "); //Add a " " between the numbers
			j++;
		}
		System.out.print("\n");
		System.out.print("\n");
	}
	
	public void GameDashboard(int c, Player p)
	{
		stop = false;
		//Player 1
		if(p.getName().equals(p1.getName()))
		{
			while(!"-".equals(dashb[0][c-1]))//If column is full
			{
				System.out.print("This column is full of chips. Select a new one: ");
				c = keyboard.nextInt();
				while(c > columns || c <= 0) //If the players select a non-existing column
				{
					System.out.print("Nonexistent column select again: ");
					c = keyboard.nextInt();
				}
			}
			for(i = rows - 1; i >= 0; i--) //Start from the bottom of the board
			{
				for(j = 0; j < columns; j++)
				{
					if(c == j + 1)
					{
						if("-".equals(dashb[i][j])) //If the place is empty
						{
							if(p1.getChip1().equals("x")){
								dashb[i][j] = "x"; //Add the {x} chip
								stop = true;
							}
							else {
								dashb[i][j] = "o"; //Add the {o} chip
								stop = true;
							}
						}
						break;
					}
				}
				if(stop == true)
				{
					break; //End turn
				}
			}			
		}
		//Player 2
		else if(p.getName().equals(p2.getName()))
		{
			while(!"-".equals(dashb[0][c-1]))//If column is full
			{
				System.out.print("This column is full of chips. Select a new one: ");
				c = keyboard.nextInt();
				while(c > columns || c <= 0) //If the players select a non-existing column
				{
					System.out.print("Nonexistent column select again: ");
					c = keyboard.nextInt();
				}
			}
			for(i = rows-1; i >= 0; i--)  //Start from the bottom of the board
			{
				for(j = 0; j < columns; j++)
				{
					if(c == j + 1)
					{
						if("-".equals(dashb[i][j]))  //If the place is empty
						{
							if(p2.getChip1().equals("x")){
								dashb[i][j] = "x"; //Add the {x} chip
								stop = true;
							}
							else {
								dashb[i][j] = "o"; //Add the {o} chip
								stop = true;
							}
						}
						break;
					}
				}
				if(stop == true)
				{
					break; //End turn
				}
			}
		}
	}
	
	public boolean checkForWin()
	{
		stop = false;
		//Horizontal
		for(i = rows - 1; i >= 0; i--)
		{
			for(j = 0; j < columns - 3; j++)
			{
				if("x".equals(dashb[i][j]) && "x".equals(dashb[i][j+1]) 
				   && "x".equals(dashb[i][j+2])  && "x".equals(dashb[i][j+3]) )
				{
					if(p1.getChip1().equals("x")) {
						System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
					}else {
						System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
					}
					stop = true;
				}
				else if("o".equals(dashb[i][j]) && "o".equals(dashb[i][j+1])
						&& "o".equals(dashb[i][j+2]) && "o".equals(dashb[i][j+3]))
				{
					if(p1.getChip1().equals("o")) {
						System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
					}else {
						System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
					}
					stop = true;
				}
			}
			if(stop == true)
			{
				break; //End game
			}
		}
		//Vertical
		if(stop == false)
		{
			for(j = 0; j < columns; j++)
			{
				for(i = rows - 1; i > 2; i--)
				{
					if("x".equals(dashb[i][j]) && "x".equals(dashb[i-1][j]) 
					   && "x".equals(dashb[i-2][j]) && "x".equals(dashb[i-3][j]))
					{
						if(p1.getChip1().equals("x")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
					else if("o".equals(dashb[i][j]) && "o".equals(dashb[i-1][j]) 
							&& "o".equals(dashb[i-2][j]) && "o".equals(dashb[i-3][j]))
					{
						if(p1.getChip1().equals("o")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
				}
				if(stop == true)
				{
					break;
				}
			}
		}
		//Diagonal
		if(stop == false)
		{
			for(i = rows - 1; i > 2; i--)
			{
				for(j = 0; j < columns - 3; j++)//Diagonal left to right
				{
					if("x".equals(dashb[i][j]) && "x".equals(dashb[i-1][j+1]) 
					  && "x".equals(dashb[i-2][j+2]) && "x".equals(dashb[i-3][j+3]))
					{
						if(p1.getChip1().equals("x")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
					else if("o".equals(dashb[i][j]) && "o".equals(dashb[i-1][j+1]) 
						   && "o".equals(dashb[i-2][j+2]) && "o".equals(dashb[i-3][j+3]))
					{
						if(p1.getChip1().equals("o")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
				}
				if(stop == true)
				{
					break;
				}
				
				for(j = columns - 1; j > 2; j--)//Diagonal right to left
				{
					if("x".equals(dashb[i][j]) && "x".equals(dashb[i-1][j-1]) 
					  && "x".equals(dashb[i-2][j-2]) && "x".equals(dashb[i-3][j-3]))
					{
						if(p1.getChip1().equals("x")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
					else if("o".equals(dashb[i][j]) && "o".equals(dashb[i-1][j-1]) 
						   && "o".equals(dashb[i-2][j-2]) && "o".equals(dashb[i-3][j-3]))
					{
						if(p1.getChip1().equals("o")) {
							System.out.println("GAME OVER. THE WINNER IS: " + p1.getName() + "!");
						}else {
							System.out.println("GAME OVER. THE WINNER IS: " + p2.getName() + "!");
						}
						stop = true;
					}
				}
				if(stop == true)
				{
					break;
				}
			}
		}
		return stop;
	}
	
	public boolean checkForDraw()
	{
		t = 0;
		stop = false;
		for(i = rows - 1 ; i >= 0; i--)
		{
			for(j = 0; j < columns; j++)
			{
				if("x".equals(dashb[i][j]) || "o".equals(dashb[i][j]))
				{
					t += 1;
				}
			}
		}
		t1 = rows*columns;
		if(Integer.compare(t, t1) == 0)
		{
			System.out.println("GAME OVER. WE HAVE A DRAW!");
			stop = true;
		}
		return stop;
	}
	
	public void setMyRow(int c)
	{
		rows = c; //Set dashboard rows
	}
	
	public void setMyColumn(int c)
	{
		columns = c; //Set dashboard columns
	}
	public void setMyPlayer1(Player c)
	{
		p1 = c; //Set dashboard player 1
	}
	
	public void setMyPlayer2(Player c)
	{
		p2 = c; //Set dashboard player 2
	}

	public int getDas() {
		return das;
	}

	public void setDas(int das) {
		this.das = das;
	}
	
}

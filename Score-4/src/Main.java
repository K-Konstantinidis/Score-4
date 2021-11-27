/*************************************************************************
Copyright © [2021] [Konstantinidis Konstantinos]
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

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//Create the 2 players
		Player p1 = new Player();
		Player p2 = new Player();
		Chip ch = new Chip();
		Rows rows = new Rows();
		Columns col = new Columns();
		Dashboard das = new Dashboard();
		Rounds round = new Rounds();
		
		System.out.println("-----This Is Score4-----");
		//Player1
		System.out.print("Please enter the name of the 1st player: ");
		p1.setName(keyboard.nextLine());
		//Player2
		System.out.print("Please enter the name of the 2nd player: ");
		p2.setName(keyboard.nextLine());
		while(true) {
			if(p2.getName().equals(p1.getName())) {//If they have the same name
				System.out.println("You can't have the same name.");
				System.out.print("Please enter a new name for the 2nd player: ");
				p2.setName(keyboard.nextLine());
			}else {
				break;
			}
		}
		//Chips
		ch.setMyPlayer1(p1);//Set a chip for player 1
		ch.setMyPlayer2(p2);//Set a chip for player 2
		ch.selectChip();//Select who gets which chip ({x} or {o})
		//Rows
		System.out.print("Please enter the number of rows(Between 4 and 15): ");
		rows.setRows(0);
		//Columns
		System.out.print("Please enter the number of columns(Between 4 and 15): ");
		col.setColumns(0);
		//Dashboard
		das.setMyRow(rows.getRows()); //Set dashboard rows
		das.setMyColumn(col.getColumns()); //Set dashboard columns
		das.setMyPlayer1(p1); //Set dashboard player 1
		das.setMyPlayer2(p2); //Set dashboard player 2
		das.setMyArray(); //Set dashborad start and end to "|"
		das.setMyDashboard(); //Set the "-" symbol to the places where the user can place their chip
		das.printDashboard(); //Print the board
		//Game
		round.setMyPlayer1(p1); //Add player 1 to the round class
		round.setMyPlayer2(p2); //Add player 2 to the round class
		round.setMyColumn(col); //Add the columns to the round class
		round.setDas(das); //Add the dashboard to the round class
		round.Gameplay(); //Start the game
		
		keyboard.close();
	}	
}

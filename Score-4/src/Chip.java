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

public class Chip {
	private String chip;
	private Player p1;
	private Player p2;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Chip()
	{
		setChip(null);
	}
	
	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}
	
	public void selectChip() {	
		//Player 1 select your chip
		System.out.print(p1.getName() + ", please select your chip. Either x or o: ");
		do{
			chip = keyboard.nextLine();
			if("x".equals(chip)) //If selected chip is {x} 
			{//Then p2 gets {o}
				p1.setChip("x");
				System.out.println(p2.getName() + ", your chip is: o");
				p2.setChip("o");
			}
			else if("o".equals(chip))//If selected chip is {o}
			{//Then p2 gets {x}
				p1.setChip("o");
				System.out.println(p2.getName() + ", your chip is: x");
				p2.setChip("x");
			}
			else
			{
				System.out.print("Incorrect input. Please select a valid chip: ");
			}
		}while(!"x".equals(chip) && !"o".equals(chip));
	}

	public void setMyPlayer1(Player c)
	{
		p1 = c; //Set a chip for player 1
	}
	
	public void setMyPlayer2(Player c)
	{
		p2 = c; //Set a chip for player 2
	}
}

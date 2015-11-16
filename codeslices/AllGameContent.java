package codeslices;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.directory.DirContext;

public abstract class AllGameContent
{
	//End game conditions
	//==============================
	//Health gets to 0, game is over
	//GreenHerbs gets to 3, game is over
	static int health = 100;
	static int greenHerbs = 0;
	static int roomTracker = 0;
	
	String name, description, areaSize;
	
	//Default constructor
	public AllGameContent()
	{
		
	}
	
	//Constructor which will give the name and description of each area
	public AllGameContent(String name, String description, String areaSize)
	{
		
		this.name = name;
		this.description = description;
		this.areaSize = areaSize;
		
		System.out.printf("\nYou are %s\n%s\nIt looks like a %s\n\n", name, description, areaSize);
		
	}
	
	
//Main method starts here	
//=======================================================================================================================================
	
	public static void main(String args[]) throws IOException
	{
		
		boolean isAlive = true;
		boolean foundHerbs = false;
		
		InGameDecisions inGameDecisions = new InGameDecisions();
		
		Dialog dialog = new Dialog();
			
		//Will allow user input
		Scanner input = new Scanner(System.in);
		
		//Will output game data to a file
		PrintWriter outGameData = new PrintWriter("gameData.txt");
		
		//Interface variable to call methods from Area classes
		Search search;
		
		//Interface variable accesses the class with it's method
		Search[] areaListArray = {search = new Area1(), search = new Area2(), search = new Area3(), search = new Area4(), 
				  search = new Area5(), search = new Area6(), search = new Area7(), search = new Area8(), search = new Area9()};
		
		//......................................................................................................................
		//Game Starts here
		
		//Introduction story of the game
		dialog.gameIntro();
		
		//Can make a character name
		//Outputs characters name to text file
		inGameDecisions.characterNaming();
		
		inGameDecisions.age();
				
		//Must enter Area1 to start game
		Area1 area1 = new Area1("in a spooky woods", "It's dark and you can hear strange noises around you", "small area");
			
		//Will be asked if you want to search room and store the answer in variable answer
		String answer = inGameDecisions.searchRoomChoice();
		
		//If 'yes' is answer
		if(answer.equals(InGameDecisions.YES))
		{
			//Will call the searchArea method for the room you are in	
			areaListArray[roomTracker - 1].searchArea();
			
		}
		
		//Game will keep running until 1 of these conditions are not met
		while(isAlive == true &&  foundHerbs == false)
		{
			
			//Shows your game status
			dialog.showHealthHerbs();
			
			//Ask what direction they want to go
			//roomTracker tells game where you are and allows you to make correct 
			//decision on where you can go next
			inGameDecisions.directionChoice(roomTracker);
					
			//Ask do they want to search the room	
			String answer2 = inGameDecisions.searchRoomChoice();
			
			if(answer2.equals(InGameDecisions.YES))
			{
				//Will call the searchArea method for the room you are in
				areaListArray[roomTracker - 1].searchArea();
			}
			
			//Take health away for each turn
			dialog.reduceHealth();
			
			//Sets the variable which will end game
			if(AllGameContent.health <= 0)
			{
							
				isAlive = false;
				
			}
			
			if(AllGameContent.greenHerbs == 3)
			{
				
				foundHerbs = true;
				
			}
			
			
		}//End while
			
		//Will print the message at the end of the game
		if(foundHerbs == true)
		{		
			dialog.winGame();		
		}
		else
		{		
			dialog.endGame();		
		}
		
	}//End main
	
}//End AllGameContent class

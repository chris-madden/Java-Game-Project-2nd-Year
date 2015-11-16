package codeslices;

import java.io.*;
import java.util.Scanner;

public class InGameDecisions
{
	//Use these for direction choice
	final String NORTH = "north";
	final String SOUTH = "south";
	final String WEST = "west";
	final String EAST = "east";
	
	//Use this for searchRoom choice
	static final String YES = "yes";
	static final String NO = "no";
	
	String direction;
	
	Scanner input = new Scanner(System.in);
	
	//Super class variable used to call sub class constructors
	AllGameContent areaSelect;
	
	//Create a FileWriter variable
	FileWriter fw; 
	
	//Create a PrintWriter variable
	PrintWriter writer;
	
	//Name your character
	public void characterNaming()  throws IOException
	{
		String character = "";
		
		//Create new file call gameData.txt
		fw = new FileWriter("gameData.txt");
		
		//Writer variable will write to file gameData.txt
		writer = new PrintWriter(fw);
	
		System.out.println("\nWhat do you want your characters name to be?");
		
		System.out.println();
		
		character = input.nextLine();
		
		System.out.println();
			
		//Writing to file gameData.txt
		writer.println("Character name was: " + character);
		
		//Close the file
		writer.close();	
		fw.close();
		
	}
		
	
	public void age() throws IOException
	{
		//Open gameData.txt and append it	
		fw = new FileWriter("gameData.txt", true);
		
		//Allows you to write to the file gameData.txt
		writer = new PrintWriter(fw);
		
		int age = 0;
		
		//Looks for a mismatch exception
		//Can only take an integer for the age of character
		try
		{
				
			System.out.println("What age do you want your charcter to be?");
			System.out.println("(Choose between 15 and 100)");
			
			System.out.println();
			
			age = input.nextInt();
			
			System.out.println();
			
			if(age >= 15 && age <= 100)
			{
				//Writing to file gameData.txt
				writer.println("\nCharacters age was: " + age);
				
				//Clears the buffer
				input.nextLine();
				
				
				System.out.print("\t\t\tYour Journey Begins\n");
				System.out.println("***************************************************************************");
				
				//Close the file
				writer.close();
				fw.close();
			}
			else
			{
				
				System.out.println("You need to choose between 15 and 100");
				age();
			}
		}
		catch(Exception e)
		{
			//Prints error message to screen
			System.err.println("This is an error, can have no decimals in your age");
			
			//Clears the buffer
			input.nextLine();
			
			//Recalls method to enter your age
			age();
		}
			
			
	}//End method age
	
	//Choice your destination
	public void directionChoice(int areaNumber)
	{
		
		System.out.println("\nWhich direction do you want to go in?");
		
		System.out.println("(North - South - West - East)\n");
		
		direction = input.nextLine();
		
		direction = direction.toLowerCase();	
		
		//Must use the equals method as comparing the exact contents of strings
		if(direction.equals(NORTH) || direction.equals(SOUTH)|| direction.equals(WEST) || direction.equals(EAST))
		{
			//From here you move from one area to another
			//roomTracker variable is passed in to this switch
			//and decides on which rooms you can move into
			switch(areaNumber)
			{
			
			case 1: if(direction.equals(NORTH))
					{
						areaSelect = new  Area4("in an ice Cave", "Temperatures are freezing, you don't want to stay here too long", "very large area");
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new Area2("at a lake", "It looks like there's something large moving in the water", "big area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(WEST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
										
			case 2: if(direction.equals(NORTH))
					{
						areaSelect = new  Area5("in Death Valley", "It must be 1000 feet deep", "big area");
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new Area3("in a desert", "It's extremely hot here, you want to find shade", "small area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new Area1("in a spooky woods", "It's dark and you can hear strange noises around you", "small area");
						break;
					}
			
			case 3: if(direction.equals(NORTH))
					{
						areaSelect = new Area6("at Lone Mans River", "Life is flourishing here", "small area");
						break;
					}
					else if(direction.equals(EAST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(SOUTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new Area2("at a lake", "It looks like there's something large moving in the water", "big area");
						break;
					}
			
			case 4: if(direction.equals(NORTH))
					{
						areaSelect = new Area7("at the Cloudy Mountains", "These mountains are so big you can't see the top of them", "big area");
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new  Area5("in Death Valley", "It must be 1000 feet deep", "big area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new Area1("in a spooky woods", "It's dark and you can hear strange noises around you", "small area");
						break;
					}
					else if(direction.equals(WEST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
			
			case 5: if(direction.equals(NORTH))
					{
						areaSelect = new Area8("at a swamp", "There are a lot of strange cretaures here", "small area");
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new Area6("at Lone Mans River", "Life is flourishing here", "small area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new Area2("at a lake", "It looks like there's something large moving in the water", "big area");
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new  Area4("in an ice Cave", "Temperatures are freezing, you don't want to stay here too long", "very large area");
						break;
					}
			
			case 6: if(direction.equals(NORTH))
					{
						areaSelect = new Area9("at a Toxic Zone", "The air here is poisonous, you need to leave quickly", "vast area");
						break;
					}
					else if(direction.equals(EAST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new Area3("in a desert", "It's extremely hot here, you want to find shade", "small area");
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new  Area5("in Death Valley", "It must be 1000 feet deep", "big area");
						break;
					}
			
			case 7: if(direction.equals(NORTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new Area8("at a swamp", "There are a lot of strange cretaures here", "small area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new  Area4("in an ice Cave", "Temperatures are freezing, you don't want to stay here too long", "very large area");
						break;
					}
					else if(direction.equals(WEST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
			
			case 8: if(direction.equals(NORTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(EAST))
					{
						areaSelect = new Area9("at a Toxic Zone", "The air here is poisonous, you need to leave quickly", "vast area");
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new  Area5("in Death Valley", "It must be 1000 feet deep", "big area");
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new Area7("at the Cloudy Mountains", "These mountains are so big you can't see the top of them", "big area");
						break;
					}
			
			case 9: if(direction.equals(NORTH))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(EAST))
					{
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
						System.out.println("\t\tYou can not go that direction");
						System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						directionChoice(AllGameContent.roomTracker);
						break;
					}
					else if(direction.equals(SOUTH))
					{
						areaSelect = new Area6("at Lone Mans River", "Life is flourishing here", "small area");
						break;
					}
					else if(direction.equals(WEST))
					{
						areaSelect = new Area8("at a swamp", "There are a lot of strange cretaures here", "small area");
						break;
					}
										
					default: System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
					System.out.println("\t\t\tInvalid Command");
					System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
					directionChoice(AllGameContent.roomTracker);
					break;										 
				
			}//End switch
			
		}//End if
		else
		{
			//Prints if a word other than the direction name is entered
			System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
			System.out.println("\t\t\tNot a valid direction");
			System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			directionChoice(AllGameContent.roomTracker);
			
		}
				
	}//End directionChoice()	
	
//===========================================================================================================================================
	//Asks if you want to search the room
	public String searchRoomChoice()
	{
		
		String searchChoice, validAnswer = "";
		
		System.out.println("\nDo you want to search the area?");
		
		System.out.println("(Yes or No)\n");
		
		searchChoice = input.nextLine();
		
		System.out.println();
		
		searchChoice = searchChoice.toLowerCase();
		
		//If statement to make sure the correct command is given
		if(searchChoice.equals(YES) || searchChoice.equals(NO))
		{
			
			validAnswer = searchChoice;
				
		}
		else
		{
			//Prints if a word other than the correct command is entered
			System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
			System.out.println("\t\t\tNot a valid command");
			System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			searchRoomChoice();
			
		}
		
		return validAnswer;
							
	}//End searchRoomChoice()	
	
}//End InGameDecisions class

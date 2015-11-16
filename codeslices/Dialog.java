package codeslices;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Dialog
{
	
	//Create a FileWriter variable
	FileWriter fw; 
	
	//Create a PrintWriter variable
	PrintWriter writer;

	//Prints introduction story
	public void gameIntro()
	{
		
		System.out.println("\t\t\tIntroduction Story");
		
		System.out.println("***************************************************************************");
		
		System.out.println("You find yourself in a strange world, lost and hurt.\n"
				+ "You've been poisoned and need 3 green herbs to make a cure."
				+ "\nFind your way through the map and get the green herbs before it's too late!"
				+ "\nYou lose health with each turn but help may be found along the way."
				+ "\nYou can search areas but the bigger the area the more health you'll lose."
				+"\n***************************************************************************");
		
	}
	
	//Shows game status
	public void showHealthHerbs()
	{
		
		System.out.println("\n\n***************************************************************************");
		System.out.printf("\t\t\tHealth: %d\n\t\t\tGreen Herbs: %d\n", AllGameContent.health, AllGameContent.greenHerbs);
		System.out.println("***************************************************************************");
		
	}
	
	//Will reduce health each turn
	//Different feedback given to player
	//depending on level of health
	public void reduceHealth()
	{
		
		AllGameContent.health -= 15;
				
		if(AllGameContent.health >= 80 && AllGameContent.health < 100)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\t\t\tYou feel a bit weak");	
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
		}
		else if(AllGameContent.health >= 50 && AllGameContent.health < 80)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\t\t\tYou're really not feeling good!");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		else if(AllGameContent.health >= 30 && AllGameContent.health < 50)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\t\tYou're feeling terrible, you need help soon!");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		else if(AllGameContent.health >= 10 && AllGameContent.health < 30)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\t\t\tYou feel that this is the end!");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		else if(AllGameContent.health >= 10 && AllGameContent.health < 30)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\t\t\tYou prepare to take one of your last breaths");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		else if(AllGameContent.health >= 1 && AllGameContent.health < 10)
		{
			
			System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\tIn what feels like your very last moment, you pray for a miracle");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		
	}//End reduceHealth
	
	public void endGame() throws IOException
	{
		//Open gameData.txt and append it	
		fw = new FileWriter("gameData.txt", true);
		
		//Allows you to write to the file gameData.txt
		writer = new PrintWriter(fw);
		
		//Prints death message
		System.out.println("\n***************************************************************************\n");
		System.out.println("\t\t\tYou died, try again");
		System.out.println("\n***************************************************************************");
		
		//Prints to gameData.txt
		writer.println("\nUnfortunately you died in this game");
		
		//Close the file
		writer.close();	
		fw.close();
		
	}//End endGame
	
	public void winGame() throws IOException
	{
		//Open gameData.txt and append it	
		fw = new FileWriter("gameData.txt", true);
		
		//Allows you to write to the file gameData.txt
		writer = new PrintWriter(fw);
	
		//Prints game won message
		System.out.println("\n***************************************************************************\n");
		System.out.println("\t\tYou found the herbs and cured yourself!\n\t\tCongratulations, You Win!!");
		System.out.println("\n***************************************************************************");
			
		//Prints to gameData.txt
		writer.println("\nYou won this game, Congratulaations!!");
		
		//Close the file
		writer.close();	
		fw.close();
				
	}//End winGame
	
}//End class Dialog

package codeslices;

public class Area1 extends GameWorld implements Search
{
	
	public Area1()
	{
		
	}
	
	public Area1(String name, String description, String areaSize)
	{
		
		super(name, description, areaSize);
		
		//Initializes roomTracker variable
		roomTracker = 1;
		
	}
	
	//Small Area has greater chance of finding something
	//Part of the interface
	public void searchArea()
	{
		
		//Lose extra health for searching areas
		AllGameContent.health -= 5;
		
		//Small area
		int item = (int)(Math.random() * 10)+1;
		
		if(item >= 1 && item <= 5)
		{
			
			System.out.println("==========================================================================\n");
			System.out.println("\t\t\tYou found a potion!!");
			System.out.println("\n==========================================================================");
			
			AllGameContent.health += 20;
			
		}
		else if(item >= 6 && item <= 10)
		{
			
			System.out.println("==========================================================================\n");
			System.out.println("\t\t\tYou found a herb! Good going!!");
			System.out.println("\n==========================================================================");
			
			AllGameContent.greenHerbs += 1;
			
		}
		else
		{
			
			System.out.println("==========================================================================\n");
			System.out.println("\t\t\tYou didn't find anything");
			System.out.println("\n==========================================================================");
			
		}
		
	}//End searchArea
	
}//End area1 class

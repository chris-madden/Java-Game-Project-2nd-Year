package codeslices;

public class Area2 extends GameWorld implements Search
{
	
	public Area2()
	{
		
	}
	
	public Area2(String name, String description, String areaSize)
	{
		
		super(name, description, areaSize);
		
		//Initializes roomTracker variable
		roomTracker = 2;
		
	}
	
	//Big area has slightly less chance of finding something
	//Part of the interface
	public void searchArea()
	{
		
		//Lose extra health for searching areas
		AllGameContent.health -= 10;
		
		//Big area
		int item = (int)(Math.random() * 12)+1;
		
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
	
}//End area2 class

package codeslices;

public class Area4 extends GameWorld implements Search
{
	
	public Area4()
	{
		
	}
	
	public Area4(String name, String description, String areaSize)
	{
		
		super(name, description, areaSize);
		
		//Initializes roomTracker variable
		roomTracker = 4;
		
	}
	
	//Very large area has a small chance of finding anything
	public void searchArea()
	{
		
		//Lose extra health for searching areas
		AllGameContent.health -= 15;
	
		//Very Large Area
		int item = (int)(Math.random() * 14)+1;
		
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

}//End class

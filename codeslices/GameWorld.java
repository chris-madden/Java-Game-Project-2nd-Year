package codeslices;

//Abstract class which contains all the areas of the game

public abstract class GameWorld extends AllGameContent
{
		
	public GameWorld()
	{
		
	}
	
	public GameWorld(String name, String description, String areaSize)
	{
				
		super(name, description, areaSize);
					
	}

}

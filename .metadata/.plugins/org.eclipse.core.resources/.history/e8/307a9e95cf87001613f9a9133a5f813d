import org.newdawn.slick.SlickException;

public class Elixir extends Item {
	private final static int xPos=700, yPos=700;
	private final static  String path="assets/items/elixir.png";
	boolean pickup=false;
	
	public Elixir()
	throws SlickException
	{
		super(xPos,yPos,path);
	}

	@Override
	public void PickUp(Player player) {
		if (distanceOK(xPos,yPos,player.getX(),player.getY())){
			setPickup(true);
		}
		
	}
}

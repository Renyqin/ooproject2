import org.newdawn.slick.SlickException;

public class Tome extends Item {
	private final static int xPos=4791, yPos=1253;
	private final static  String path="assets/items/tome.png";
	private final static int rateImprove=300;
	boolean pickup=false;
	
	public Tome()
	throws SlickException
	{
		super(xPos,yPos,path);
	}

	@Override
	public void PickUp(Player player) {
		
		if (distanceOK(xPos,yPos,player.getX(),player.getY())){
			setPickup(true);
			setGetTome(true);
			player.setRate(player.getRate()-rateImprove);
		}
		
	}
}

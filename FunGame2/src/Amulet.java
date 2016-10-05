
import org.newdawn.slick.SlickException;

public class Amulet extends Item{
	private final static int xPos=965, yPos=3563;
	private final static  String path="assets/items/amulet.png";
	private final static int HpImprove=80;
	
	public Amulet()
	throws SlickException
	{
		super(xPos,yPos,path);

	}
	
	@Override
	public void PickUp(Player player){
		
		if (distanceOK(xPos,yPos,player.getX(),player.getY())){
			setPickup(true);
			player.setMaxHp(player.getMaxHp()+HpImprove);
			player.setHp(player.getMaxHp());
			setGetAmulet(true);
		}
	}
	
}

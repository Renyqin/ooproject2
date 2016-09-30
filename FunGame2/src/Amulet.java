
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Amulet extends Item{
	private final static int xPos=300, yPos=300;
	private final static int HpImprove=80;
	private Image Amulet;
	public Amulet()
	throws SlickException
	{
		super(xPos,yPos);
		Amulet=new Image("assets/items/amulet.png");
	}
	
	public boolean improve(Player player){
		boolean pickup=false;
		if (player.getxPos()==xPos&&player.getyPos()==yPos){
			player.setMaxHp(player.getMaxHp()+HpImprove);
			pickup=true;
		}
		
		
		return pickup;
	}
	
	public void renderAmulet(Player player, Graphics g){
		if (!improve(player)){
			Amulet.drawCentered(xPos, yPos);
		}
	}
}

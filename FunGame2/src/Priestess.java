import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Priestess extends Villager{
	private static final int xPos=738, yPos=549;
	private static final int MaxHp=1;
	private static final String name="Elvira";
	private static final String ImagePath="assets/units/shaman.png";
	private static final String convst1="Return to me if you ever need healing.";
	private static final String convst2="You're looking much healthier now.";
	
	
	Priestess()
	throws SlickException
	{
		super(MaxHp, xPos, yPos, ImagePath,name);
	}

	@Override
	public void interact(Player player, World world, Graphics g) {
		if (talk(player)){
			if (player.getHp()==player.getMaxHp()){
				textbox(xPos, yPos, convst1, g);
			}else{
				player.setHp(player.getMaxHp());
				textbox(xPos, yPos, convst2, g);
			}
		}
		
	}
}

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Farmer extends Villager{
	private static final int xPos=756, yPos=870;
	private static final int MaxHp=1;
	private static final String name="Garth";
	private static final String ImagePath="assets/units/peasant.png";
	private static final String convst1="Find the Amulet of Vitality, across the river to the west.";
	private static final String convst2="Find the Sword of Strength - cross the"
										 +"\n"+" bridge to the east, then head south.";
	private static final String convst3="Find the Tome of Agility, in the Land of Shadows.";
	private static final String convst4="You have found all the treasure I know of.";
	boolean amulet=false;
	boolean sword=false;
	boolean tome=false;
	
	
	Farmer()
	throws SlickException
	{
		super(MaxHp, xPos, yPos, ImagePath,name);
	}


	@Override
	public void interact(Player player, World world, Graphics g) {
		if (talk(player)){
			for (Item item:player.getInventory()){
				if (item.isGetAmulet()){
					amulet=true;
			
				}else if (item.isGetSword()){
					sword=true;
					
				
				}else if (item.isGetTome()){
					tome=true;
				}
			}
			if (!amulet){
				textbox(xPos, yPos, convst1, g);
			}else if (!sword){
				textbox(xPos, yPos, convst2, g);
			}else if (!tome){
				textbox(xPos, yPos, convst3, g);
			}else{
				textbox(xPos, yPos, convst4, g);
			}
			
		}
	}
	
	
}

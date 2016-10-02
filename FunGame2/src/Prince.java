import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Prince extends Villager {
	private static final int xPos=467, yPos=679;
	private static final int Hp=1, MaxHp=1;
	private static final String name="Aldric";
	private static final String ImagePath="assets/units/prince.png";
	private static final String convst1="The elixir! My father is cured! Thank you!";
	private static final String convst2="Please seek out the Elixir of Life to cure the king.";
	private boolean find=false;
	
	Prince()
	throws SlickException
	{
		super(Hp, MaxHp, xPos, yPos, ImagePath,name);
	}
	
	public void interact(Player player, World world, Graphics g){
		for (Item item:player.getInventory()){
			if(item.isGetElixir()){
				find=true;
				player.getInventory().remove(item);
				break;
				
			}
		}
		if (find){
			textbox(xPos, yPos, convst1, g);
			
		}else{
			textbox(xPos, yPos, convst2, g);
		}
			
	}
		
}


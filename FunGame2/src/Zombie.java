import org.newdawn.slick.SlickException;

public class Zombie extends Monster {
	private static final int MaxHp=60, MaxDamage=10,rate=800;
	private static final String name="Zombie", type="aggressive";
	private static final String ImagePath="assets/units/zombie.png";

	public Zombie(int xPos, int yPos) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos, ImagePath, type);
		
	}

}

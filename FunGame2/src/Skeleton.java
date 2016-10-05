import org.newdawn.slick.SlickException;

public class Skeleton extends Monster{
	private static final int MaxHp=100, MaxDamage=16,rate=500;
	private static final String name="Skeleton", type="aggressive";
	private static final String ImagePath="assets/units/skeleton.png";

	public Skeleton(int xPos, int yPos) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos, ImagePath, type);
		
	}

}

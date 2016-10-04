import org.newdawn.slick.SlickException;

public class GiantBat extends Monster {
	private static final int MaxHp=40, MaxDamage=0,rate=0;
	private static final String name="Bat", type="passive";
	private static final String ImagePath="assets/units/dreadbat.png";

	public GiantBat(int xPos, int yPos) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos, ImagePath, type);
		
	}

}
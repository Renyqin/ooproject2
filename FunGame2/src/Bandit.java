import org.newdawn.slick.SlickException;

public class Bandit extends Monster{
	private static final int MaxHp=40, MaxDamage=8,rate=200;
	private static final String name="Bandit", type="aggressive";
	private static final String ImagePath="assets/units/bandit.png";

	public Bandit(int xPos, int yPos) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos, ImagePath, type);
		
	}
}

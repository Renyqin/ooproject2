import org.newdawn.slick.SlickException;

public class Draelic extends Monster{
	private static final int MaxHp=140, MaxDamage=30,rate=400;
	private static final String name="Draelic", type="aggressive";
	private static final String ImagePath="assets/units/necromancer.png";

	public Draelic(int xPos, int yPos) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos, ImagePath, type);
		
	}

}

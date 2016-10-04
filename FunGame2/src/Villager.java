import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Villager extends Unit {
	private Image VillagerImage;
	private int timer=4000;
	private int dialogueTime=4000;
	private int distance=50;

	
	public Villager(int MaxHp,int xPos, int yPos, String ImagePath,String name)
	throws SlickException
	{
		super(MaxHp,xPos, yPos, name);
		VillagerImage= new Image(ImagePath);
	}
	
	
	public void render(Graphics g){
		VillagerImage.drawCentered((int)getxPos(), (int)getyPos());
		HealthBar(g, (int)getxPos(), (int)getyPos(), getName());
		
	}
	public int tileHeight(){
		return VillagerImage.getHeight();
	}
	
	public void DialogueTime(int delta){
		timer+=delta;
		
	}
	
	public boolean talk(Player player){
		if (distanceOK(player.getX(),player.getY(),
    			getxPos(),getyPos())&&player.getTalk()){
			timer=0;
			return true;
		}
		if (timer<dialogueTime){
			return true;
		}else{
			return false;
		}
	}
	
	public void textbox(int xPos, int yPos, String text, Graphics g){
        Color TEXT = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        
        int bar_x = xPos-g.getFont().getWidth(text)/2;  // TODO: magic number
        int bar_y = yPos-72/2-40;    // TODO: MAGIC NUMBER
        int bar_width = g.getFont().getWidth(text)+10;
        int bar_height = g.getFont().getHeight(text);
        
        int text_x=bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        int text_y=bar_y;
        
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(TEXT);
        g.drawString(text, text_x, text_y);
        
		
	}
	

	

	public abstract void interact(Player player, World world, Graphics g);
	
	
	
}

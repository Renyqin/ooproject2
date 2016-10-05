
/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Sample Solution
 * Author: Matt Giuca <mgiuca>
 */

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** The character which the user plays as.
 */
public class Player extends Unit
{
    private Image img = null;
    private Image img_flipped = null;
    
    // In pixels
    private double x, y;
    private double width, height;
    private boolean face_left = false;

    // Pixels per millisecond
    private static final double SPEED = 0.25;
    private static int MaxHp=100, MaxDamage=26, Rate=600;
    private boolean talk;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private static final int feeler=3;
    
    private int reviveX=738, reviveY=549;
    
    
    /** The x coordinate of the player (pixels). */
    public double getX()
    {
        return x;
    }

    /** The y coordinate of the player (pixels). */
    public double getY()
    {
        return y;
    }

    /** Creates a new Player.
     * @param image_path Path of player's image file.
     * @param x The Player's starting x location in pixels.
     * @param y The Player's starting y location in pixels.
     */
    public Player(String image_path, double x, double y)
        throws SlickException
    {
    	super(MaxHp,MaxDamage,Rate);
        img = new Image(image_path);
        img_flipped = img.getFlippedCopy(true, false);
        this.x = x;
        this.y = y;
        this.width = img.getWidth();
        this.height = img.getHeight();
    }
    
    
    
    

    /** Move the player in a given direction.
     * Prevents the player from moving outside the map space, and also updates
     * the direction the player is facing.
     * @param world The world the player is on (to check blocking).
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void move(World world, double dir_x, double dir_y, double delta, boolean talk)
    {
        // Update player facing based on X direction
        if (dir_x > 0)
            this.face_left = false;
        else if (dir_x < 0)
            this.face_left = true;

        
        this.talk=talk;
        
        // Move the player by dir_x, dir_y, as a multiple of delta * speed
        double new_x = this.x + dir_x * delta * SPEED;
        double new_y = this.y + dir_y * delta * SPEED;
        
       

        // Move in x first
        double x_sign = Math.signum(dir_x);
 
        if(!world.terrainBlocks(new_x + x_sign * width / feeler, this.y + height / feeler) 
                && !world.terrainBlocks(new_x + x_sign * width / feeler, this.y - height / feeler)) {
            this.x = new_x;
        }
        
        // Then move in y
        double y_sign = Math.signum(dir_y);
        if(!world.terrainBlocks(this.x + width / feeler, new_y + y_sign * height / feeler) 
                && !world.terrainBlocks(this.x - width / feeler, new_y + y_sign * height / feeler)){
            this.y = new_y;
        }
        
        if (getHp()<0){
        	this.x = reviveX;
        	this.y = reviveY;
        	setHp(getMaxHp());
        }
        
        
   
    }

    public void setMaxHp(int maxHp) {
		MaxHp = maxHp;
	}

	public void setMaxDamage(int maxDamage) {
		MaxDamage = maxDamage;
	}

	public  void setRate(int rate) {
		Rate = rate;
	}
	
	

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public int getMaxHp() {
		return MaxHp;
	}

	public int getMaxDamage() {
		return MaxDamage;
	}

	public int getRate() {
		return Rate;
	}
	
	public void Inventory(Item item){
		inventory.add(item);
	}
	
	public boolean getTalk(){
		return talk;
	}

	/** Draw the player to the screen at the correct place.
     * @param g The current Graphics context.
     * @param cam_x Camera x position in pixels.
     * @param cam_y Camera y position in pixels.
     */
    public void render()
    {
        Image which_img;

        
        which_img = this.face_left ? this.img_flipped : this.img;
        which_img.drawCentered((int) x, (int) y);
    }
    
    public void combat(Monster monster, boolean attack, int delta, Player player, World world){
    	Random rDamage=new Random();
		int randomDamage=(rDamage.nextInt(MaxDamage+1));
    	
  
    	
    	if (distanceOK(monster.getxPos(),monster.getyPos(),x,y)&&attack&&cooldown(delta)){
    		
    		monster.setHp(monster.getHp()-randomDamage);
    		
    		if (monster.getType()=="passive"){
    			monster.setDangerDetector(0);
    			
    		}
    	
    	}
    	if (attack&&getCooldown()<0){
    		setCooldown(Rate);
    		
    	}
    }

}


/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Chenqin Zhang> <chenqinz>
 */

import org.newdawn.slick.SlickException;

/** Represents the camera that controls our viewpoint.
 */
public class Camera
{

    /** The unit this camera is following */
    private Player unitFollow;
    
    /** The width and height of the screen */
    /** Screen width, in pixels. */
    public final int screenwidth;
    /** Screen height, in pixels. */
    public final int screenheight;

    
    /** The camera's position in the world, in x and y coordinates. */
    private int xPos;
    private int yPos;

    
    public int getxPos() {	
    	xPos=unitFollow.getxPos();
    	return xPos;
    	
    }

    public int getyPos() {
    	yPos=unitFollow.getyPos();
    	return yPos;
    }

    
    /** Create a new Camera object. */
    public Camera(Player player, int screenwidth, int screenheight)
    {   
    	this.screenwidth=screenwidth;
    	this.screenheight=screenheight;
    	this.unitFollow=player;
    	
    }

    /** Update the game camera to recentre it's viewpoint around the player 
     */
    public void update()
    throws SlickException
    {	
    	xPos=unitFollow.getxPos();
    	yPos=unitFollow.getyPos();
    	
    }
    
    /** Returns the minimum x value on screen 
     */
    public int getMinX(){

    	return -screenwidth/2;
    }
    
    /** Returns the maximum x value on screen 
     */
    public int getMaxX(){
    	
    	//96*72 is the maximum width of map in pixel
    	return 96*72-screenwidth/2; 
    }
    
    /** Returns the minimum y value on screen 
     */
    public int getMinY(){

    	return -screenheight/2;	
    }
    
    /** Returns the maximum y value on screen 
     */
    public int getMaxY(){
    	
    	//96*72 is the maximum height of map in pixel
    	return 96*72-screenheight/2; 
    }

    /** Tells the camera to follow a given unit. 
     */
    public void followUnit(Player unit)
    throws SlickException
    {
    	this.unitFollow=unit;
    }
    
}
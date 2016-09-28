/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Your name> <Your login>
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
    /** Create a new World object. */
	TiledMap TiledMap;
	
	private Player player1;
	private Camera move;
	private Image Player;
	private final int halfw=RPG.screenwidth/2,halfh=RPG.screenheight/2;
	private int xPos,yPos;
	static final int tile=72; 
	
    public World()
    throws SlickException
    {
    	TiledMap=new TiledMap("assets/map.tmx","assets");
    	player1=new Player(Player);
    	move=new Camera(player1,RPG.screenwidth,RPG.screenheight);
    	xPos=move.getxPos();
    	yPos=move.getyPos();
        // TODO: Fill in
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(double dir_x, double dir_y, int delta)
    throws SlickException
    {
    	
    	/*xpos and ypos are the coordinate of map, but in the
    	 *left-top corner of screen,plposx and plposy for match
    	 *the coordinate of the position where player standing.
    	 *cause player will drawcenterd, feeler for match the 
    	 *feet of the player standing, making it looks more natural
    	*/
    	final int feeler=18;
    	int plposx=xPos+halfw; 
    	int plposy=yPos+halfh+feeler; 
    	
    	int i;
    	int check;
    	
    	/*the feelers in direct arrays are using for check block tiles
    	 *around the player,direct1 for left,right, direct2 for up,down */
    	int[] direct1={plposx,plposx,plposx-feeler,plposx+feeler};
    	int[] direct2={plposy+feeler,plposy-feeler,plposy,plposy};
    	
    	/*chckTiles[]: up:0, down:1, left:2, right:3*/
    	int checkTiles[]=new int[4];
    		
    	for (i=0;i<4;i++){
    		if (direct1[i]-halfw+feeler<=move.getMaxX()&&
    				direct2[i]-halfh+feeler<=move.getMaxY()){
	    		check=TiledMap.getTileId(direct1[i]/tile,direct2[i]/tile,0);
	    		checkTiles[i]=Integer.parseInt(TiledMap.getTileProperty(check,
	    				"block", "0"));
	    	}
    	}
    	
    	/*the if statements restrict player walk out the edges of
    	 *map and walk to the block tiles*/	
    	xPos+=dir_x*delta;
       	if(xPos>move.getMaxX()-tile/2||xPos<move.getMinX()||
       			(checkTiles[2]==1&&dir_x==-1)||(checkTiles[3]==1&&dir_x==1)){
       		xPos-=dir_x*delta;
       		
       	}
   	
   		yPos+=dir_y*delta;
   		if(yPos>move.getMaxY()-tile/2||yPos<move.getMinY()||
   				(checkTiles[0]==1&&dir_y==1)||(checkTiles[1]==1&&dir_y==-1)){
       		yPos-=dir_y*delta;
   		}
   		
   		/*save the coordinate for player1 in world map*/
   		player1.setyPos(yPos);
   		player1.setxPos(xPos);
    }


    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {

    	TiledMap.render(-player1.getxPos()%tile,-player1.getyPos()%tile,
    			player1.getxPos()/tile,player1.getyPos()/tile,13,10);
    	
    	/*player always display in the center of the screen*/
    	player1.player.drawCentered(halfw,halfh);
    	
    }

}
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	Image player;
	private int xPos=756/2; //the starting point of player in world map
	private int yPos=684/2;
	
	

    Player(Image player)
    throws SlickException
    {
    	this.player=new Image("assets/units/player.png");
    }


	public int getxPos() {
		return xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	
    
    

}

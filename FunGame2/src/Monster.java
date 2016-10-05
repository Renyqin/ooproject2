import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Monster extends Unit{
	private Image MonsterImage;
	private double width, height;
	private String type;
	private static final double PSPEED=0.2, ASPEED=0.25;
	private int timer =0;
	private int waitTime=3000;
	private static final int dangerTime=5000;
	private final static String Passive="passive";
	private final static String Aggressive="aggressive";
	private int dangerDetector=dangerTime;
	private static int detectDistance=150;
	private static final int feeler=3;
	
	double x_sign;
	double y_sign;

	
	public Monster(int MaxHp, int MaxDamage, int rate,String name, 
			int xPos, int yPos, String ImagePath, String type) 
	throws SlickException 
	{
		super(MaxHp, MaxDamage, rate, name, xPos, yPos);
		MonsterImage=new Image(ImagePath);
		this.type=type;
		this.width=MonsterImage.getWidth();
		this.height=MonsterImage.getHeight();
	}


	public String getType() {
		return type;
	}
	
	public void render(Graphics g){
		
		MonsterImage.drawCentered((int)getxPos(), (int)getyPos());
		HealthBar(g, getxPos(), getyPos(), getName());
		
	}
	
	public void wander(double delta, World world){
		Random randomx=new Random();
		Random randomy=new Random();
		
		/*randomly chose direction of x and y, from -1 to 1*/
		int randomX=(randomx.nextInt(3)-1); 
		int randomY=(randomy.nextInt(3)-1);

		
		timer+=delta;
		
		/*change direction once hit the waittime*/
		if (timer>waitTime){
			timer=0;	//initialize timer
			x_sign=randomX;
			y_sign=randomY;
		}
		
		double new_x=getxPos()+x_sign*delta*PSPEED;
		double new_y=getyPos()+y_sign*delta*PSPEED;
       
		
		if(!world.terrainBlocks(new_x + x_sign * width / feeler, getyPos() + height / feeler) 
                && !world.terrainBlocks(new_x + x_sign * width / feeler, getyPos() - height / feeler)) {
			setxPos(new_x);
        }
		
        // Then move in y
  
        if(!world.terrainBlocks(getxPos() + width / feeler, new_y + y_sign * height / feeler) 
                && !world.terrainBlocks(getxPos() - width / feeler, new_y + y_sign * height / feeler)){
            setyPos(new_y);
        }			
	}
	
	public boolean safe(int delta){
		if (dangerDetector<=dangerTime){
			dangerDetector+=delta;
		}
		if (dangerDetector>dangerTime){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public int getDangerDetector() {
		return dangerDetector;
	}


	public void setDangerDetector(int dangerDetector) {
		this.dangerDetector = dangerDetector;
	}


	public void escape(boolean attack, int delta, Player player, World world, int dir_x, int dir_y){
		if (safe(delta)==false){
			double dx,dy;
			
			dx=dmove(player.getX(),getxPos(),player.getY(),getyPos(),PSPEED*delta);
			dy=dmove(player.getY(),getyPos(),player.getX(),getxPos(),PSPEED*delta);
			
			if (!world.terrainBlocks(getxPos()+dx, getyPos()+dy)){
				setxPos(getxPos()+dx);
				setyPos(getyPos()+dy);
			}
		}
	}

	
		
	public double dmove(double x1, double x2, double y1, double y2,double delta){
		return dirDistance(x1,x2)/distance(x1,y1,x2,y2)*delta;
		
	}
	
	
	public void followPlayer(Player player, int delta){
		if (distance(player.getX(),player.getY(),getxPos(),getyPos())<detectDistance){
			double dx,dy;
			dx=dmove(player.getX(),getxPos(),player.getY(),getyPos(),ASPEED*delta);
			dy=dmove(player.getY(),getyPos(),player.getX(),getxPos(),ASPEED*delta);
			
				setxPos(getxPos()-dx);
				setyPos(getyPos()-dy);
			
		}
		
		
	}
	
	public void attackPlayer(Player player, int delta){
		Random rDamage=new Random();
		int randomDamage=(rDamage.nextInt(getMaxDamage()+1));
		if (distanceOK(getxPos(),getyPos(),player.getX(),player.getY())&&cooldown(delta)){
			player.setHp(player.getHp()-randomDamage);
			setCooldown(getRate());
		}
	}
	
	
	public void update(boolean attack,int delta, Player player, World world,int dir_x, int dir_y){
		if (this.type.equals(Passive)){
			if (safe(delta)){
				wander(delta, world);
			}else{
				escape(attack, delta, player, world,dir_x,dir_y);
			}
		}
		if (this.type.equals(Aggressive)){
			followPlayer(player, delta);
			attackPlayer(player, delta);
		}
	}



	
	
	
	
	
	
	

}

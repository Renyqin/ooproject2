import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Unit {
	private int MaxHp;
	private int MaxDamage;
	private int rate;
	private double health;
	private double xPos;
	private double yPos;
	private int Hp;
	private static final int distance=50;
	private String name;
	private int cooldown=rate;
	
	public Unit(int MaxHp, int MaxDamage, int rate,String name, int xPos, int yPos){
		this.MaxHp=MaxHp;
		this.MaxDamage=MaxDamage;
		this.rate=rate;
		this.Hp=MaxHp;
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
		
	};
	Unit(int MaxHp, int MaxDamage, int rate){
		this.MaxHp=MaxHp;
		this.MaxDamage=MaxDamage;
		this.rate=rate;
		this.Hp=MaxHp;
	}
	
	Unit(int MaxHp,int xPos, int yPos, String name){
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
		this.MaxHp=MaxHp;
		this.Hp=MaxHp;
	}

	public int getMaxHp() {
		return MaxHp;
	}

	public int getMaxDamage() {
		return MaxDamage;
	}

	public int getRate() {
		return rate;
	}

	public double getHealth() {
		return health;
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}
	public int getHp() {
		return Hp;
	}
	public String getName() {
		return name;
	}
	
	
	
	public void setHp(int Hp) {
		this.Hp = Hp;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}


	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	
	public void HealthBar(Graphics g, double xPos, double yPos, String name){
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
        
        int bar_x = (int)xPos-72/2;  // TODO: magic number
        int bar_y = (int)yPos-72/2-20;    // TODO: MAGIC NUMBER
        int bar_width = 75;
        int bar_height = 20;
        float health_percent = (float)Hp/MaxHp; 
        int hp_bar_width = (int) (bar_width * health_percent);
        int name_x=bar_x + (bar_width - g.getFont().getWidth(name)) / 2;
        int name_y=bar_y;  
        
       /* if(hp_bar_width<0){
        	hp_bar_width=0;
        }*/
        
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(name, name_x, name_y);
	}
	
	
	private double sqr(double x){
		return x*x;
	}
	
	public double dirDistance(double x1, double x2){
		return x2-x1;
	}
	
	public double distance(double x1, double y1, double x2, double y2){
		return Math.sqrt(sqr(dirDistance(x1, x2))+sqr(dirDistance(y1, y2)));
	}
	
	public boolean distanceOK(double x1, double y1, double x2, double y2){
		
			if (distance(x1, y1, x2,y2)<distance){
				return true;
			}else{
				return false;
			}
	}
	
	public boolean cooldown(int delta){
		if (cooldown>=0){
			cooldown-=delta;
		}
		if (cooldown<=0){
			return true;
		}else{
			return false;
		}
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public int getCooldown() {
		return cooldown;
	}
	
	
	
	

}

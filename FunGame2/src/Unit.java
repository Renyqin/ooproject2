import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Unit {
	private int MaxHp;
	private int MaxDamage;
	private int rate;
	private double health;
	private int xPos;
	private int yPos;
	private int Hp;
	private int distance=100;
	private String name;
	
	public Unit(int MaxHp, int MaxDamage, int rate, int Hp, int xPos, int yPos){
		this.MaxHp=MaxHp;
		this.MaxDamage=MaxDamage;
		this.rate=rate;
		this.Hp=Hp;
		health=(double)Hp/MaxHp;
		this.xPos=xPos;
		this.yPos=yPos;
		
	};
	Unit(int MaxHp, int MaxDamage, int rate, int Hp){
		this.MaxHp=MaxHp;
		this.MaxDamage=MaxDamage;
		this.rate=rate;
		this.Hp=Hp;
		//health=(double)Hp/MaxHp;
	}
	
	Unit(int Hp, int MaxHp,int xPos, int yPos, String name){
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
		this.Hp=Hp;
		this.MaxHp=MaxHp;
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

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
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
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/**from solution of workshop4*/
	private double sqr(double x){
		return x*x;
	}
	
	public void HealthBar(Graphics g, int xPos, int yPos, String name){
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
        
        int bar_x = xPos-72/2;  // TODO: magic number
        int bar_y = yPos-72/2-20;    // TODO: MAGIC NUMBER
        int bar_width = 65;
        int bar_height = 20;
        float health_percent = Hp/MaxHp; 
        int hp_bar_width = (int) (bar_width * health_percent);
        int name_x=bar_x + (bar_width - g.getFont().getWidth(name)) / 2;
        int name_y=bar_y;  
        
        
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(name, name_x, name_y);
	}
	
	public boolean distanceOK(double x1, double y1, double x2, double y2){
			if ((double)Math.sqrt(sqr(x2-x1)+sqr(y2-y1))<distance){
				return true;
			}else{
				return false;
			}
	}
	
	

}

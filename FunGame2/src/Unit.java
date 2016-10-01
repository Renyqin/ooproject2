
public class Unit {
	private int MaxHp;
	private int MaxDamage;
	private int rate;
	private double health;
	private int xPos;
	private int yPos;
	private int Hp;
	
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
		health=(double)Hp/MaxHp;
	}
	
	Unit(int xPos, int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
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
	
	
	
	public void setHp(int Hp) {
		this.Hp = Hp;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	

}

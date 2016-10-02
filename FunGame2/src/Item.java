import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Item {
	private int xPos, yPos;
	private static int distance=50;

	private Image ItemImage;
	private boolean pickup=false;
	private boolean getSword=false, getTome=false, getAmulet=false, getElixir=false;
	
	public Item(int xPos, int yPos, String ImagePath)
	throws SlickException
	{
		this.xPos=xPos;
		this.yPos=yPos;
		
		ItemImage=new Image(ImagePath);
		
		
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	
	public boolean isPickup() {
		return pickup;
	}
	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}
	

	public Image getItemImage() {
		return ItemImage;
	}
	
	
	
	
	public boolean isGetSword() {
		return getSword;
	}
	public void setGetSword(boolean getSword) {
		this.getSword = getSword;
	}
	public boolean isGetTome() {
		return getTome;
	}
	public void setGetTome(boolean getTome) {
		this.getTome = getTome;
	}
	public boolean isGetAmulet() {
		return getAmulet;
	}
	public void setGetAmulet(boolean getAmulet) {
		this.getAmulet = getAmulet;
	}
	public boolean isGetElixir() {
		return getElixir;
	}
	public void setGetElixir(boolean getElixir) {
		this.getElixir = getElixir;
	}
	/**from solution of workshop4*/
	private double sqr(double x){
		return x*x;
	}
	
	public boolean distanceOK(double x1, double y1, double x2, double y2){
			if ((double)Math.sqrt(sqr(x2-x1)+sqr(y2-y1))<distance){
				return true;
			}else{
				return false;
			}
	}
	
	
	public void render(){
		ItemImage.drawCentered(xPos, yPos);
		
	}
	
	
	public abstract void PickUp(Player player);
}



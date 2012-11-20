package shapelauncher;

public class Missile {
	private int x;
	private int y;
	private int theta;
	private Shape shape;
	
	public Missile(){
		x = 0;
		y = 0;
		theta = 0;
	}
	
	public void move(int dx, int dy){
		
	}
	
	public int getXPosition(){
		return x;
	}
	
	public int getYPosition(){
		return y;
	}
	
	public int getTheta(){
		return theta;
	}
	
	public void rotate(int dtheta){
		
	}
}

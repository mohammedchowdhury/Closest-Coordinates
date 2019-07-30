//Mohammed Chowdhury 
public class Node {
	private double distance; 
	private int x; 
	private int y; 

	Node(String x,String y){
		this.x = Integer.parseInt(x); 
		this.y = Integer.parseInt(y); 
		distance = 0; 
	}

	public void setDistance(double d) {
		distance = d; 
	}

	public int getX() {
		return x; 
	}

	public int getY() {
		return y; 
	}
	public double getDistance() {
		return distance; 
	}

}
//Mohammed Chowdhury 
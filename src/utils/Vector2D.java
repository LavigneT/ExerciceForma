package utils;

public class Vector2D {

	private float x, y;
	private float length;
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
		length = (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	
	//getters and setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}


	public float getLength() {
		return length;
	}


	public void setLength(float length) {
		this.length = length;
	}
	
	
}

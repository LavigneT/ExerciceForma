package utils;

public class Vector2D {

	private float x, y;
	private float length;
	
	/**
	 * Construit un vecteur dont le deplacement sur l'axe des absisses = x et sur les ordonnés = y
	 * Lors de la construction, on calcul la longeur du vecteur
	 * 
	 * @param x
	 * @param y
	 */
	public Vector2D(float x, float y) {
		setX(x);
		setY(y);
		try {
			setLength((float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
		} catch (Exception e) {e.printStackTrace();}
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


	public void setLength(float length) throws Exception {
		if(length >= 0) {
			this.length = length;
		} else {
			throw new Exception("Longeur negative");
		}
	}
	
	
}

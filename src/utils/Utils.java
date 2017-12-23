package utils;

import Main.formes.Point2D;

public class Utils {

	/**
	 * 
	 * @param p1 First point
	 * @param p2 Second point
	 * @return Vector 2D
	 */
	public static Vector2D vectorFromPoints(Point2D p1, Point2D p2) {
		return new Vector2D(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}
	
	/**
	 * Project v1 into v2
	 * Rappel de la formule : kv  =  |w| (wu · vu) vu 
	 * 
	 * @param v1
	 * @param v2
	 * @return Vecteur orthogonal à v2
	 */
	public static Vector2D projection(Vector2D v1, Vector2D v2) {
		
		Vector2D result = null;
		
		float cosinus = ((v1.getX()/v1.getLength()) * (v2.getX()/v2.getLength()) + (v1.getY()/v1.getLength()) * (v2.getY())/v2.getLength());
		float kvX = v1.getLength() * cosinus * (v2.getX()/v2.getLength());
		float kvY = v1.getLength() * cosinus * (v2.getY()/v2.getLength());
		
		float resultX = v1.getX() - kvX;
		float resultY = v1.getY() - kvY;
		
		result = new Vector2D(resultX, resultY);
		
		return result;
	}
	
	public static float dotProduct(Vector2D v1, Vector2D v2) {
		return (v1.getX()*v2.getX() + v1.getY()*v2.getY());
	}
	
	public static float getSinus(Vector2D v1, Vector2D v2) {
		float cosinus = ((v1.getX()/v1.getLength()) * (v2.getX()/v2.getLength()) + (v1.getY()/v1.getLength()) * (v2.getY())/v2.getLength());
		
		return (float)Math.sin(Math.acos(cosinus));
	}
	
}

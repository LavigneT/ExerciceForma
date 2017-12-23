package Main.formes;


import utils.Segment;
import utils.Utils;
import utils.Vector2D;

public class Cercle extends Forme{
	
	/**
	 * Creer un cercle a partir de deux points
	 * 
	 * @param points
	 * @throws Exception
	 */
	public Cercle(Point2D[] points) throws Exception {
		super(null);
		if(points.length ==2) {
			super.setPoints(points);
		} else {
			throw new Exception("Nombre de pts invalide");
		}
	}
	
	//2PI * r
	@Override
	public float getPerimeter() throws Exception {
		Vector2D rayon = Utils.vectorFromPoints(points[0], points[1]);
		return (float)(2 * Math.PI * rayon.getLength());
	}
	
	// PI * r^2
	@Override
	public float getSurface() throws Exception {
		Vector2D rayon = Utils.vectorFromPoints(points[0], points[1]);
		return (float)(Math.PI * Math.pow(rayon.getLength(), 2));
	}

	@Override
	public Segment[] getDiagonal() throws Exception {
		throw new Exception("Un cercle n'a pas de diagonales");		
	}

	@Override
	public Segment[] getHeight() throws Exception {
		throw new Exception("Un cercle n'a pas de hauteur");
	}
}

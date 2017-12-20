package Main.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import utils.Segment;
import utils.Utils;
import utils.Vector2D;



public class Triangle2D extends Forme{
	
	public enum typeTriangle{
		acutangle, obtusangle, rectangle
	}

	private typeTriangle type;
	private int idAngleObtuOuRectangle= -1;
	
	public Triangle2D(Point2D[] points) throws Exception{
		super(null, null);
		if(points.length == 3) {
			super.setPoints(points);
			setTypeTriangle();
		} else {
			throw new Exception("Invalids points");
		}
	}
	
	/*
	 * Notons lors du calcul des "dot product" il est important que les deux vecteurs dont ont calcul l'angle partent d'un même point
	 * de plus rappelons que si le "dot product" est :
	 * - negatif, le triangle est obtusangle
	 * - positif, le triangle est acutangle 
	 * - ==0, le triangle est rectangle
	 */
	/**
	 * Determine le type de triangle, et lui attibut une enumeration en fonction du resultat du calculs des "dot products" de ses angles
	 */
	private void setTypeTriangle() {
		
		float[] dotPros = {Utils.dotProduct(Utils.vectorFromPoints(points[0], points[1]), Utils.vectorFromPoints(points[0], points[2])),
				Utils.dotProduct(Utils.vectorFromPoints(points[1], points[0]), Utils.vectorFromPoints(points[1], points[2])),
				Utils.dotProduct(Utils.vectorFromPoints(points[2], points[0]), Utils.vectorFromPoints(points[2], points[1]))};
		
		
		for(int x = 0; x < 3; x++) {
			if(dotPros[x] == 0) {
				type = typeTriangle.rectangle;
				idAngleObtuOuRectangle = x;
			} else if(dotPros[x] < 0) {
				type = typeTriangle.obtusangle;
				idAngleObtuOuRectangle = x;
			}
		}
		
		if(type == null)
			type = typeTriangle.acutangle;
	}

	@Override
	public float getPerimeter() {
		Vector2D side1 = Utils.vectorFromPoints(points[0], points[1]);
		Vector2D side2 = Utils.vectorFromPoints(points[1], points[2]);
		Vector2D side3 = Utils.vectorFromPoints(points[2], points[0]);
		
		return side1.getLength() + side2.getLength() + side3.getLength();
	}

	@Override
	public float getSurface() {
		return 1;
	}

	@Override
	public Segment[] getDiagonal() throws Exception {
		throw new Exception("Un triangle n'a pas de diagonales");
	}

	@Override
	public Segment[] getHeight() throws Exception {
		Segment[] result = null;
		
		if(type == typeTriangle.acutangle) {
			Vector2D h1 = Utils.projection(Utils.vectorFromPoints(points[0], points[1]), Utils.vectorFromPoints(points[1], points[2]));
			Vector2D h2 = Utils.projection(Utils.vectorFromPoints(points[1], points[2]), Utils.vectorFromPoints(points[2], points[0]));
			Vector2D h3 = Utils.projection(Utils.vectorFromPoints(points[2], points[0]), Utils.vectorFromPoints(points[0], points[1]));
		
			result = new Segment[] {new Segment(points[0], new Point2D(points[0].getX() + h1.getX(), points[0].getY() + h1.getY()), h1.getLength()),
					new Segment(points[1], new Point2D(points[1].getX() + h2.getX(), points[1].getY() + h2.getY()), h2.getLength()),
					new Segment(points[2], new Point2D(points[2].getX() + h3.getX(), points[2].getY() + h3.getY()), h3.getLength())
			};
		
		} else if(type == typeTriangle.obtusangle || type == typeTriangle.rectangle) {
			if(idAngleObtuOuRectangle == 0) {
				Vector2D h1 = Utils.projection(Utils.vectorFromPoints(points[0], points[1]), Utils.vectorFromPoints(points[1], points[2]));
				result = new Segment[] {new Segment(points[0], new Point2D(points[0].getX() + h1.getX(), points[0].getY() + h1.getY()), h1.getLength())};
				
			} else if(idAngleObtuOuRectangle == 1) {
				Vector2D h1 = Utils.projection(Utils.vectorFromPoints(points[1], points[0]), Utils.vectorFromPoints(points[0], points[2]));
				result = new Segment[] {new Segment(points[1], new Point2D(points[1].getX() + h1.getX(), points[1].getY() + h1.getY()), h1.getLength())};
			} else if(idAngleObtuOuRectangle == 2) {
				Vector2D h1 = Utils.projection(Utils.vectorFromPoints(points[2], points[1]), Utils.vectorFromPoints(points[1], points[0]));
				result = new Segment[] {new Segment(points[2], new Point2D(points[2].getX() + h1.getX(), points[2].getY() + h1.getY()), h1.getLength())};
			} else if(idAngleObtuOuRectangle == -1) {
				throw new Exception();
			}
		}
		
		return result;
	}

	public typeTriangle getType() {
		return type;
	}

	
}

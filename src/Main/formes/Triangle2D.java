package Main.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import utils.Segment;
import utils.Utils;
import utils.Vector2D;



public class Triangle2D extends Forme{

	
	
	public Triangle2D(Point2D[] points, Color c) throws Exception{
		super(null, null);
		if(points.length == 3) {
			super.setPoints(points);
			super.setC(c);
		} else {
			throw new Exception("Invalids points");
		}
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
		Vector2D side1 = Utils.vectorFromPoints(points[0], points[1]);
		Vector2D side2 = Utils.vectorFromPoints(points[1], points[2]);
		return (side1.getLength() * side2.getLength()) / 2;
	}

	@Override
	public Segment[] getDiagonal() throws Exception {
		throw new Exception("Triangles don't have diagonales");
	}


	@Override
	public Segment[] getHeight() {
		Vector2D h1 = Utils.projection(Utils.vectorFromPoints(points[0], points[1]), Utils.vectorFromPoints(points[1], points[2]));
		Vector2D h2 = Utils.projection(Utils.vectorFromPoints(points[1], points[2]), Utils.vectorFromPoints(points[2], points[0]));
		Vector2D h3 = Utils.projection(Utils.vectorFromPoints(points[2], points[0]), Utils.vectorFromPoints(points[0], points[1]));
		
		Segment[] result = {new Segment(points[0], new Point2D(points[0].getX() + h1.getX(), points[0].getY() + h1.getY()), h1.getLength()),
				new Segment(points[1], new Point2D(points[1].getX() + h2.getX(), points[1].getY() + h2.getY()), h2.getLength()),
				new Segment(points[2], new Point2D(points[2].getX() + h3.getX(), points[2].getY() + h3.getY()), h3.getLength())
		};
		return result;
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
}

package Main.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import utils.Segment;
import utils.Utils;
import utils.Vector2D;

public class Rectangle extends Forme{

	public Rectangle(Point2D[] points, Color c) throws Exception{
		super(null, null);
		if(points.length == 4) {
			super.setC(c);
			super.setPoints(points);
		} else {
			throw new Exception("Invalid points");
		}
	}

	@Override
	public float getPerimeter() throws Exception {
		Vector2D side1 = Utils.vectorFromPoints(points[0], points[1]);
		Vector2D side2 = Utils.vectorFromPoints(points[1], points[2]);
		
		return side1.getLength() * 2 + side2.getLength() * 2;
	}

	@Override
	public float getSurface() throws Exception {
		Vector2D side1 = Utils.vectorFromPoints(points[0], points[1]);
		Vector2D side2 = Utils.vectorFromPoints(points[1], points[2]);
		return side1.getLength() * side2.getLength();
	}

	@Override
	public Segment[] getDiagonal() throws Exception {
		Vector2D diago1 = Utils.vectorFromPoints(points[0], points[2]);
		Vector2D diago2 = Utils.vectorFromPoints(points[1], points[3]);
		
		Segment[] result = {new Segment(points[0], points[2], diago1.getLength()), new Segment(points[1], points[3], diago2.getLength())};
		return result;
	}

	@Override
	public Segment[] getHeight() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}

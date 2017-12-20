package Main.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import utils.Segment;
import utils.Utils;
import utils.Vector2D;

public class Square extends Forme{
	
	/**
	 * Points must be typed in the right order (for instance top, right, bottom, left)
	 * @param points x, y coordinates of the 4 points
	 * @param c Square's color
	 * @throws Exception If points doesn't contains exactly 4 points
	 */
	public Square(Point2D[] points, Color c) throws Exception{
		super(null, null);
		if(points.length == 4) {
			super.setPoints(points);
			super.setC(c);
		} else {
			throw new Exception("Invalid points");
		}
	}

	
	//methods
	
	@Override
	public float getPerimeter() {
		Vector2D side = Utils.vectorFromPoints(points[0], points[1]);
		return side.getLength() * 4;
	}

	@Override
	public float getSurface() {
		Vector2D side = Utils.vectorFromPoints(points[0], points[1]);
		return side.getLength() * side.getLength();
	}

	@Override
	public Vector2D[] getDiagonal() {
		
		return new Vector2D[] {Utils.vectorFromPoints(points[0], points[3]), Utils.vectorFromPoints(points[1], points[2])};
	}

	@Override
	public Segment[] getHeight() {
		Vector2D side = Utils.vectorFromPoints(points[0], points[2]);
		return null;
	}


	@Override
	public void render(Graphics2D g) {
		
			
		
	}

}

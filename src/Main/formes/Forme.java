package Main.formes;

import java.awt.Color;

import java.awt.Graphics2D;

import utils.Segment;
import utils.Vector2D;

public abstract class Forme {
	
	protected Point2D[] points;
	protected Color c;
	
	public Forme(Point2D[] points, Color c) {
		this.points = points;
		this.c = c;
	}
	
	
	/**
	 * Calculate the form's perimeter 
	 * @return Form's perimeter
	 */
	public abstract float getPerimeter() throws Exception;
	
	/**
	 * Calculate the form's perimeter
	 * @return Forms perimeter
	 */
	public abstract float getSurface() throws Exception;
	
	//TODO Work a better system to get diagonals
	/**
	 * Return an two segments representing the diagonals. 
	 * @return vector2D
	 */
	public abstract Segment[] getDiagonal() throws Exception;
	
	/**
	 * Calculate the height and return a segment
	 * @return
	 */
	public abstract Segment[] getHeight() throws Exception;
	
	/**
	 * Pass a graphics2D object to render you forms on the frame
	 * 
	 * @param g
	 */
	public abstract void render(Graphics2D g);
	
	
	//getters and setters
	
	public Color getC() {
		return c;
	}
	
	public void setC(Color c) {
		this.c = c;
	}

	public Point2D[] getPoints() {
		return points;
	}

	public void setPoints(Point2D[] points) {
		this.points = points;
	}
}

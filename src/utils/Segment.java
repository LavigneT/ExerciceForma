package utils;

import Main.formes.Point2D;

public class Segment {

	private Point2D p1, p2;
	
	/**
	 * Un segment est composer de 2 pts 
	 * 
	 * @param x
	 * @param y
	 */
	public Segment(Point2D p1, Point2D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	//Getters and setters

	public Point2D getP1() {
		return p1;
	}

	public void setP1(Point2D p1) {
		this.p1 = p1;
	}

	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2 = p2;
	}
	
	
	
	
	
	
}

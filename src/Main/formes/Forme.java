package Main.formes;




import utils.Segment;


public abstract class Forme {
	
	protected Point2D[] points;
	
	public Forme(Point2D[] points) {
		this.points = points;
	}
	
	
	/**
	 * Calcul le perimetre d'une forme
	 * @return Perimetre de la forme
	 */
	public abstract float getPerimeter() throws Exception;
	
	/**
	 * Calcul la surface d'une forme
	 * @return Surface de la forme
	 */
	public abstract float getSurface() throws Exception;
	
	/**
	 * Diagonales de la forme, retourner sous forme de segment
	 * @return Segment
	 */
	public abstract Segment[] getDiagonal() throws Exception;
	
	/**
	 * Retourne un / des segment(s) qui symbolise la hauteur de la forme 
	 * @return
	 */
	public abstract Segment[] getHeight() throws Exception;
	
	
	//getters and setters
	
	public Point2D[] getPoints() {
		return points;
	}

	public void setPoints(Point2D[] points) {
		this.points = points;
	}
}

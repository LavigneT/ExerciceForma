package JUnitTest;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;


import java.awt.Color;

import org.junit.jupiter.api.Test;

import Main.formes.Forme;
import Main.formes.Point2D;
import Main.formes.Rectangle;
import Main.formes.Square;
import Main.formes.Triangle2D;

class TestForms {
	
	/**
	 * Test the square class
	 */
	@Test
	void testSquare() {
		
		try {
			Forme test1 = new Square(new Point2D[] {new Point2D(10.0f, 10.0f), new Point2D(20.0f, 10.0f), 
					new Point2D(10.0f, 20.0f), new Point2D(20.0f, 20.f)}, Color.red);
			
			assertEquals(test1.getPerimeter(), 40, 0.05);
			assertEquals(test1.getHeight()[0].getLength(), 10, 0.1);
			assertEquals(test1.getDiagonal()[0].getP1().getX(), 10);
			assertEquals(test1.getDiagonal()[0].getP1().getY(), 10);
			assertEquals(test1.getDiagonal()[1].getP2().getX(), 20);
			assertEquals(test1.getDiagonal()[1].getP2().getY(), 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestTriangle() {
		
		try {
			Triangle2D test1 = new Triangle2D(new Point2D[] {new Point2D(4.0f, 0), new Point2D(6.0f, 4.0f), new Point2D(0, 4.0f)}, Color.black);
			
			assertEquals(test1.getPerimeter(), 6 + Math.sqrt(20) + Math.sqrt(32), 0.1);
			assertEquals(test1.getHeight()[0].getP1().getX(), 4);
			assertEquals(test1.getHeight()[0].getP1().getY(), 0);
			assertEquals(test1.getHeight()[0].getP2().getX(), 4);
			assertEquals(test1.getHeight()[0].getP2().getY(), 4);
			
			assertEquals(test1.getHeight()[1].getP1().getX(), 6);
			assertEquals(test1.getHeight()[1].getP1().getY(), 4);
			assertEquals(test1.getHeight()[1].getP2().getX(), 3, 0.1);
			assertEquals(test1.getHeight()[1].getP2().getY(), 1, 0.1);
			
			assertEquals(test1.getHeight()[2].getP1().getX(), 0);
			assertEquals(test1.getHeight()[2].getP1().getY(), 4);
			assertEquals(test1.getHeight()[2].getP2().getX(), 4.5, 0.4);
			assertEquals(test1.getHeight()[2].getP2().getY(), 1.5, 0.4);
			
			try {
				test1.getDiagonal();
			} catch(Exception e) {
				assertTrue(e != null);
			}
			
			
		} catch (Exception e) {
			fail("");
			e.printStackTrace();
		}
	}
	
	@Test
	void TestRectanle() {
		
		try {
			Rectangle test1 = new Rectangle(new Point2D[] {new Point2D(0, 0), new Point2D(10.0f, 0), new Point2D(10.0f, 20.0f), new Point2D(0, 20.0f)}, Color.red);
			
			assertEquals(test1.getPerimeter(), 60, 0.1);
			assertEquals(test1.getSurface(), 200, 0.1);
			
			assertEquals(test1.getDiagonal()[0].getP1().getX(), 0);
			assertEquals(test1.getDiagonal()[0].getP1().getY(), 0);
			assertEquals(test1.getDiagonal()[0].getP2().getX(), 10);
			assertEquals(test1.getDiagonal()[0].getP2().getY(), 20);
			
			
		} catch (Exception e) {
			fail("");
			e.printStackTrace();
		}
		
		
	}

}

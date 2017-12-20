package JUnitTest;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;


import java.awt.Color;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.junit.jupiter.api.Test;

import Main.formes.Forme;
import Main.formes.Point2D;
import Main.formes.Rectangle;
import Main.formes.Square;
import Main.formes.Triangle2D;
import utils.Utils;
import utils.Vector2D;

class TestForms {
	
	/**
	 * Test the square class
	 */
	@Test
	void testSquare() {
		
		try {
			Forme test1 = new Square(new Point2D[] {new Point2D(10.0f, 10.0f), new Point2D(20.0f, 10.0f), 
					new Point2D(10.0f, 20.0f), new Point2D(20.0f, 20.f)});
			
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
	void TestDotProduct() {
		Vector2D v1 = new Vector2D(1, 2);
		Vector2D v2 = new Vector2D(3, 4);
		
		assertEquals(Utils.dotProduct(v1, v2), 11, 0.1);
		
		Vector2D v3 = new Vector2D(2, 2);
		Vector2D v4 = new Vector2D(3, -2);
		assertEquals(Utils.dotProduct(v3, v4), 2, 0.1);
		
		Vector2D v5 = new Vector2D(4, -1);
		Vector2D v6 = new Vector2D(0, 3);
		assertEquals(Utils.dotProduct(v5, v6), -3, 0.1);
		
		Vector2D v7 = new Vector2D(2, 0);
		Vector2D v8 = new Vector2D(0, 2);
		assertEquals(Utils.dotProduct(v7, v8), 0, 0.1);
	}
	//TODO cosinus a refaire
	@Test
	void TestSinus() {
		Vector2D v1 = new Vector2D(0, 2);
		Vector2D v2 = new Vector2D(2, 0);
		assertEquals(Utils.getSinus(v1, v2), 1);
		
		Vector2D v3 = new Vector2D(0, 2);
		Vector2D v4 = new Vector2D(0, 2);
		assertEquals(Utils.getSinus(v3, v4), 0);
		
		Vector2D v5 = new Vector2D(0, 1);
		Vector2D v6 = new Vector2D(0.707f, 0.707f);
		assertEquals(Utils.getSinus(v5, v6), Math.sqrt(2)/2, 0.001);
		
		Vector2D v7 = new Vector2D(0, 1);
		Vector2D v8 = new Vector2D(-0.966f, 0.259f);
		assertEquals(Utils.getSinus(v7, v8), (Math.sqrt(6) - Math.sqrt(2))/4, 0.001);
		
	}
	
	/**
	 * Test de l'enum qui determine si le triangle est obtusangle, rectangle ou acutangle
	 */
	@Test
	void TestTypeTriangle() {
		try {
			Triangle2D test1 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(2, 1), new Point2D(0, 3)});
			assertEquals(test1.getType(), Triangle2D.typeTriangle.acutangle);
			
			Triangle2D test2 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(5, 1), new Point2D(0, 3)});
			assertEquals(test2.getType(), Triangle2D.typeTriangle.acutangle);
			
			Triangle2D test3 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(1, 2), new Point2D(0, 5)});
			assertEquals(test3.getType(), Triangle2D.typeTriangle.obtusangle);
			
			Triangle2D test4 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(0, 2), new Point2D(0, 2)});
			assertEquals(test4.getType(), Triangle2D.typeTriangle.rectangle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestHeightTriangle() {
		try {
			Triangle2D test1 = new Triangle2D(new Point2D[] {new Point2D(1, 2), new Point2D(0, 5), new Point2D(0, 0)});
			assertEquals(test1.getHeight().length, 1);
			assertEquals(test1.getHeight()[0].getP1().getX(), 1);
			assertEquals(test1.getHeight()[0].getP1().getY(), 2);
			assertEquals(test1.getHeight()[0].getP2().getX(), 0);
			assertEquals(test1.getHeight()[0].getP2().getY(), 2);
			
			Triangle2D test2 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(1, 2), new Point2D(0, 5)});
			assertEquals(test2.getHeight().length, 1);
			assertEquals(test2.getHeight()[0].getP1().getX(), 1);
			assertEquals(test2.getHeight()[0].getP1().getY(), 2);
			assertEquals(test2.getHeight()[0].getP2().getX(), 0);
			assertEquals(test2.getHeight()[0].getP2().getY(), 2);
			
			Triangle2D test3 = new Triangle2D(new Point2D[] {new Point2D(0, 5), new Point2D(0, 0), new Point2D(1, 2)});
			assertEquals(test3.getHeight().length, 1);
			assertEquals(test3.getHeight()[0].getP1().getX(), 1);
			assertEquals(test3.getHeight()[0].getP1().getY(), 2);
			assertEquals(test3.getHeight()[0].getP2().getX(), 0);
			assertEquals(test3.getHeight()[0].getP2().getY(), 2);
			
			Triangle2D test4 = new Triangle2D(new Point2D[] {new Point2D(0, 0), new Point2D(5, 3), new Point2D(0, 5)});
			assertEquals(test4.getHeight().length, 3);
			assertEquals(test4.getHeight()[0].getP1().getX(), 0);
			assertEquals(test4.getHeight()[0].getP1().getY(), 0);
			assertEquals(test4.getHeight()[0].getP2().getX(), 1.7, 0.1);
			assertEquals(test4.getHeight()[0].getP2().getY(), 4.3, 0.1);
			
			assertEquals(test4.getHeight()[1].getP1().getX(), 5);
			assertEquals(test4.getHeight()[1].getP1().getY(), 3);
			assertEquals(test4.getHeight()[1].getP2().getX(), 0, 0.1);
			assertEquals(test4.getHeight()[1].getP2().getY(), 3, 0.1);
			
			assertEquals(test4.getHeight()[2].getP1().getX(), 0);
			assertEquals(test4.getHeight()[2].getP1().getY(), 5);
			assertEquals(test4.getHeight()[2].getP2().getX(), 2.3, 0.2);
			assertEquals(test4.getHeight()[2].getP2().getY(), 1.5, 0.2);
		} catch (Exception e) {
			fail("");
			e.printStackTrace();
		}
	}
	
	
	@Test
	void TestRectanle() {
		
		try {
			Rectangle test1 = new Rectangle(new Point2D[] {new Point2D(0, 0), new Point2D(10.0f, 0), new Point2D(10.0f, 20.0f), new Point2D(0, 20.0f)});
			
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

package JUnitTest;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;


import java.awt.Color;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.junit.jupiter.api.Test;

import Main.formes.Cercle;
import Main.formes.Forme;
import Main.formes.Point2D;
import Main.formes.Rectangle;
import Main.formes.Square;
import Main.formes.Triangle2D;
import utils.Utils;
import utils.Vector2D;

class TestForms {

	
	//----------------------------------------------------------Utils---------------------------------------------------
	
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
		
		Vector2D v7 = new Vector2D(1, 0);
		Vector2D v8 = new Vector2D(-0.966f, 0.259f);
		assertEquals(Utils.getSinus(v7, v8), (Math.sqrt(6) - Math.sqrt(2))/4, 0.001);
		
		Vector2D v9 = new Vector2D(1, 0);
		Vector2D v10 = new Vector2D(-1.732f, 1f);
		assertEquals(Utils.getSinus(v9, v10), 0.5, 0.001);
		
	}
	
	//------------------------------------------------------------Carre----------------------------------------------------
	
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
		} catch (Exception e) { fail(""); e.printStackTrace();}
	}
	
	//---------------------------------------------------------Triangle-----------------------------------------------------
	
	@Test
	void TestAireTriangle() {
		try {
			Triangle2D test1 = new Triangle2D(new Point2D[] {new Point2D(0, 2), new Point2D(2, 0), new Point2D(2, 4)});
			assertEquals(test1.getSurface(), 4, 0.1);
			
			Triangle2D test2 = new Triangle2D(new Point2D[] {new Point2D(1, 0), new Point2D(0, 3), new Point2D(4, 3)});
			assertEquals(test2.getSurface(), 6, 0.1);
		} catch (Exception e) { fail(""); e.printStackTrace();}
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
		} catch (Exception e) { fail(""); e.printStackTrace();}
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
		} catch (Exception e) { fail(""); e.printStackTrace();}
	}
	
	//-----------------------------------------------------------Rectangle-------------------------------------------------------
	
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
			
			
		} catch (Exception e) { fail(""); e.printStackTrace();}
	}

	//-------------------------------------------------------Cercle-------------------------------------------------------------
	
	@Test 
	void TestWrongCercle() {
		try {
			Cercle test1 = new Cercle(new Point2D[] {new Point2D(0, 0)});
			fail("");
		} catch (Exception e) {
			assertTrue(e != null);
		}
		
		try {
			Cercle test2 = new Cercle(new Point2D[] {});
			fail("");
		} catch (Exception e) {
			assertTrue(e != null);
		}
		
		try {
			Cercle test1 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(0, 0), new Point2D(0, 0)});
			fail("");
		} catch (Exception e) {
			assertTrue(e != null);
		}
	}
	
	@Test
	void TestGoodCercle() {
		try {
			Cercle test1 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(1, 1)});
			assertEquals(test1.getPoints()[0].getX(), 0);
			assertEquals(test1.getPoints()[0].getY(), 0);
			assertEquals(test1.getPoints()[1].getX(), 1);
			assertEquals(test1.getPoints()[1].getY(), 1);
			
			Cercle test2 = new Cercle(new Point2D[] {new Point2D(-2.1f, 3.8f), new Point2D(0.09f, -1)});
			assertEquals(test2.getPoints()[0].getX(), -2.1f, 0.001);
			assertEquals(test2.getPoints()[0].getY(), 3.8f, 0.001);
			assertEquals(test2.getPoints()[1].getX(), 0.09f, 0.001);
			assertEquals(test2.getPoints()[1].getY(), -1, 0.001);
		} catch (Exception e) { fail(""); e.printStackTrace();}
	}
	
	@Test
	void TestPerimeterCercle() {
		try {
			Cercle test1 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(0, 1)});
			assertEquals(test1.getPerimeter(), Math.PI * 2, 0.001);
			
			Cercle test2 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(-0.5f, 0.866f)});
			assertEquals(test2.getPerimeter(), Math.PI * 2, 0.001);
			
			Cercle test3 = new Cercle(new Point2D[] {new Point2D(-1, 0), new Point2D(0, 0)});
			assertEquals(test3.getPerimeter(), Math.PI * 2, 0.001);
			
			Cercle test4 = new Cercle(new Point2D[] {new Point2D(-0.707f, -0.707f), new Point2D(0, 0)});
			assertEquals(test4.getPerimeter(), Math.PI * 2, 0.001);
			
			Cercle test5 = new Cercle(new Point2D[] {new Point2D(-2, 0), new Point2D(0, 0)});
			assertEquals(test5.getPerimeter(), Math.PI * 4, 0.001);
			
		} catch (Exception e) { fail(""); e.printStackTrace();}
	}
	
	@Test
	void TestCercleSurface() {
		Cercle test1;
		try {
			test1 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(0, 2)});
			assertEquals(test1.getSurface(), 12.56, 0.01);
			
			test1 = new Cercle(new Point2D[] {new Point2D(0, 0), new Point2D(-2.5f, 0)});
			assertEquals(test1.getSurface(), 19.63, 0.01);
			
			test1 = new Cercle(new Point2D[] {new Point2D(-0.707f, -0.707f), new Point2D(0, 0)});
			assertEquals(test1.getSurface(), Math.PI, 0.01);
			
		} catch (Exception e) { fail(""); e.printStackTrace();}
		
	}
	
}

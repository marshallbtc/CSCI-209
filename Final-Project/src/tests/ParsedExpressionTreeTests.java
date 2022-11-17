package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * @author Collective Eternals Group
 * 
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode f = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), f);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Subtraction(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode f = parser.makeExpression("x-y");
		assertEquals(new Subtraction(new X(), new Y()), f);

		e = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Subtraction(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y - [ -.51, 0, 1]");
		assertEquals(new Subtraction(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void UnaryFunctionTests() {
		
		
		
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tan(new Addition(new X(), new Y())), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e1);
		
		// no spaces!
		ExpressionTreeNode f = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), f);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	    e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
		
	
		ExpressionTreeNode f1 = parser.makeExpression("ceil(x)");
		assertEquals(new Ceil(new X()), f1);
		
		ExpressionTreeNode e2 = parser.makeExpression("ceil( x + y )");
		assertEquals(new Ceil(new Addition(new X(), new Y())), e2);
		
	
		
		ExpressionTreeNode e4 = parser.makeExpression("ceil(floor(x))");
		assertEquals(new Ceil(new Floor( new X())),e4);
		
		
		ExpressionTreeNode e5 = parser.makeExpression("abs( x + y )");
		assertEquals(new Abs(new Addition(new X(), new Y())), e5);
		
		ExpressionTreeNode e6 = parser.makeExpression("abs(x)");
		assertEquals(new Abs (new X()), e6);
		
		ExpressionTreeNode e7 = parser.makeExpression("ceil(abs(x+y))");
		assertEquals(new Ceil(new Abs(new Addition(new X(), new Y()))),e7);
		
		ExpressionTreeNode e8 = parser.makeExpression("wrap(x)");
		assertEquals(new Wrap(new X()), e8);
		
		ExpressionTreeNode e9 = parser.makeExpression("wrap(x+y)");
		assertEquals(new Wrap(new Addition(new X(), new Y())), e9);
		
		
		ExpressionTreeNode e10= parser.makeExpression("tan(ceil(x))");
		assertEquals(new Tan( new Ceil( new X())),e10);
		
		ExpressionTreeNode e11= parser.makeExpression("tan(x)");
		assertEquals(new Tan(new X()), e11);
		
		
		
		
		ExpressionTreeNode e14= parser.makeExpression("cos(ceil(x))");
		assertEquals(new Cos(new Ceil(new X())),e14);
		
		ExpressionTreeNode e15= parser.makeExpression("cos(x)");
		assertEquals(new Cos(new X()), e15);
		
		ExpressionTreeNode e16= parser.makeExpression("cos(x+y)");
		assertEquals(new Cos(new Addition(new X(), new Y())), e16);
		
		
		ExpressionTreeNode e17= parser.makeExpression("log(ceil(x))");
		assertEquals(new Log( new Ceil( new X())),e17);
		
		
		ExpressionTreeNode e18= parser.makeExpression("log(x+y)");
		assertEquals(new Log(new Addition(new X(), new Y())), e18);
		
	
		
		ExpressionTreeNode e20= parser.makeExpression("atan(x)");
		assertEquals(new Atan(new X()), e20);
		
		ExpressionTreeNode e21= parser.makeExpression("atan(ceil(x))");
		assertEquals(new Atan( new Ceil( new X())),e21);
		
		
		ExpressionTreeNode e22= parser.makeExpression("atan(x+y)");
		assertEquals(new Atan(new Addition(new X(), new Y())), e22);
		
	
		
		ExpressionTreeNode e23= parser.makeExpression("atan(x*y)");
		assertEquals(new Atan(new Multiplication(new X(),new Y())), e23);
		
		ExpressionTreeNode e24= parser.makeExpression("atan(x-y)");
		assertEquals(new Atan(new Subtraction(new X(),new Y())), e24);

		
	}
		
		@Test
		public void ImagerelatedTests(){
		
		ExpressionTreeNode e25= parser.makeExpression("perlinColor(x,y)");
		assertEquals(new PerlinColor(new X(),new Y()),e25);
		
		ExpressionTreeNode e26= parser.makeExpression("imageWrap(\"sin.jpg\",x,y)");
		assertEquals(new ImageWrap("sin.jpg",new X(),new Y()),e26);
		
		ExpressionTreeNode e27= parser.makeExpression("imageClip(\"sin.jpg\",x,y)");
		assertEquals(new ImageClip("sin.jpg",new X(),new Y()),e27);
		
		
		
		}
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
	
		
		
	
		/*
		ExpressionTreeNode e14= parser.makeExpression("sin(x)");
		assertEquals(new Sin( new X()), e14);
		
		ExpressionTreeNode e15= parser.makeExpression("sin(x+y)");
		assertEquals(new Sin(new Addition(new X(), new Y())), e15);
		
		
		ExpressionTreeNode e16= parser.makeExpression("sin(ceil(x))");
		assertEquals(new Sin( new Ceil( new X())),e16);
		*/
		
	}
	/**
	 * 
	@Test
	public void clampFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("clamp( x )");
		assertEquals(new Clamp(new X()), e);

		e = parser.makeExpression("clamp( x + y )");
		assertEquals(new Clamp(new Addition(new X(), new Y())), e);		
	}
	*/


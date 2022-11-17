
package tests;

import picasso.model.ImprovedNoise;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	// Before every tester method, create an ExpressionTreeGenerator called parser
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	// Test the evaluation of an input constant expression
	@Test
	public void testConstantEvaluation() {
		// Create the ExpressionTreeNode with the expression we want to test,
		// make sure the input expression is equal to the ExpressionTreeNode,
		// then make sure the expression is equal to the evaluated ExpressionTreeNode for every whole number in the bounds [-1, 1]
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	// Test the evaluation of the X variable
	@Test
	public void testXEvaluation() {
		// Create the X,
		// then make sure the evaluated X object is equal its corresponding RGBColor for every whole number in the bounds [-1, 1]
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	
	// Test the evaluation of the Y variable
	@Test
	public void testYEvaluation() {
		// Create the Y,
		// then make sure the evaluated Y object is equal its corresponding RGBColor for every whole number in the bounds [-1, 1]
		Y y = new Y();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), y.evaluate(i, i));
		}
	}

	
	// Test the evaluation of the tan() unary function
	@Test 	
	public void testtanevaluation(){
		// Create an ExpressionTreeNode with the expression we want to test,
		ExpressionTreeNode e = parser.makeExpression("tan(x)");
		// Then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values 
		// are evaluated with tan() for every whole number in the bounds [-1, 1]

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), e.evaluate(i, i));
		}

	}

	
	// Test the evaluation of the abs() unary function
	@Test
	public void testabsevaluation(){
		//Create an ExpressionTreeNode with the expression we want to test,
		ExpressionTreeNode e = parser.makeExpression("abs(x)");
		// then	make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values 
		// are evaluated with tan() for every whole number in the bounds [-1, 1]
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), e.evaluate(i, i));
		}
	}
	
	// Test the evaluation of the log() unary function
	@Test
	public void testLogEvaluation(){
		// Create an ExpressionTreeNode with the expression we want to test
		ExpressionTreeNode e = parser.makeExpression("log(x)");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// make sure the evaluated expression is equal to the RGBColor object whose R, G, and B absolute values
			// are evaluated with log()
			int j = Math.abs(i);
			assertEquals(new RGBColor(Math.log(j), Math.log(j), Math.log(j)), e.evaluate(i, i));
		}
	}
	
	// Test the evaluation of the exp() unary function
	@Test
	public void testExpEvaluation(){
		// Create an ExpressionTreeNode with the expression we want to test
		ExpressionTreeNode e = parser.makeExpression("exp(x)");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated with the Math.pow(a,b) function, where a is the constant Euler's number
			assertEquals(new RGBColor(Math.pow(2.71828, i),Math.pow(2.71828, i),Math.pow(2.71828, i)), e.evaluate(i, i));
		}
	}
	
	// Test the evaluation of the ceil() unary function
	@Test
	public void Testceilevalutation(){
		// Create an ExpressionTreeNode with the expression we want to test
		ExpressionTreeNode e = parser.makeExpression("ceil(x)");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated with the Math.ceil(a) function
			assertEquals(new RGBColor(Math.ceil(i),Math.ceil(i),Math.ceil(i)),e.evaluate(i,i));
						  
		}
	}
	
	// Test the evaluation of nested functions
	@Test
	public void Testnestedevalutaion(){
		// Create an ExpressionTreeNode with the expression we want to test
		ExpressionTreeNode e = parser.makeExpression("ceil(x)+tan(x)");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated as they should with the given expression "ceil(x)+tan(x)"
			assertEquals(new RGBColor(Math.ceil(i)+Math.tan(i),Math.ceil(i)+Math.tan(i),Math.ceil(i)+Math.tan(i)),e.evaluate(i, i));
					
		}
	}
		
	
	@Test
	public void Testtrignestedfunctions() {
		ExpressionTreeNode e = parser.makeExpression("ceil(floor(x))");

		for (int i = -1; i <= 1; i++) {


			assertEquals(new RGBColor(Math.ceil(Math.floor(i)),Math.ceil(Math.floor(i)),Math.ceil(Math.floor(i))),e.evaluate(i,i));
				
		}
	}
	
	// Test the Perlincolor multi-argument function
	@Test
	public void TestPerlincolor() {
		// Create an ExpressionTreeNode with the expression we want to test
		ExpressionTreeNode e = parser.makeExpression("perlinColor(x,x)");
		// For every whole number in the bounds [-1, 1],

		for (int i = -1; i <= 1; i++) {
			// create new X and Y objects,
			X x2 = new X();
			X y2 = new X();
			// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
			RGBColor left = x2.evaluate(i, i);
			RGBColor right = y2.evaluate(i, i);

			// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated as they should be by the PerlinColor function
			assertEquals(new RGBColor(ImprovedNoise.noise(left.getRed() + 0.3, right.getRed() + 0.3, 0),ImprovedNoise.noise(left.getGreen() - 0.8, right.getGreen() -0.8, 0),ImprovedNoise.noise(left.getBlue() +0.1, right.getBlue() +0.1, 0)),e.evaluate(i, i));
				
		}
	}
	
	// TODO: make sure these javadocs are correct
	// Test the ImageWrap multi-argument function
	@Test
	public void TestImagewrap() {
		// Create an ExpressionTreeNode with the expression we want to test,
		// as well as an image object
		ExpressionTreeNode e = parser.makeExpression("imageWrap(\"sin.jpg\",x,y)");
		ImageFunctions image = new ImageFunctions("sin.jpg");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// Create new X and Y objects,

			X x2 = new X();
			Y y2 = new Y();
			// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree.
			RGBColor left = x2.evaluate(i, i);
			RGBColor right = y2.evaluate(i, i);

			// Now use MathHelp to wrap the values of the Blue in each leaf
			double xcoord = MathHelp.wrapvalue(left.getBlue());
			double ycoord = MathHelp.wrapvalue(right.getBlue());
			// Create new wrapped X and Y images
			int newX = image.domainToImageScale(xcoord,image.getSize().width-1);
			int newY = image.domainToImageScale(ycoord,image.getSize().height-1);
			// Then make sure the evaluated expression is equal to the color of our wrapped image
			assertEquals(new RGBColor(image.getColor(newX,newY)),e.evaluate(i, i));		
		
		}
	}
	
	// TODO: make sure these javadocs are correct
	// Test the ImageClip multi-argument function
	@Test
	public void TestImageClip() {
		// Create an ExpressionTreeNode with the expression we want to test,
		// as well as an image object
		ExpressionTreeNode e = parser.makeExpression("imageClip(\"sin.jpg\",x,y)");
		ImageFunctions image = new ImageFunctions("sin.jpg");
		// For every whole number in the bounds [-1, 1],
		for (int i = -1; i <= 1; i++) {
			// Create new X and Y objects,

			X x2 = new X();
			Y y2 = new Y();
			// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree.
			RGBColor left = x2.evaluate(i, i);
			RGBColor right = y2.evaluate(i, i);

			// Now use MathHelp to clamp the values of the Blue in each leaf
			double xcoord = MathHelp.clampvalue(left.getBlue());
			double ycoord = MathHelp.clampvalue(right.getBlue());
			// Create new wrapped X and Y images
			int newX = image.domainToImageScale(xcoord,image.getSize().width-1);
			int newY =image.domainToImageScale(ycoord, image.getSize().height-1);
			// Then make sure the evaluated expression is equal to the color of our clipped image
			assertEquals(new RGBColor(image.getColor(newX,newY)),e.evaluate(i, i));		
		
		}
		
	}

	// Test the RgbToYCrCb multi-argument function
	@Test
	public void TestRgbToYCrCb() {
		
		ExpressionTreeNode e = parser.makeExpression("RgbToYCrCb(x)");
		
		for (int i = -1; i <= 1; i++) {
			X x = new X();
			// then evaluate that object into an RGBColor object
			RGBColor result = x.evaluate(i, i);
			// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated as they should be by the function
			assertEquals(new RGBColor(result.getRed() * 0.2989 + result.getGreen() * 0.5866 + result.getBlue() * 0.1145,result.getRed() * -0.1687 + result.getGreen() * -0.3312 + result.getBlue() * 0.5,result.getRed() * 0.5000 + result.getGreen() * -0.4183 + result.getBlue() * -0.0816),e.evaluate(i,i));
			
		}
		
	}
	
	
	
	@Test
	public void TestYCrCbtoRGB() {
		
		ExpressionTreeNode e = parser.makeExpression("YCrCbtoRGB(x)");
		
		for (int i = -1; i <= 1; i++) {
			X x = new X();
			// then evaluate that object into an RGBColor object
			RGBColor result = x.evaluate(i, i);
			// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated as they should be by the function
			assertEquals(new RGBColor(result.getRed() + result.getBlue() * 1.4022,result.getRed() + result.getGreen() * -0.3456 + result.getBlue() * -0.7145,result.getRed() + result.getGreen() * 1.7710),e.evaluate(i,i));
			
		}
		
	}
	
	
	
	

	@Test
	public void testAddition() {

		ExpressionTreeNode e = parser.makeExpression("x+y");

		for (int i = -1; i <= 1; i++) {
			X x2 = new X();
			Y y2 = new Y();
			// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
			RGBColor left = x2.evaluate(i, i);
			RGBColor right = y2.evaluate(i, i);

			// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
			// are evaluated as they should be by the addition operator
			assertEquals(new RGBColor(left.getRed()+right.getRed(),left.getGreen()+right.getGreen(),left.getBlue()+right.getBlue()),e.evaluate(i, i));
				
		}

	}

		@Test
		public void testSubstraction() {
			
			ExpressionTreeNode e = parser.makeExpression("x-y");
			
			for (int i = -1; i <= 1; i++) {
				X x2 = new X();
				Y y2 = new Y();
				// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
				RGBColor left = x2.evaluate(i, i);
				RGBColor right = y2.evaluate(i, i);
				// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
				// are evaluated as they should be by the subtraction operator
				assertEquals(new RGBColor(left.getRed()-right.getRed(),left.getGreen()-right.getGreen(),left.getBlue()-right.getBlue()),e.evaluate(i, i));
			
			}
			
		}

		
		
			// Test the Multiplication operator
			@Test
			public void testMultiplication() {
				// Create an ExpressionTreeNode with a tester expression
				ExpressionTreeNode e = parser.makeExpression("x*y");
				// For every whole number in the bounds [-1, 1],
				for (int i = -1; i <= 1; i++) {
					// create new X and Y objects,
					X x2 = new X();
					Y y2 = new Y();
					// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
					RGBColor left = x2.evaluate(i, i);
					RGBColor right = y2.evaluate(i, i);
					// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
					// are evaluated as they should be by the multiplication operator
					assertEquals(new RGBColor(left.getRed()*right.getRed(),left.getGreen()*right.getGreen(),left.getBlue()*right.getBlue()),e.evaluate(i, i));
					
				}
				
			}
			
						    
			    // Test the Division operator
				@Test
				public void testDivision() {
					// Create an ExpressionTreeNode with a tester expression
					ExpressionTreeNode e = parser.makeExpression("x/y");
					// For every whole number in the bounds [-1, 1],
					for (int i = -1; i <= 1; i++) {
						// create new X and Y objects,
						X x2 = new X();
						Y y2 = new Y();
						// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
						RGBColor left = x2.evaluate(i, i);
						RGBColor right = y2.evaluate(i, i);
						// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
						// are evaluated as they should be by the division operator
						if (!(i==0)) {
							assertEquals(new RGBColor(left.getRed()/right.getRed(),left.getGreen()/right.getGreen(),left.getBlue()/right.getBlue()),e.evaluate(i, i));
						}
					}
						
				}
					
				
				// Test the Modulus operator
				@Test
				public void testModulus() {
					// Create an ExpressionTreeNode with a tester expression
					ExpressionTreeNode e = parser.makeExpression("x%y");
					// For every whole number in the bounds [-1, 1],
					//int i = 0;
					for (int i = -1; i <= 1; i++) {
						// create new X and Y objects,
						X x2 = new X();
						Y y2 = new Y();
						// then evaluate those objects into RGBColor objects as the left and right leaves in the expression tree,
						RGBColor left = x2.evaluate(i, i);
						RGBColor right = y2.evaluate(i, i);
						// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
						// are evaluated as they should be by the modulus operator
						if (!(i==0)) {
							assertEquals(new RGBColor(left.getRed()%right.getRed(),left.getGreen()%right.getGreen(),left.getBlue()%right.getBlue()),e.evaluate(i, i));
						}

					}
					
				}
				
				// Test the Exponent operator
				@Test
				public void testExponentiation() {
					// Create an ExpressionTreeNode with a tester expression
					ExpressionTreeNode e = parser.makeExpression("x^y");
					// For every whole number in the bounds [-1, 1],
					for (int i = -1; i <= 1; i++) {
						// Create an X and Y object,
						X x2 = new X();
						Y y2 = new Y();
						// then evaluate those objects into RGBColor objects as the leaves in the expression tree,
						RGBColor left = x2.evaluate(i, i);
						RGBColor right = y2.evaluate(i, i);
						// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
						// are evaluated as they should be by the modulus operator
						assertEquals(new RGBColor(Math.pow(left.getRed(), right.getRed()),Math.pow(left.getGreen(), right.getGreen()),Math.pow(left.getBlue(), right.getBlue())),e.evaluate(i, i));
						
					}
					
				}
				
				// Test the Negate operator
				@Test
				public void testNegate() {
					// Create an ExpressionTreeNode with a tester expression
					ExpressionTreeNode e = parser.makeExpression("!x");
					// For every whole number in the bounds [-1, 1],
					for (int i = -1; i <= 1; i++) {
						// Create an X object,
						X x = new X();
						// then evaluate that object into an RGBColor object as the single leaf in the expression tree,
						RGBColor result = x.evaluate(i, i);
						// and then make sure the evaluated expression is equal to the RGBColor object whose R, G, and B values
						// are evaluated as they should be by the negate operator
						assertEquals(new RGBColor(-1.0*(result.getRed()),-1.0*(result.getGreen()),-1.0*(result.getBlue())),e.evaluate(i,i));
						
						}
					
				}


	// Assumes parser.makeExpression Works as Intended
	// Assumes evaluate works as intended
	@Test
	public void testAssign() {
		String[] eArray = new String[] { "q = y", "w = x", "q + w", "q = floor(q+w)", "q-w" };
		String[] eArray2 = new String[] { "y", "x", "y+x", "floor(y+x)", "(floor(y+x))-x" };

		for (int x = 0; x <= eArray.length - 1; x++) {
			ExpressionTreeNode e = parser.makeExpression(eArray[x]);
			ExpressionTreeNode e2 = parser.makeExpression(eArray2[x]);

			for (int i = -1; i <= 1; i++) {
				assertEquals(e.evaluate(i, i), e2.evaluate(i, i));
			}
		}

	}
}

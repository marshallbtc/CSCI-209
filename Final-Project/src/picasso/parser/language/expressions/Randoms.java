/**
 * 
 */
package picasso.parser.language.expressions;

import java.util.Random;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class Randoms extends ExpressionTreeNode {

	// nextInt as provided by Random is exclusive of the top value so you need to add 1 
	Random rand = new Random();
	private int max = 1;
	private int min = -1;
	/**
	 * 
	 */
	public Randoms() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		double red = rand.nextInt((max - min) + 1) + min;
		double green = rand.nextInt((max - min) + 1) + min;
		double blue = rand.nextInt((max - min) + 1) + min;

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Randoms)) {
			
			return false;
			
		}
		return true;
	}

}




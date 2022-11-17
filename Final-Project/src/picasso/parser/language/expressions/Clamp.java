/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author marshalljones
 *
 */
public class Clamp extends UnaryFunction {

	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the clamp of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the clamp of the expression's parameter
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red;
		double green;
		double blue;
		
		if (result.getRed() > 1) {
			red = 1;
		} else if (result.getRed() < -1) {
			red = -1;
		} else {
			red = result.getRed();
			}
		
		if (result.getGreen() > 1) {
			green = 1;
		} else if (result.getGreen() < -1) {
			green = -1;
		} else {
			green = result.getGreen();
			}
		
		if (result.getBlue() > 1) {
			blue = 1;
		} else if (result.getBlue() < -1) {
			blue = -1;
		} else {
			blue = result.getBlue();
			}

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
		if (!(obj instanceof Clamp)) {
			return false;
		}
		Clamp c = (Clamp) obj;
		return param.equals(c.param);
	}

}

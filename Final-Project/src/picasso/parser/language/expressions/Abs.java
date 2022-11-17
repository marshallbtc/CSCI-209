package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the absolute value function in the Picasso language.
 * 
 * @author Armando Mendez
 * 
 */
public class Abs extends UnaryFunction {

	/**
	 * Create a absolute value expression that takes as a parameter the given
	 * expression
	 * 
	 * @param param the expression to find absolute value
	 */
	public Abs(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the absolute
	 * value of the function's parameter.
	 * 
	 * @return the color from evaluating the absolute value of the expression's
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());

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
		if (!(obj instanceof Abs)) {
			return false;
		}
		Abs a = (Abs) obj;
		return param.equals(a.param);
	}

}
